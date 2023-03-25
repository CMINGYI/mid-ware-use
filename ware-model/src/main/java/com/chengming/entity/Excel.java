package com.chengming.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @Author: yichengming
 * @Date: 2021/09/11/23:09
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Excel {

    private List<ExcelSheet> sheetList;
}
