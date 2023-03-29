package com.chengming.component;

import com.chengming.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Name: UserComponent
 * @Author: kitchening
 * @Date: 2023-03-25 17:44
 * @Description: UserComponent
 * @Version: V1.0
 */
@Component
public class UserComponent {

    @Resource
    private UserClient userClient;


    public String sayHello() {
        return userClient.sayHello();
    }
}
