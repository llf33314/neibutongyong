package com.gt.inside.sso.core.bean.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 登录请求对象
 * Created by psr on 2017/10/19 0019.
 */
@ApiModel(value = "登录返回对象")
public class LoginRes {

    @ApiModelProperty("tocken")
    private String tocken;

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }

    @Override
    public String toString() {
        return "LoginRes{" +
                "tocken='" + tocken + '\'' +
                '}';
    }
}
