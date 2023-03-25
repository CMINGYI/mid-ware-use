package com.chengming.business;

import com.chengming.vo.User;

import java.util.List;

/**
 * @Name: UserBiz
 * @Author: kitchening
 * @Date: 2023-03-25 18:25
 * @Description: UserBiz
 * @Version: V1.0
 */
public interface UserBiz {

    List<User> getUserList();


    List<User> userList();
}
