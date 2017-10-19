package com.gt.inside.sso.core.bean.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 登录请求对象
 * Created by psr on 2017/10/19 0019.
 */
@ApiModel(value = "登录请求对象")
public class LoginReq {

    @NotNull(message = "登录名不能为空")
    @ApiModelProperty("登录名")
    private String loginName;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
