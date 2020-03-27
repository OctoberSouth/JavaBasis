package com.lp.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MyProcessor {

    String TEST_INPUT = "test_input";

    @Input(TEST_INPUT)
    SubscribableChannel testInput();
}
