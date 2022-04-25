package com.lp.controller;

import com.lp.common.ResultJson;
import com.lp.mq.MyProcessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@RestController
public class TestController {

    @Resource
    private MyProcessor myProcessor;

    @GetMapping(value = "test")
    public ResultJson test(@RequestParam String txt) {
        //发送消息队列消息
        Message<String> stringMessage = MessageBuilder.withPayload(txt).build();
        myProcessor.testOutput().send(stringMessage);
        return ResultJson.success(txt);
    }

}
