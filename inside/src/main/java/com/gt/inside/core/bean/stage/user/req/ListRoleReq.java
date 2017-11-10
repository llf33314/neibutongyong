package com.gt.inside.core.bean.stage.user.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "用户与角色对应关系列表请求类")
public class ListRoleReq extends PageReq {

    @ApiModelProperty(value = "用户id")
    private Integer userId; // 用户id

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ListStaffReq{" +
                "current=" + current +
                ", size=" + size +
                '}';
    }
}
