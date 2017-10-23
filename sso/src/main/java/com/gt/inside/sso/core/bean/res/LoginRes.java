package com.gt.inside.sso.core.bean.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 登录请求对象
 * Created by psr on 2017/10/19 0019.
 */
@ApiModel(value = "登录返回对象")
public class LoginRes {

    @ApiModelProperty("token令牌")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginRes{" +
                "token='" + token + '\'' +
                '}';
    }
}
