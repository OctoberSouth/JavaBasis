package com.lp.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2019/12/6 10:35
 * @return
 * @describe 公共实体类
 */
@Data
public class BaseEntity {
    /**
     * id
     */
    private String id;
    /**
     * 删除标注，0：未删除，1：已删除
     */
    private Integer deletion;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
