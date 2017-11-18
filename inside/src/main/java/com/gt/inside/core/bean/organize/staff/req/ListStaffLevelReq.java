package com.gt.inside.core.bean.organize.staff.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/18 0018.
 */
@ApiModel(value = "员工级别请求类")
public class ListStaffLevelReq {

    @ApiModelProperty(value = "员工类型")
    @NotNull(message = "员工类型不能为空")
    private Integer staffType;

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    @Override
    public String toString() {
        return "ListStaffLevelReq{" +
                "staffType=" + staffType +
                '}';
    }
}
