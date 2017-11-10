package com.gt.inside.core.bean.stage.menu.res;

import com.gt.inside.api.base.PageReq;
import com.gt.inside.core.bean.stage.menu.dto.MenuMainDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "获取菜单DTO")
public class ListMenuRes {
    /**
     * 菜单列表
     */
    @ApiModelProperty(value = "菜单列表")
    private List<MenuMainDTO> menuMainDTOList;
    /**
     * 已选择菜单id
     */
    @ApiModelProperty(value = "已选择菜单id")
    private List<Integer> idList;

    public List<MenuMainDTO> getMenuMainDTOList() {
        return menuMainDTOList;
    }

    public void setMenuMainDTOList(List<MenuMainDTO> menuMainDTOList) {
        this.menuMainDTOList = menuMainDTOList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    @Override
    public String toString() {
        return "ListMenuRes{" +
                "menuMainDTOList=" + menuMainDTOList +
                ", idList=" + idList +
                '}';
    }
}
