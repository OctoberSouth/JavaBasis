package com.lp.controller;

import com.lp.config.RedisUtil;
import com.lp.service.UserService;
import com.lp.vo.ResultVO;
import com.lp.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = {"用户相关"})
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @GetMapping(value = "/list")
    public ResultVO listUser() {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.userService.listUser());
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }


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

    @GetMapping(value = "/list/page")
    public ResultVO selectUserPage() {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.userService.selectUserPage());
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "保存所有的评论", response = UserVO.class)
    public ResultVO selectUserListById(
            @ApiParam(value = "评论id", required = true) @PathVariable String id) {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.userService.selectUserListById(id));
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }

    @PostMapping(value = "/saver/redis")
    public ResultVO saveRedis(String key, String value) {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.redisUtil.set(key, value));
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }

    @PostMapping(value = "/get/redis/by/key")
    public ResultVO getRedisByKey(String key) {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.redisUtil.get(key));
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }

    @GetMapping(value = "demo")
    public ResultVO demo() {
        ResultVO json = new ResultVO();
        try {
            this.userService.demo();
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }

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
