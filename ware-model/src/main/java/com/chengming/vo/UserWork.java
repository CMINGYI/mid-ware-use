package com.chengming.vo;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * @Author: yichengming
 * @Date: 2021/11/04/19:24
 * @Description:
 */
@Data
public class UserWork {

    private Integer id;

    private String name;


    private Date workDate;


    private String beginTime;


    private String endTime;

    private DateTime createTime;

}
