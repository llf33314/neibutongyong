package com.gt.inside.core.bean.function.performance.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/1 0001.
 */
@ApiModel(value = "分管领导员工列表")
public class ListBranchStaffRes {

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

    @ApiModelProperty(value = "等级")
    private String level; // 等级

    @ApiModelProperty(value = "评级（true：已评，false：未评）")
    private Boolean levelBoolean = false;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Boolean getLevelBoolean() {
        return levelBoolean;
    }

    public void setLevelBoolean(Boolean levelBoolean) {
        this.levelBoolean = levelBoolean;
    }
}
