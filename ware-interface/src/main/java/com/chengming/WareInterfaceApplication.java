package com.chengming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Name: WareInterfaceApplication
 * @Author: kitchening
 * @Date: 2023-03-25 16:41
 * @Description: WareInterfaceApplication
 * @Version: V1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class WareInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WareInterfaceApplication.class, args);
    }
}
