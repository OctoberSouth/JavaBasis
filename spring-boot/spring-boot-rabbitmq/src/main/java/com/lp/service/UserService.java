package com.lp.service;

import com.lp.rabbitmq.RabbitMqConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019/12/6 10:40
 * @describe
 */
@Service
public class UserService {


    @Resource
    private RabbitTemplate rabbitTemplate;

    public void testMq(String value) {
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.TEST + RabbitMqConstant.QUEUE, value);
    }
}