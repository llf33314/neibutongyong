package com.gt.inside.core.bean.stage.role.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "所有的角色与用户是否拥有这角色")
public class RoleUserHasDTO {

    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色权限（0：普通，1：最高权限）")
    private Integer rolePower;

    @ApiModelProperty(value = "权限描述")
    private String roleRemark;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "用户是否拥有（0：拥有，1：未拥有）")
    private Integer userHas;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRolePower() {
        return rolePower;
    }

    public void setRolePower(Integer rolePower) {
        this.rolePower = rolePower;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserHas() {
        return userHas;
    }

    public void setUserHas(Integer userHas) {
        this.userHas = userHas;
    }

    @Override
    public String toString() {
        return "RoleUserHasDTO{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", rolePower=" + rolePower +
                ", roleRemark='" + roleRemark + '\'' +
                ", createTime=" + createTime +
                ", userHas=" + userHas +
                '}';
    }
}
