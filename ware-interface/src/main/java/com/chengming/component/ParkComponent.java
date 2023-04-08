package com.chengming.component;

import com.chengming.service.ParkService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * @Name: ParkComponent
 * @Author: kitchening
 * @Date: 2023-04-06 23:20
 * @Description: ParkComponent
 * @Version: V1.0
 */

@Component
public class ParkComponent {


    @DubboReference
    private ParkService parkService;


    public String park() {
        return parkService.park();
    }
}
