package com.chengming.controller;

import com.chengming.business.ExcelBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Name: ExcelController
 * @Author: kitchening
 * @Date: 2023-03-25 18:11
 * @Description: ExcelController
 * @Version: V1.0
 */
@RestController
@RequestMapping("/excel")
@Slf4j
@Api(tags = "Excel处理控制器")
public class ExcelController {

    @Autowired
    private ExcelBiz excelBiz;

    @PostMapping("/importExcel")
    @ApiOperation(value = "统计加班时长")
    public void importExcel(@RequestParam(value = "filePath") String filePath) {
        log.info("importExcel");
        excelBiz.countOvertimeHours(filePath);
    }

    @GetMapping("/solveUserWorkTime")
    public void solveUserWorkTime(@RequestParam(value = "filePath") String filePath) {
        excelBiz.countOvertimeHoursByTable(filePath);
    }
}
