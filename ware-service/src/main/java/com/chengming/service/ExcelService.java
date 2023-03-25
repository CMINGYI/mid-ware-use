package com.chengming.service;

import com.chengming.vo.UserWork;

import java.util.List;

/**
 * @Name: ExcelService
 * @Author: kitchening
 * @Date: 2023-03-25 18:31
 * @Description: ExcelService
 * @Version: V1.0
 */
public interface ExcelService {

    /**
     * 获取工作时长列表
     *
     * @return
     */
    List<UserWork> getUserWorkList();
}
