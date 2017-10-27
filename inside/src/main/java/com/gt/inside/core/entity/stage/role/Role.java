package com.gt.inside.core.entity.stage.role;

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
 * 角色表
 * </p>
 *
 * @author psr
 * @since 2017-10-27
 */
@Data
@Accessors(chain = true)
@TableName("t_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色名
     */
	private String roleName;
    /**
     * 角色权限（0：普通，1：最高权限）
     */
	private Integer rolePower;
    /**
     * 权限描述
     */
	private String roleRemark;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 删除标识（0：正常，1：删除）
     */
	private Integer deleteFlag;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
