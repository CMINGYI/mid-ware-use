package com.chengming.hystrix;

import com.chengming.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Name: UserClientFallBack
 * @Author: kitchening
 * @Date: 2023-04-06 22:35
 * @Description: UserClientFallBack
 * @Version: V1.0
 */
@Component
@Slf4j
public class UserClientFallBack implements UserClient {
    @Override
    public String sayHello() {
        log.warn("sayHello is not available");
        return "service is not available!!!";
    }
}
