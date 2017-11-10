package com.gt.inside.core.bean.stage.role.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/9 0009.
 */
@ApiModel(value = "分页获取角色")
public class ListRoleReq extends PageReq {

    @ApiModelProperty(value = "角色名查询[选填]")
    private String roleSearch; // 角色查询

    public String getRoleSearch() {
        return roleSearch;
    }

    public void setRoleSearch(String roleSearch) {
        this.roleSearch = roleSearch;
    }

    @Override
    public String toString() {
        return "ListRoleReq{" +
                "roleSearch='" + roleSearch + '\'' +
                ", current=" + current +
                ", size=" + size +
                '}';
    }
}
