package com.gt.inside.core.bean.stage.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "新增用户")
public class AddUserReq {

    @ApiModelProperty(value = "登录名")
    @NotNull(message = "登录名不能为空")
    private String loginName; // 登录名

    @ApiModelProperty(value = "真实姓名")
    @NotNull(message = "真实姓名不能为空")
    private String userName; // 真实姓名

    @ApiModelProperty(value = "密码")
    @NotNull(message = "密码不能为空")
    private String password; // 密码

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AddUserReq{" +
                "loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
