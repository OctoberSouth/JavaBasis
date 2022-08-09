package com.lp.controller;

import com.lp.service.HdiotDecodeService;
import com.lp.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019年3月8日下午2:41:05
 * @describe
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Resource
    private HdiotDecodeService hdiotDecodeService;

    @GetMapping(value = "")
    public ResultVO get() {
        ResultVO json = new ResultVO();
        try {
            json.setData(this.hdiotDecodeService.getDecodeMsg());
        } catch (Exception e) {
            json.setMessage(e.getMessage());
            json.setStatusCode(ResultVO.FAILURE);
        }
        return json;
    }


}
