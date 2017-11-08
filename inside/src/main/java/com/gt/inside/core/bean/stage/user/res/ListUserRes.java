package com.gt.inside.core.bean.stage.user.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "用户列表返回类")
public class ListUserRes {

    @ApiModelProperty(value = "用户id")
    private Integer userId; // 用户id

    @ApiModelProperty(value = "登录名")
    private String loginName; // 登录名

    @ApiModelProperty(value = "用户名")
    private String userName; // 用户名

    @ApiModelProperty(value = "用户状态（0：正常，1：停用）")
    private Integer userStatus; // 用户状态（0：正常，1：停用）

    @ApiModelProperty(value = "创建时间")
    private Date createTime; // 创建时间

    @ApiModelProperty(value = "员工姓名")
    private String staffName; // 员工姓名

    @ApiModelProperty(value = "员工id")
    private Integer staffId; // 员工id

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "ListUserRes{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", userStatus=" + userStatus +
                ", createTime=" + createTime +
                ", staffName='" + staffName + '\'' +
                ", staffId=" + staffId +
                '}';
    }
}
