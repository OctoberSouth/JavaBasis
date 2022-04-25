package com.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @PostMapping
    public String test(@RequestParam String txt) {
        return restTemplate.postForEntity("http://lp-service/test?txt={0}", null, String.class, txt).getBody();
    }

}
