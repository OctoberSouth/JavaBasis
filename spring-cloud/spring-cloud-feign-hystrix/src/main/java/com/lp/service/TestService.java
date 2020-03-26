package com.lp.service;

import com.lp.common.ResultJson;
import com.lp.service.impl.TestServiceFailBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微服务调用接口
 */
@FeignClient(value = "lp-service", fallbackFactory = TestServiceFailBack.class)
public interface TestService {

    @PostMapping("test")
    ResultJson saveTest(@RequestParam String txt);

}
