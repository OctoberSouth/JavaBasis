package com.lp.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue donorGiftLiveQueue() {
        //true 是否持久
        return new Queue(RabbitMqConstant.TEST + RabbitMqConstant.QUEUE, true);
    }

}
