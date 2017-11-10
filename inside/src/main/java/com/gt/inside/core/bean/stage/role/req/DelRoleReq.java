package com.gt.inside.core.bean.stage.role.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/9 0009.
 */
@ApiModel(value = "删除角色")
public class DelRoleReq {

    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Integer id; // 角色id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DelRoleReq{" +
                "id=" + id +
                '}';
    }
}
