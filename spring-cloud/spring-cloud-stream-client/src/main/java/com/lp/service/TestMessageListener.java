package com.lp.service;

import com.lp.mq.MyProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Author 刘攀
 * @Date 2020/3/27 12:06
 * @Version 1.0
 * @Deacription 消息接收
 **/
@Component
public class TestMessageListener {

    /**
     * 接收来自 MyProcessor.LOG_FORMAT_INPUT 的消息
     * 也就是加工后的消息，也就是通过上面的 SendTo 发送来的
     * 因为 MyProcessor.LOG_FORMAT_OUTPUT 和 MyProcessor.LOG_FORMAT_INPUT 是指向同一 exchange
     *
     * @param message
     */
    @StreamListener(MyProcessor.TEST_INPUT)
    public void processFormatLogMessage(String message) {
        System.out.println("接收到格式化后的消息：" + message);
    }
}
