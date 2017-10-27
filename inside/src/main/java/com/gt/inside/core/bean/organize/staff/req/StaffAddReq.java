package com.gt.inside.core.bean.organize.staff.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by psr on 2017/10/26 0026.
 */
@ApiModel(value = "新增员工")
public class StaffAddReq {

    @ApiModelProperty(value = "员工编号")
    @NotNull(message = "员工编号不能为空")
    private String staffCode; // 员工编号

    @ApiModelProperty(value = "员工姓名")
    @NotNull(message = "员工姓名不能为空")
    private String staffName; // 员工姓名

    @ApiModelProperty(value = "入职时间")
    @NotNull(message = "入职时间不能为空")
    private Date staffJoinTime; // 入职时间

    @ApiModelProperty(value = "员工电话")
    @NotNull(message = "员工电话不能为空")
    private String staffPhone; // 员工电话

    @ApiModelProperty(value = "部门id")
    @NotNull(message = "部门id不能为空")
    private Integer departmentId; // 部门id

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getStaffJoinTime() {
        return staffJoinTime;
    }

    public void setStaffJoinTime(Date staffJoinTime) {
        this.staffJoinTime = staffJoinTime;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "StaffAddReq{" +
                "staffCode='" + staffCode + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffJoinTime=" + staffJoinTime +
                ", staffPhone='" + staffPhone + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
