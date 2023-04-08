package com.chengming.controller;

import com.chengming.component.ParkComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.GET;

/**
 * @Name: ParkController
 * @Author: kitchening
 * @Date: 2023-04-08 19:46
 * @Description: ParkController
 * @Version: V1.0
 */
@RestController
@RequestMapping("/park")
public class ParkController {

    @Resource
    private ParkComponent parkComponent;

    @GetMapping("/toPark")
    public String park() {
        return parkComponent.park();
    }

}
