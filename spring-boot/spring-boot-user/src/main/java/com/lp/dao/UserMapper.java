package com.lp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lp.entity.User;
import com.lp.vo.UserVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2019/12/6 10:39
 * @return
 * @describe 用户mapper
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    Page<User> selectUserList(Page page);

    List<User> selectUserList();

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    @Select("SELECT\n" +
            "   u.user_name AS userName,\n" +
            "   u.`password` AS `password`\n" +
            " FROM\n" +
            "   `user` AS u\n" +
            "WHERE\n" +
            "   u.id = #{id}")
    UserVo selectUserById(String id);
}
