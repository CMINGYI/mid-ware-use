package com.chengming.service.impl;

import com.chengming.mapper.UserWorkMapper;
import com.chengming.service.ExcelService;
import com.chengming.vo.UserWork;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Name: ExcelServiceImpl
 * @Author: kitchening
 * @Date: 2023-03-25 18:31
 * @Description: ExcelServiceImpl
 * @Version: V1.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Resource
    private UserWorkMapper userWorkMapper;
    @Override
    public List<UserWork> getUserWorkList() {
        return userWorkMapper.getUserWorkList();
    }
}
