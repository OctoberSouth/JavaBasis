package com.lp.controller;

import com.lp.common.ResultJson;
import com.lp.service.NicknameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@RestController
@RequestMapping("/nickname")
public class NicknameController {


    @Resource
    private NicknameService nicknameService;

    @PostMapping("add")
    public ResultJson<String> add(@RequestParam String nickname) {
        this.nicknameService.add(nickname);
        return new ResultJson(nickname);
    }
}