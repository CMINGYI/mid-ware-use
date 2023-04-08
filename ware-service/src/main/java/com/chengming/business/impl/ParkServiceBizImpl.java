package com.chengming.business.impl;

import com.chengming.service.ParkService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Name: ParkServiceBizImpl
 * @Author: kitchening
 * @Date: 2023-04-06 23:16
 * @Description: ParkServiceBizImpl
 * @Version: V1.0
 */
@DubboService
public class ParkServiceBizImpl implements ParkService {
    @Override
    public String park() {
        return "park";
    }
}
