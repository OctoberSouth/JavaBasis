package com.lp.controller;

import com.lp.common.ResultJson;
import org.springframework.web.bind.annotation.*;

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
        return new ResultJson(txt);
    }
}