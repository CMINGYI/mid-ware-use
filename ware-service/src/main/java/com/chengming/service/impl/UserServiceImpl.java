package com.chengming.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chengming.mapper.UserMapper;
import com.chengming.service.UserService;
import com.chengming.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Name: UserServiceImpl
 * @Author: kitchening
 * @Date: 2023-03-25 18:27
 * @Description: UserServiceImpl
 * @Version: V1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
