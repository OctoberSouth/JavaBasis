package com.lp.service.impl;

import com.lp.common.ResultJson;
import com.lp.service.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @Author 刘攀
 * @Date 2020/3/24 17:32
 * @Version 1.0
 * @Deacription 发生错误回调
 **/
@Service
public class TestServiceFailBack implements FallbackFactory<TestService> {

    /**
     * 统一返回失败参数
     */
    private static ResultJson resultJson = ResultJson.error("服务调用失败");

    @Override
    public TestService create(Throwable cause) {
        return txt -> {
            //这里是打印错误日志
            System.err.println(cause);
            return resultJson;
        };
    }
}
