package com.lp.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface MyProcessor {

    String TEST_OUTPUT = "test_output";

    @Output(TEST_OUTPUT)
    MessageChannel testOutput();
}
