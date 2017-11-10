package com.gt.inside.core.bean.function.performance.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/1 0001.
 */
@ApiModel(value = "直属领导员工列表")
public class ListDirectlyStaffRes {

    @ApiModelProperty(value = "员工id")
    private Integer staffId; // 员工id

    @ApiModelProperty(value = "员工名称")
    private String staffName; // 员工名称

    @ApiModelProperty(value = "员工编号")
    private String staffCode; // 员工编号

    @ApiModelProperty(value = "自评总分")
    private Integer ownTotal; // 自评总分

    @ApiModelProperty(value = "直属领导总评分")
    private Integer directlyTotal; // 直属领导总评分

    @ApiModelProperty(value = "直属领导是否已评分（true：是，false：否）")
    private boolean directlyBoolean = false; // 直属领导是否已评分（true：是，false：否）

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

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public Integer getOwnTotal() {
        return ownTotal;
    }

    public void setOwnTotal(Integer ownTotal) {
        this.ownTotal = ownTotal;
    }

    public Integer getDirectlyTotal() {
        return directlyTotal;
    }

    public void setDirectlyTotal(Integer directlyTotal) {
        this.directlyTotal = directlyTotal;
    }

    public boolean isDirectlyBoolean() {
        return directlyBoolean;
    }

    public void setDirectlyBoolean(boolean directlyBoolean) {
        this.directlyBoolean = directlyBoolean;
    }

    @Override
    public String toString() {
        return "ListDirectlyStaffRes{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffCode='" + staffCode + '\'' +
                ", ownTotal=" + ownTotal +
                ", directlyTotal=" + directlyTotal +
                ", directlyBoolean=" + directlyBoolean +
                '}';
    }
}
