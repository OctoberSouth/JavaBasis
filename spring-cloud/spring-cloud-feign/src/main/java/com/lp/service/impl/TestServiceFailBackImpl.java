package com.lp.service.impl;

import com.lp.common.ResultJson;
import com.lp.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author 刘攀
 * @Date 2020/3/24 17:32
 * @Version 1.0
 * @Deacription TODO
 **/
@Service
public class TestServiceFailBackImpl implements TestService {


   @Override
   public ResultJson saveTest(@RequestParam String txt){
        return new ResultJson();
    }
}
