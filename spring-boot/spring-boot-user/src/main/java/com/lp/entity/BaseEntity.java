package com.lp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author 刘攀
 * @date 2019/12/6 10:35
 * @return 
 * @version 1.0
 * @describe 公共实体类
 */
@Data
public  class BaseEntity {
	/**
	 * id
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 删除标注，0：未删除，1：已删除
	 */
	@TableLogic
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
