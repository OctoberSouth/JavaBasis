package com.lp.controller;

import com.lp.service.UserService;
import com.lp.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019年3月8日下午2:41:05
 * @describe
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    
    @PostMapping(value = "/test/mq")
    public ResultVO testMq(String value) {
        ResultVO json = new ResultVO();
        try {
            this.userService.testMq(value);
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }
}
