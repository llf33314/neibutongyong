package com.gt.inside.core.bean.stage.menu.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "修改子菜单")
public class ModifySubMenuReq {

    @ApiModelProperty(value = "子菜单id")
    @NotNull(message = "子菜单id")
    private Integer id; // 菜单id

    @ApiModelProperty(value = "子菜单名")
    @NotNull(message = "子菜单名不能为空")
    private String menuName; // 菜单名

    @ApiModelProperty(value = "子菜单路径")
    private String menuUrl; // 菜单路径

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ModifySubMenuReq{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }
}
