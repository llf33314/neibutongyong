package com.gt.inside.sso.core.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Data
@Accessors(chain = true)
@TableName("t_role_menu")
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
	private Integer roleId;
    /**
     * 菜单id
     */
	private Integer menuId;


	@Override
	protected Serializable pkVal() {
		return this.roleId;
	}

}
