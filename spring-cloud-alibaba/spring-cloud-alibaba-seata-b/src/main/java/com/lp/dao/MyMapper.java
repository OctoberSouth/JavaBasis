package com.lp.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper集成
 *
 * @param <T>
 * @author 刘攀
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
