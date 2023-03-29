package com.chengming.utils;


import com.chengming.entity.Excel;
import com.chengming.entity.ExcelSheet;
import com.chengming.entity.SheetRow;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cm
 */
@Slf4j
public class ExcelUtil {


    public static Excel importExcel(String filePath) {

        File file = new File(filePath);
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
            Excel excel = new Excel();
            List<ExcelSheet> excelSheetList = Lists.newArrayListWithCapacity(16);

            workbook.forEach(sheet -> {
                ExcelSheet excelSheet = new ExcelSheet();
                List<SheetRow> sheetRows = Lists.newArrayListWithCapacity(30);
                sheet.forEach(row -> {

                    List cellList = Lists.newArrayListWithCapacity(30);

                    row.forEach(cell -> {
                        String cellValue = Strings.EMPTY;
                        DataFormatter dataFormatter = new DataFormatter();
                        if (null != cell) {
                            cellValue = dataFormatter.formatCellValue(cell);
                        }
                        cellList.add(cellValue);
                    });
                    SheetRow sheetRow = new SheetRow();
                    sheetRow.setLocation(row.getRowNum());
                    sheetRow.setPositionList(cellList);
                    sheetRows.add(sheetRow);
                });
                excelSheet.setRowList(sheetRows);
                excelSheet.setName(sheet.getSheetName());
                excelSheetList.add(excelSheet);
            });
            excel.setSheetList(excelSheetList);
            return excel;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static String createExcel(Excel excel, String filePath, String fileName) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            excel.getSheetList().stream().forEach(excelSheet -> {

                Sheet sheet = workbook.createSheet(excelSheet.getName());
                Row defaultRow = sheet.createRow(0);
                defaultRow.createCell(0).setCellValue("姓名");
                defaultRow.createCell(1).setCellValue("日期");
                defaultRow.createCell(2).setCellValue("上班时间");
                defaultRow.createCell(3).setCellValue("下班时间");
                defaultRow.createCell(4).setCellValue("加班时长");
                AtomicInteger rows = new AtomicInteger(1);
                excelSheet.getRowList().forEach(sheetRow -> {

                    Row row = sheet.createRow(rows.get());
                    AtomicInteger i = new AtomicInteger(0);
                    sheetRow.getPositionList().forEach(data -> {
                        row.createCell(i.get()).setCellValue(data);
                        i.addAndGet(1);
                    });
                    rows.addAndGet(1);
                });
            });
            //创建一个文件
            String fileDir = filePath.substring(0, filePath.lastIndexOf("/"));
            String suffix = filePath.substring(filePath.lastIndexOf("."));
            File file = new File(fileDir + "/" + fileName + suffix);
            file.createNewFile();
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();
            workbook.close();
        } catch (IOException e) {
            log.error("error:", e);
        }
        return null;
    }


    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] reshapedNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapedNums[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return reshapedNums;
    }

}
