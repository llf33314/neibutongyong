package com.gt.inside.core.bean.stage.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "编辑用户")
public class ModifyUserReq {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId; // 用户id

    @ApiModelProperty(value = "真实姓名")
    @NotNull(message = "真实姓名不能为空")
    private String userName; // 真实姓名

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ModifyUserReq{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
