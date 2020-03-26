package com.lp.controller;

import com.lp.common.ResultJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${data.env}")
    private String defaultZone;


    @PostMapping
    public ResultJson saveTest() {
        System.out.println(defaultZone+"==================");
        return ResultJson.success(defaultZone);
    }
}
