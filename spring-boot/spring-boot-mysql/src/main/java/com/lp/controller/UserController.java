package com.lp.controller;

import com.lp.service.UserService;
import com.lp.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "")
    public ResultVO saveUser(String userName, String password) {
        ResultVO json = new ResultVO();
        try {
            this.userService.saveUser(userName, password);
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }

    @GetMapping(value = "/list/user")
    public ResultVO selectUserList() {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.userService.selectUserList());
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }


    @GetMapping(value = "/{id}")
    public ResultVO selectUserListById(@PathVariable String id) {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.userService.selectUserListById(id));
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }
    
}
