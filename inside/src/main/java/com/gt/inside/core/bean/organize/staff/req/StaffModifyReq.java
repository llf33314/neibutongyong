package com.gt.inside.core.bean.organize.staff.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by psr on 2017/10/26 0026.
 */
@ApiModel(value = "修改员工")
public class StaffModifyReq {

    @ApiModelProperty(value = "员工id")
    @NotNull(message = "员工id不能为空")
    private Integer id; // 员工id

    @ApiModelProperty(value = "员工编号")
    @NotNull(message = "员工编号不能为空")
    private String staffCode; // 员工编号

    @ApiModelProperty(value = "员工姓名")
    @NotNull(message = "员工姓名不能为空")
    private String staffName; // 员工姓名

    @ApiModelProperty(value = "员工英文名")
    private String staffEnName; // 英文名

    @ApiModelProperty(value = "入职时间")
    @NotNull(message = "入职时间不能为空")
    private Date staffJoinTime; // 入职时间

    @ApiModelProperty(value = "员工电话")
    @NotNull(message = "员工电话不能为空")
    private String staffPhone; // 员工电话

    @ApiModelProperty(value = "部门id")
    @NotNull(message = "部门id不能为空")
    private Integer depId; // 部门id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStaffEnName() {
        return staffEnName;
    }

    public void setStaffEnName(String staffEnName) {
        this.staffEnName = staffEnName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "StaffModifyReq{" +
                "id=" + id +
                ", staffCode='" + staffCode + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffEnName='" + staffEnName + '\'' +
                ", staffJoinTime=" + staffJoinTime +
                ", staffPhone='" + staffPhone + '\'' +
                ", depId=" + depId +
                '}';
    }
}
