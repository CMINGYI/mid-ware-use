package com.chengming.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Name: UserClient
 * @Author: kitchening
 * @Date: 2023-03-25 17:41
 * @Description: UserClient
 * @Version: V1.0
 */
@FeignClient("ware-service")
public interface UserClient {

    @PostMapping("/user/sayHello")
    String sayHello();
}
