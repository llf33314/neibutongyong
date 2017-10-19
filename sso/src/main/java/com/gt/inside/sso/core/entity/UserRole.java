package com.gt.inside.sso.core.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Data
@Accessors(chain = true)
@TableName("t_user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	private Integer userId;
    /**
     * 角色id
     */
	private Integer roleId;


	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}
