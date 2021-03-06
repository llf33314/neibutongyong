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
    VAILD(202, "数据验证错误"),
    INFONULL(203, "信息重复"),
    // 300+针对统一业务
    TOKEN_ERROR(301, "无效的Token"),
    SIGN_TIME_OUT(302,"签名请求超时"),
    SIGN_ERROR(303,"签名错误"),
    SIGN_SUCCESS(304,"签名验证成功"),
    LOGIN_NEED(305, "Token已过期，请重新登录"),
    TOKEN_NULL(306, "Token不能为空"),
    MODIFY_NULL(307, "编辑对象不存在"),
    DEL_NULL(308, "删除对象不存在"),
    // 400+针对自己业务
    LOGIN_NULL(401, "登录用户名或密码错误"),
    DICT_CODE_HAS(402, "字典编号不能重复"),
    DICT_NULL(403, "字典不存在"),
    DEPARTMENT_HAS(404, "部门已存在"),
    STAFF_HAS(405, "员工已存在"),
    STAFF_NULL(406, "员工不存在"),
    PERFOMANCE_INFO_HAS(407, "不能重复评分"),
    PERFOMANCE_INFO_NULL(408, "评分信息不存在"),
    PERFOMANCE_MONTH_NULL(409, "评分月份不存在"),
    PERFOMANCE_NO_RELEASE(410, "评级不可发布"),
    USER_HAS(411, "用户已存在"),
    USER_NULL(412, "用户不存在"),
    USER_STATUS_STOP(413, "账号已停用"),
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