package com.gt.inside.core.bean.function.performance.dto;

/**
 * Created by psr on 2017/10/31 0031.
 */
public class ListOrganizeTotalDTO {

    private Integer staffId; // 员工id

    private Integer staffOrgId; // 员工组织关系id

    private Integer ownTotal; // 自评总分

    private Integer orgTotal; // 组织关系总评分

    private Integer levelCode; // 评级

    private Integer levelRelease; // 发布评级（0：未发布，1：发布）

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

    public Integer getOwnTotal() {
        return ownTotal;
    }

    public void setOwnTotal(Integer ownTotal) {
        this.ownTotal = ownTotal;
    }

    public Integer getOrgTotal() {
        return orgTotal;
    }

    public void setOrgTotal(Integer orgTotal) {
        this.orgTotal = orgTotal;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public Integer getLevelRelease() {
        return levelRelease;
    }

    public void setLevelRelease(Integer levelRelease) {
        this.levelRelease = levelRelease;
    }

    @Override
    public String toString() {
        return "ListOrganizeTotalDTO{" +
                "staffId=" + staffId +
                ", staffOrgId=" + staffOrgId +
                ", ownTotal=" + ownTotal +
                ", orgTotal=" + orgTotal +
                ", levelCode=" + levelCode +
                ", levelRelease=" + levelRelease +
                '}';
    }
}
