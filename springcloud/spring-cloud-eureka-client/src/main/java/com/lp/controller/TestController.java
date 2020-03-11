package com.lp.controller;

import com.lp.common.ResultJson;
import org.springframework.web.bind.annotation.*;

/**
 * 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public ResultJson saveTest( @RequestParam String txt) {
        System.out.println(txt);
        return new ResultJson(txt);
    }
}
