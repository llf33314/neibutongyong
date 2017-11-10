package com.gt.inside.core.bean.stage.menu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by psr on 2017/11/9 0009.
 */
@ApiModel(value = "菜单DTO")
public class MenuMainDTO {

    @ApiModelProperty(value = "菜单id")
    private Integer id; // 菜单id

    @ApiModelProperty(value = "菜单名")
    private String menuName; // 菜单名

    @ApiModelProperty(value = "子菜单列表")
    private List<MenuSubDTO> menuSubDTOList; // 子菜单列表

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

    public List<MenuSubDTO> getMenuSubDTOList() {
        return menuSubDTOList;
    }

    public void setMenuSubDTOList(List<MenuSubDTO> menuSubDTOList) {
        this.menuSubDTOList = menuSubDTOList;
    }
}
