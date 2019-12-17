package com.lp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘攀
 * @date 2019/12/6 10:39
 * @return
 * @version 1.0
 * @describe 用户mapper
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    Page<User> selectUserList(Page page);

    List<User> selectUserList();

    List<User> selectUserList(String id);
}
