package com.lp.controller;

import com.lp.common.ResultJson;
import com.lp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

//    @Value("${data.env}")
//    private String defaultZone;

    @Autowired
    private TestService testService;

    @PostMapping
    public ResultJson saveTest( @RequestParam String txt) {
       //System.out.println(defaultZone+"==================");
        return testService.saveTest(txt);
    }
}
