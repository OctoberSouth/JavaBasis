package com.lp.controller;

import com.lp.common.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public String test(@RequestParam String txt) {
        return restTemplate.postForEntity("http://lp-service/service/test?txt={0}", null,  String.class,txt).getBody();
    }

}
