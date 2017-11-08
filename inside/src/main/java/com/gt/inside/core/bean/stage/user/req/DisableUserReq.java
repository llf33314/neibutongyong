package com.gt.inside.core.bean.stage.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "重置密码")
public class DisableUserReq {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId; // 用户id

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RestPwdReq{" +
                "userId=" + userId +
                '}';
    }
}
