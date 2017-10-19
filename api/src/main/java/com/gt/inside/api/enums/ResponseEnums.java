package com.gt.inside.api.enums;

/**
 * 响应成功Code 类
 * Created by psr on 2017/8/24 0024.
 */
public enum ResponseEnums {

    SUCCESS(100, "请求成功"),
    // 200+针对请求失败
    ERROR(200, "请求失败"),
    // 300+针对统一业务

    // 400+针对自己业务
    LOGINNULL(401, "登录用户名或密码错误"),
    MODIFYNULL(402, "编辑对象不存在"),
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