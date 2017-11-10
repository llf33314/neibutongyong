package com.gt.inside.core.bean.stage.user.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "用户列表请求类")
public class ListUserReq extends PageReq {

    @ApiModelProperty(value = "用户查询条件（登录名/真实姓名）[选填]")
    private String userSearch; // 用户查询条件（登录名/真实姓名）

    @ApiModelProperty(value = "用户状态（0：正常，1：停用）")
    private Integer userStatus; // 用户状态（0：正常，1：停用）

    public String getUserSearch() {
        return userSearch;
    }

    public void setUserSearch(String userSearch) {
        this.userSearch = userSearch;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "ListUserReq{" +
                "userSearch='" + userSearch + '\'' +
                ", current=" + current +
                ", userStatus=" + userStatus +
                ", size=" + size +
                '}';
    }
}
