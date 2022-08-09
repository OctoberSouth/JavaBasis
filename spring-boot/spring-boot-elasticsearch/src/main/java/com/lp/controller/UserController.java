package com.lp.controller;

import com.lp.config.RedisUtil;
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
    private RedisUtil redisUtil;

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

}
