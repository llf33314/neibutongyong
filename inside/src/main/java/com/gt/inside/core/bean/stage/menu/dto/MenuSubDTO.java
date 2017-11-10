package com.gt.inside.core.bean.stage.menu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/9 0009.
 */
@ApiModel(value = "子菜单DTO")
public class MenuSubDTO {

    @ApiModelProperty(value = "子菜单id")
    private Integer id; // 子菜单id

    @ApiModelProperty(value = "子菜单名")
    private String menuName; // 子菜单名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
