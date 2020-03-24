package com.lp.service.impl;

import com.lp.common.ResultJson;
import com.lp.service.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @Author 刘攀
 * @Date 2020/3/24 17:32
 * @Version 1.0
 * @Deacription TODO
 **/
@Service
public class TestServiceFailBack implements FallbackFactory<TestService> {


    /**
     * 统一返回失败参数
     */
    private static ResultJson resultJson = new ResultJson(ResultJson.ERROR, "服务调用失败");

    @Override
    public TestService create(Throwable cause) {
        return new TestService() {
            @Override
            public ResultJson saveTest(String txt) {
                System.err.println(cause);
                return resultJson;
            }

            @Override
            public ResultJson saveTestw(String txt) {
                return resultJson;
            }
        };
    }


}
