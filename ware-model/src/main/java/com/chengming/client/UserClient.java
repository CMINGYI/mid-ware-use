package com.chengming.client;

import com.chengming.hystrix.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Name: UserClient
 * @Author: kitchening
 * @Date: 2023-03-25 17:41
 * @Description: UserClient
 * @Version: V1.0
 */
@FeignClient(value = "ware-service", fallback = UserClientFallBack.class)
public interface UserClient {

    @PostMapping("/user/sayHello")
    String sayHello();
}
