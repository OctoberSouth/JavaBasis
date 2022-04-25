package com.lp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lp.dao.UserMapper;
import com.lp.entity.User;
import com.lp.rabbitmq.RabbitMqConstant;
import com.lp.vo.UserVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019/12/6 10:40
 * @describe
 */
@Service
public class UserService {

    private UserMapper userMapper;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public List<User> listUser() {
        List<User> userList = this.userMapper.selectList(null);
        return userList;
    }


    public void saveUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        this.userMapper.insert(user);
    }

    public Page<User> selectUserPage() {
        Page<User> page = new Page<>(3, 2);
        return userMapper.selectUserList(page);
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
    public UserVo selectUserListById(String id) {
        return userMapper.selectUserById(id);
    }


    /**
     * @return void
     * @author 刘攀
     * @date 2019/12/17 14:24
     * @version 1.0
     * @describe mybatis plus常用单表操作
     */
    @Transactional(rollbackFor = Exception.class)
    public void demo() {
        //添加
        User user = new User();
        user.setUserName("雨");
        user.setPassword("password");
        this.userMapper.insert(user);
        //根据条件查询列表
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.like("user_name", "雨");
        List<User> listUser = this.userMapper.selectList(wrapper);
        //根据条件删除，这里的删除是逻辑删除，指把deletion字段改为1
        QueryWrapper<User> deleteWrapper = new QueryWrapper();
        deleteWrapper.eq("id", "93ef6a281df924a9d3bff3211b0567af");
        this.userMapper.delete(deleteWrapper);
        //根据id修改
        User updateUser = new User();
        updateUser.setId("93ef6a281df924a9d3bff3211b0567af");
        updateUser.setUserName("user");
        updateUser.setPassword("password");
        this.userMapper.updateById(updateUser);
        //分页查询
        Page<User> page = new Page<>(1, 2);
        QueryWrapper<User> pageWrapper = new QueryWrapper();
        pageWrapper.like("user_name", "雨");
        IPage<User> userPage = this.userMapper.selectPage(page, pageWrapper);
    }

    public void testMq(String value) {
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.TEST + RabbitMqConstant.QUEUE, value);
    }
}