package com.chengming.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: yichengming
 * @Date: 2021/09/11/23:23
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelSheet {

    private String name;

    private List<SheetRow> rowList;
}
