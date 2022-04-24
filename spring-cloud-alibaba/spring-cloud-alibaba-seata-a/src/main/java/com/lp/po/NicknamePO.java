package com.lp.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO
 *
 * @author: 刘攀
 * @date: 2022-04-24 17:35
 */
@Data
@Table(name = "nickname")
public class NicknamePO {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;


    /**
     * nickname
     */
    private String nickname;
}
