package com.gt.inside.core.bean.stage.menu.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "新增子菜单")
public class AddSubMenuReq {

    @ApiModelProperty(value = "主菜单id")
    @NotNull(message = "主菜单id不能为空")
    private Integer pid; // 主菜单id

    @ApiModelProperty(value = "子菜单名")
    @NotNull(message = "菜单名不能为空")
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "AddSubMenuReq{" +
                "pid=" + pid +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }
}
