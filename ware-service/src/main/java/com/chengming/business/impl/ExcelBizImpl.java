package com.chengming.business.impl;

import com.chengming.business.ExcelBiz;
import com.chengming.entity.CountingData;
import com.chengming.entity.Excel;
import com.chengming.entity.ExcelSheet;
import com.chengming.entity.SheetRow;
import com.chengming.enums.ClockInTypeEnum;
import com.chengming.service.ExcelService;
import com.chengming.utils.DateTimeUtil;
import com.chengming.utils.ExcelUtil;
import com.chengming.utils.FileUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Name: ExcelBizImpl
 * @Author: kitchening
 * @Date: 2023-03-25 18:34
 * @Description: ExcelBizImpl
 * @Version: V1.0
 */
@Component
public class ExcelBizImpl implements ExcelBiz {

    @Resource
    private ExcelService excelService;

    @Override
    public String countOvertimeHours(String filePath) {
        Excel excel = ExcelUtil.importExcel(filePath);
        Excel newExcel = new Excel();
        AtomicReference<Map<String, List<SheetRow>>> mapSheetRow = new AtomicReference<>();
        //遍历excel 根据姓名分为多个sheet
        assert excel != null;
        excel.getSheetList().forEach(excelSheet -> mapSheetRow.set(excelSheet.getRowList().stream().collect(Collectors.groupingBy(sheetRow -> sheetRow.getPositionList().get(0), Collectors.toList()))));
        //遍历多个sheet 分组后的sheet重新放入excel
        List<ExcelSheet> excelSheetList = Lists.newArrayListWithCapacity(32);
        mapSheetRow.get().forEach((s, sheetRows) -> {
            ExcelSheet newExcelSheet = new ExcelSheet();
            newExcelSheet.setName(s);
            newExcelSheet.setRowList(sheetRows);
            excelSheetList.add(newExcelSheet);
        });
        newExcel.setSheetList(excelSheetList);
        dealNewExcel(newExcel, filePath);
        return "success";
    }

    @Override
    public String countOvertimeHoursByTable(String filePath) {
        return null;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        return FileUtil.upload(multipartFile);
    }


    public void dealNewExcel(Excel excel, String filePath) {
        //遍历新的excel
        excel.getSheetList().forEach(excelSheet -> excelSheet.getRowList().forEach(sheetRow -> {
            List<String> positionList = Lists.newArrayListWithCapacity(5);
            if (sheetRow.getPositionList().size() > 2) {
                positionList.add(0, sheetRow.getPositionList().get(0));
                positionList.add(1, sheetRow.getPositionList().get(1));
                positionList.add(2, sheetRow.getPositionList().get(2));
                positionList.add(3, sheetRow.getPositionList().get(3));
                //上班时间
                Date arriveDate = DateTimeUtil.getDefaultDate();
                //下班时间
                Date leaveDate = DateTimeUtil.formatCountHourTime(sheetRow.getPositionList().get(3), ClockInTypeEnum.AFTERNOON.getType());
                //计算 工作时长 加班时长
                CountingData countingData = DateTimeUtil.getDifferFromTo(arriveDate, leaveDate);
                //判断是否节假日加班 是则当天上班时间则为加班时长 否则需计算
                positionList.add(4, countingData.getWorkingTime());
                sheetRow.setPositionList(positionList);
            }
        }));
        // 设置文件名
        String fileName = "加班时长统计-" + DateTimeUtil.getNowTime();
        excel.getSheetList().forEach(excelSheet -> {
            List<String> rowList = Lists.newArrayListWithCapacity(32);
            excelSheet.getRowList().forEach(sheetRow -> {
                if (sheetRow.getPositionList().size() >= 4) {
                    rowList.add(sheetRow.getPositionList().get(4));
                }
            });
            SheetRow sheetRow = new SheetRow();
            sheetRow.setLocation(excelSheet.getRowList().size());
            //组装最后的时分秒
            String total = rowList.stream().filter(row -> StringUtils.isNotBlank(row) && row.compareTo("00:00:00") >= 0).reduce((x1, x2) -> {
                String[] x1s = x1.split(":");
                String[] x2s = x2.split(":");
                int hours = Integer.parseInt(x1s[0]) + Integer.parseInt(x2s[0]);
                int minutes = Integer.parseInt(x1s[1]) + Integer.parseInt(x2s[1]);
                int seconds = Integer.parseInt(x1s[2]) + Integer.parseInt(x2s[2]);
                return hours + ":" + minutes + ":" + seconds;
            }).orElse("00:00:00");
            List<String> resultRowList = Lists.newArrayListWithCapacity(2);
            //将时分秒转换为秒数 重新处理时分秒
            resultRowList.add(0, "加班时长合计：");
            String[] totals = total.split(":");
            int seconds = Integer.parseInt(totals[2]) % 60;
            int minutes = (Integer.parseInt(totals[1]) + Integer.parseInt(totals[2]) / 60) % 60;
            Integer hours = Integer.parseInt(totals[0]) + (Integer.parseInt(totals[1]) + Integer.parseInt(totals[2]) / 60) / 60;
            String totalStr = hours + ":" + minutes + ":" + seconds;
            resultRowList.add(1, totalStr);
            sheetRow.setPositionList(resultRowList);
            excelSheet.getRowList().add(excelSheet.getRowList().size(), sheetRow);
        });
        //生成excel
        ExcelUtil.createExcel(excel, filePath, fileName);
    }
}
