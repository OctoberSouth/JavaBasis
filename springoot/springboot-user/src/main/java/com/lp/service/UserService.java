package com.lp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lp.dao.UserMapper;
import com.lp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019/12/6 10:40
 * @describe
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User>  listUser() {
        List<User> userList = this.userMapper.selectList(null);
        return  userList;
    }


    public void  saveUser(String userName,String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        this.userMapper.insert(user);
    }

    public IPage<User> selectUserPage() {
        Page<User> page = new Page<>(3, 2);
        return userMapper.selectUserList(page);
    }

    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    public List<User> selectUserListById() {
        return userMapper.selectUserList("93ef6a281df924a9d3bff3211b0567af");
    }
}
