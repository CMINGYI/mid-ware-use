package com.chengming.business.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chengming.business.UserBiz;
import com.chengming.service.UserService;
import com.chengming.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Name: UserBizImpl
 * @Author: kitchening
 * @Date: 2023-03-25 18:25
 * @Description: UserBizImpl
 * @Version: V1.0
 */
@Component
@Slf4j
public class UserBizImpl implements UserBiz {

    @Resource
    private UserService userService;
    @Override
    public List<User> getUserList() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        List<User> list = userService.list(queryWrapper);
        log.info("获取用户列表：{}", JSON.toJSONString(list));
        return list;
    }

    @Override
    public List<User> userList() {
        List<User> userList = userService.list();
        log.info("获取用户列表结果：{}", userList);
        return userList;
    }
}
