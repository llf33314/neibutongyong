package com.gt.inside.core.bean.stage.menu.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "修改菜单")
public class ModifyMenuReq {

    @ApiModelProperty(value = "菜单id")
    @NotNull(message = "菜单id")
    private Integer id; // 菜单id

    @ApiModelProperty(value = "菜单名")
    @NotNull(message = "菜单名不能为空")
    private String menuName; // 菜单名

    @ApiModelProperty(value = "菜单路径")
    private String menuUrl; // 菜单路径

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon; // 菜单图标

    @ApiModelProperty(value = "子菜单（0：有，1：无）")
    private Integer menuSub; // 子菜单（0：有，1：无）

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

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuSub() {
        return menuSub;
    }

    public void setMenuSub(Integer menuSub) {
        this.menuSub = menuSub;
    }

    @Override
    public String toString() {
        return "ModifyMenuReq{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuSub=" + menuSub +
                '}';
    }
}
