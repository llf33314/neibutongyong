package com.gt.inside.api.enums;

/**
 * 响应成功Code 类
 * Created by psr on 2017/8/24 0024.
 */
public enum ResponseEnums {

    SUCCESS(100, "请求成功"),
    // 200+针对请求失败
    ERROR(200, "请求失败"),
    LOGIN(201, "请先登录"),
    // 300+针对统一业务
    TOKEN_ERROR(301, "无效的Token"),
    SIGN_TIME_OUT(302,"签名请求超时"),
    SIGN_ERROR(303,"签名错误"),
    SIGN_SUCCESS(304,"签名验证成功"),
    LOGIN_NEED(305, "Token已过期，请重新登录"),
    TOKEN_NULL(301, "Token不能为空"),
    // 400+针对自己业务
    LOGIN_NULL(401, "登录用户名或密码错误"),
    MODIFY_NULL(402, "编辑对象不存在"),
    ;

    private final int code;
    private final String desc;

    ResponseEnums(int code, String desc ) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}