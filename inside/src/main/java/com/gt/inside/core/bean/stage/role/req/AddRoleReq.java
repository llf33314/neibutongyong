package com.gt.inside.core.bean.stage.role.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/9 0009.
 */
@ApiModel(value = "新增角色")
public class AddRoleReq {

    @ApiModelProperty(value = "角色名")
    @NotNull(message = "角色名不能为空")
    private String roleName; // 角色名

    @ApiModelProperty(value = "权限描述")
    private String roleRemark; // 权限描述

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    @Override
    public String toString() {
        return "AddRoleReq{" +
                "roleName='" + roleName + '\'' +
                ", roleRemark='" + roleRemark + '\'' +
                '}';
    }
}
