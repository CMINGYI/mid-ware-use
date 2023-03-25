package com.chengming.controller;

import com.alibaba.fastjson.JSON;
import com.chengming.business.UserBiz;
import com.chengming.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Name: UserController
 * @Author: kitchening
 * @Date: 2023-03-25 17:03
 * @Description: UserController
 * @Version: V1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private UserBiz userBiz;
    @PostMapping("/sayHello")
    public String sayHello(){
        return "hello world!!!";
    }

    @PostMapping("/getUserList")
    public List<User> getUserList() {
        return userBiz.getUserList();
    }

    @PostMapping("/userList")
    public List<User> userList() {
        return userBiz.userList();
    }
}
