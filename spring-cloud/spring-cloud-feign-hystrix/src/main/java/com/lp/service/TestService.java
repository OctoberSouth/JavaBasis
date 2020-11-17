package com.lp.service;

import com.lp.common.ResultJson;
import com.lp.service.impl.TestServiceFailBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@FeignClient(value = "lp-service", fallbackFactory = TestServiceFailBack.class)
public interface TestService {

    /**
     * 服务调用
     *
     * @param txt
     * @return com.lp.common.ResultJson
     * @author 刘攀
     * @date 2020/11/17 14:08
     * @version 1.0
     */
    @PostMapping("test")
    ResultJson saveTest(@RequestParam String txt);

}
