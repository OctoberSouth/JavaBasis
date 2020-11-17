package com.lp.controller;

import com.lp.common.ResultJson;
import com.lp.entity.GitAutoRefreshConfig;
import com.lp.entity.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@RestController
public class TestController {

    @Autowired
    private GitConfig gitConfig;

    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;

    @GetMapping(value = "show")
    public ResultJson show(){
        return ResultJson.success(gitConfig);
    }

    @GetMapping(value = "autoShow")
    public Object autoShow(){
        return  ResultJson.success(gitAutoRefreshConfig);
    }
}
