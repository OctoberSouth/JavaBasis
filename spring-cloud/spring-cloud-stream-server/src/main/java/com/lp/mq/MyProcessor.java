package com.lp.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@Component
public interface MyProcessor {

    String TEST_OUTPUT = "test_output";

    /**
     * 发送消息
     *
     * @return MessageChannel
     * @author 刘攀
     * @date 2020/11/17 14:07
     * @version 1.0
     */
    @Output(TEST_OUTPUT)
    MessageChannel testOutput();
}
