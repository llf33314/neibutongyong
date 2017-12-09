package com.gt.inside.core.bean.function.performance.dto;

/**
 * Created by psr on 2017/10/31 0031.
 */
public class ListOrganizeDTO {

    private Integer staffId; // 员工id

    private Integer staffOrgId; // 员工组织关系id

    private String staffName; // 员工姓名

    private String staffCode; // 员工编号

    private Integer staffDuties; // 员工职务

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStaffOrgId() {
        return staffOrgId;
    }

    public void setStaffOrgId(Integer staffOrgId) {
        this.staffOrgId = staffOrgId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public Integer getStaffDuties() {
        return staffDuties;
    }

    public void setStaffDuties(Integer staffDuties) {
        this.staffDuties = staffDuties;
    }

    @Override
    public String toString() {
        return "ListOrganizeDTO{" +
                "staffId=" + staffId +
                ", staffOrgId=" + staffOrgId +
                ", staffName='" + staffName + '\'' +
                ", staffCode='" + staffCode + '\'' +
                ", staffDuties=" + staffDuties +
                '}';
    }
}
