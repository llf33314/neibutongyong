package com.gt.inside.sso.core.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Data
@Accessors(chain = true)
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 登录名
     */
	private String loginName;
    /**
     * 用户名
     */
	private String userName;
    /**
     * 密码
     */
	private String userPwd;
    /**
     * 用户状态（0：正常，1：停用）
     */
	private Integer userStatus;
    /**
     * 创建时间
     */
	private Date createTime;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
