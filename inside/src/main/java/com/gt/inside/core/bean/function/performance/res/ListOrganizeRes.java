package com.gt.inside.core.bean.function.performance.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "组织关系对象")
public class ListOrganizeRes {

    @ApiModelProperty(value = "员工id")
    private Integer staffId; // 员工id

    @ApiModelProperty(value = "员工姓名")
    private String staffName; // 员工姓名

    @ApiModelProperty(value = "所属部门")
    private String departmentName; // 所属部门

    @ApiModelProperty(value = "直属领导员工id")
    private Integer directlyId; // 直属领导员工id

    @ApiModelProperty(value = "直属领导员工姓名")
    private String directlyName; // 直属领导员工姓名

    @ApiModelProperty(value = "分管领导员工id")
    private Integer branchId; // 分管领导员工id

    @ApiModelProperty(value = "分管领导员工姓名")
    private String branchName; // 分管领导员工姓名

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getDirectlyId() {
        return directlyId;
    }

    public void setDirectlyId(Integer directlyId) {
        this.directlyId = directlyId;
    }

    public String getDirectlyName() {
        return directlyName;
    }

    public void setDirectlyName(String directlyName) {
        this.directlyName = directlyName;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "ListOrganizeRes{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", directlyId=" + directlyId +
                ", directlyName='" + directlyName + '\'' +
                ", branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
