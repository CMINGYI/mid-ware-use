package com.chengming.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: yichengming
 * @Date: 2021/09/11/20:30
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SheetRow {

    private int location;

    private List<String> positionList;
}
