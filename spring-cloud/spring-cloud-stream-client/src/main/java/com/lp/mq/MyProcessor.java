package com.lp.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@Component
public interface MyProcessor {

    String TEST_INPUT = "test_input";

    /**
     * 接收消息
     *
     * @return SubscribableChannel
     * @author 刘攀
     * @date 2020/11/17 14:07
     * @version 1.0
     */
    @Input(TEST_INPUT)
    SubscribableChannel testInput();
}
