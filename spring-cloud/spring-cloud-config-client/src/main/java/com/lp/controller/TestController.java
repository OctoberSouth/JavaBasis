package com.lp.controller;

import com.lp.common.ResultJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
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
