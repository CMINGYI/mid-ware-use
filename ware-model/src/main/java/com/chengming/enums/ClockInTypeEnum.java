package com.chengming.enums;

import lombok.Getter;

/**
 * @Author: yichengming
 * @Date: 2021/09/12/2:06
 * @Description:
 */
@Getter
public enum ClockInTypeEnum {

    MORNING("1", "上班"),
    AFTERNOON("2", "下班");

    private final String type;

    private final String name;


    ClockInTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

}
