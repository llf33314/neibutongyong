package com.gt.inside.core.bean.stage.menu.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "分页获取菜单")
public class ListMenuReq extends PageReq {

    @ApiModelProperty(value = "菜单名[选填]")
    private String menuSearch; // 菜单名

    public String getMenuSearch() {
        return menuSearch;
    }

    public void setMenuSearch(String menuSearch) {
        this.menuSearch = menuSearch;
    }

    @Override
    public String toString() {
        return "ListMenuReq{" +
                "menuSearch='" + menuSearch + '\'' +
                ", current=" + current +
                ", size=" + size +
                '}';
    }
}
