package com.lp.service;

import com.lp.dao.NicknameMapper;
import com.lp.exception.BizException;
import com.lp.feign.SleuthFeign;
import com.lp.po.NicknamePO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * TODO
 *
 * @author: 刘攀
 * @date: 2022-04-24 17:37
 */
@Service
public class NicknameService {

    @Resource
    private NicknameMapper nicknameMapper;

    @Resource
    private SleuthFeign sleuthFeign;

    public void add(String nickname) {
        sleuthFeign.add(nickname);

        NicknamePO nicknamePo = new NicknamePO();
        if (Objects.equals("nickname", nickname)) {
            throw new BizException("nickname");
        }
        nicknamePo.setNickname(nickname);
        this.nicknameMapper.insertSelective(nicknamePo);
    }
}
