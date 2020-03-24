package com.lp.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2020/01/14 10:06
 * @describe消息监听消费者
 */
@Component
public class RabbitMqReceiver {

    @RabbitListener(queues = RabbitMqConstant.TEST + RabbitMqConstant.QUEUE)
    @RabbitHandler
    public void testMq(String value) {
        try {
            System.out.println(value + "==================");
        } catch (Exception e) {

        }
    }
}
