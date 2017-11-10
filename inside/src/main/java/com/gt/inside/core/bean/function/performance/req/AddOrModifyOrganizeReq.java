package com.gt.inside.core.bean.function.performance.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "新增或编辑员工组织关系")
public class AddOrModifyOrganizeReq {

    @ApiModelProperty(value = "员工id")
    @NotNull(message = "员工id不能为空")
    private Integer staffId; // 员工id

    @ApiModelProperty(value = "组织关系id")
    @NotNull(message = "组织关系id不能为空")
    private Integer staffOrgId; // 组织关系id

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

    @Override
    public String toString() {
        return "AddOrModifyOrganizeReq{" +
                "staffId=" + staffId +
                ", staffOrgId=" + staffOrgId +
                '}';
    }
}
