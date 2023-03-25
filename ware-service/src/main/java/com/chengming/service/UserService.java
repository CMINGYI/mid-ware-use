package com.chengming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chengming.vo.User;

import java.util.List;

/**
 * @Author: yichengming
 * @Date: 2021/10/28/23:15
 * @Description:
 */
public interface UserService extends IService<User> {

    List<User> getUserList();

}
