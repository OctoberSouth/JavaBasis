package com.lp.feign;

import com.lp.common.ResultJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author: 刘攀
 * @date: 2022-04-24 17:57
 */
@FeignClient(value = "sleuth-b")
public interface SleuthFeign {

    @PostMapping("nickname/add")
    ResultJson<String> add(@RequestParam String nickname);
}
