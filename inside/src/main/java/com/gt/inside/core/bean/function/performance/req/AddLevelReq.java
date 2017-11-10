package com.gt.inside.core.bean.function.performance.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/3 0003.
 */
@ApiModel(value = "保存评级")
public class AddLevelReq {

    @ApiModelProperty(value = "员工id")
    @NotNull(message = "员工id不能为空")
    private Integer staffId;

    @ApiModelProperty(value = "员工姓名")
    @NotNull(message = "员工姓名不能为空")
    private String staffName;

    @ApiModelProperty(value = "评级")
    @NotNull(message = "评级不能为空")
    private Integer level;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AddLevelReq{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", level=" + level +
                '}';
    }
}
