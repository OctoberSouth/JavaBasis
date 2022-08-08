package com.lp.service;

import com.lp.dao.UserMapper;
import com.lp.entity.User;
import com.lp.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019/12/6 10:40
 * @describe
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    

    public void saveUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        this.userMapper.insert(user);
    }


    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public UserVO selectUserListById(String id) {
        return userMapper.selectUserById(id);
    }


}