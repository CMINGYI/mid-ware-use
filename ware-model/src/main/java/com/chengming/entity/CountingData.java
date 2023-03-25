package com.chengming.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yichengming
 * @Date: 2021/09/12/0:44
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountingData {

    private String name;

    private String date;

    private String arriveTime;

    private String leaveTime;

    private String workingTime;

    private String extraTime;
}
