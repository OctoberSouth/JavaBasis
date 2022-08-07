package com.lp.controller;

import com.lp.common.ResultJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public ResultJson saveTest(@RequestParam String txt) {
        System.out.println(txt);
        return ResultJson.success(txt);
    }
}