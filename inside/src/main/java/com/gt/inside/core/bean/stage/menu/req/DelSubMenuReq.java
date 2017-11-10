package com.gt.inside.core.bean.stage.menu.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "删除子菜单")
public class DelSubMenuReq {

    @ApiModelProperty(value = "子菜单id")
    @NotNull(message = "子菜单id")
    private Integer id; // 菜单id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DelMenuReq{" +
                "id=" + id +
                '}';
    }
}
