package com.lp.service;

import com.lp.common.ResultJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微服务调用接口
 */
@RequestMapping("service")
//这里为服务的名字
@FeignClient("lp-service")
public interface TestService {

    @PostMapping("test")
    ResultJson saveTest(@RequestParam String txt);
}
