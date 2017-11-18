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

    @ApiModelProperty(value = "员工类型")
    @NotNull(message = "员工类型不能为空")
    private Integer staffType; // 员工类型（对应字典1004，技术类，专业类）

    @ApiModelProperty(value = "员工等级")
    @NotNull(message = "员工等级不能为空")
    private Integer staffLevel; // 员工等级（对应字典1005 或 字典1006 或 字典 1007，P级或T级）

    @ApiModelProperty(value = "员工职务")
    @NotNull(message = "员工职务不能为空")
    private Integer staffDuties; // 员工职务（对应字典1008）

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

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getStaffEnName() {
        return staffEnName;
    }

    public void setStaffEnName(String staffEnName) {
        this.staffEnName = staffEnName;
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public Integer getStaffLevel() {
        return staffLevel;
    }

    public void setStaffLevel(Integer staffLevel) {
        this.staffLevel = staffLevel;
    }

    public Integer getStaffDuties() {
        return staffDuties;
    }

    public void setStaffDuties(Integer staffDuties) {
        this.staffDuties = staffDuties;
    }

    @Override
    public String toString() {
        return "StaffAddReq{" +
                "staffCode='" + staffCode + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffEnName='" + staffEnName + '\'' +
                ", staffJoinTime=" + staffJoinTime +
                ", staffPhone='" + staffPhone + '\'' +
                ", depId=" + depId +
                ", staffType=" + staffType +
                ", staffLevel=" + staffLevel +
                ", staffDuties=" + staffDuties +
                '}';
    }
}
