package com.lp.controller;

import com.lp.common.ResultJson;
import com.lp.common.config.RedisUtil;
import com.lp.service.UserService;
import com.lp.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private UserService userService;

    private RedisUtil redisUtil;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @GetMapping(value = "/list")
    public ResultJson listUser() {
        ResultJson json = new ResultJson();
        try {
            json.setData(this.userService.listUser());
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }


    @PostMapping(value = "")
    public ResultJson saveUser(String userName, String password) {
        ResultJson json = new ResultJson();
        try {
            this.userService.saveUser(userName, password);
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }

    @GetMapping(value = "/list/user")
    public ResultJson selectUserList() {
        ResultJson json = new ResultJson();
        try {
            json.setData(this.userService.selectUserList());
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }

    @GetMapping(value = "/list/page")
    public ResultJson selectUserPage() {
        ResultJson json = new ResultJson();
        try {
            json.setData(this.userService.selectUserPage());
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "保存所有的评论", response = UserVo.class)
    public ResultJson selectUserListById(
            @ApiParam(value = "评论id", required = true) @PathVariable String id) {
        ResultJson json = new ResultJson();
        try {
            json.setData(this.userService.selectUserListById(id));
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }

    @PostMapping(value = "/saver/redis")
    public ResultJson saveRedis(String key, String value) {
        ResultJson json = new ResultJson();
        try {
            json.setData(this.redisUtil.set(key, value));
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }

    @PostMapping(value = "/get/redis/by/key")
    public ResultJson getRedisByKey(String key) {
        ResultJson json = new ResultJson();
        try {
            json.setData(this.redisUtil.get(key));
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }

    @GetMapping(value = "demo")
    public ResultJson demo() {
        ResultJson json = new ResultJson();
        try {
            this.userService.demo();
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultJson.FAILURE);
        }
        return json;
    }
}
