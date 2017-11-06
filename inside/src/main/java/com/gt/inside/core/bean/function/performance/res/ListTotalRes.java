package com.gt.inside.core.bean.function.performance.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "获取绩效总览列表")
public class ListTotalRes {

    @ApiModelProperty(value = "员工姓名")
    private String staffName; // 员工姓名

    @ApiModelProperty(value = "月份")
    private Date monthTime; // 月份

    @ApiModelProperty(value = "等级")
    private String level; // 等级

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Date monthTime) {
        this.monthTime = monthTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "ListTotalRes{" +
                "staffName='" + staffName + '\'' +
                ", monthTime=" + monthTime +
                ", level='" + level + '\'' +
                '}';
    }
}
