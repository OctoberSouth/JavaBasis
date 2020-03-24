package com.lp.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue donorGiftLiveQueue() {
        //true 是否持久
        return new Queue(RabbitMqConstant.TEST + RabbitMqConstant.QUEUE, true);
    }

}
