package com.gt.inside.core.bean.function.performance.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "直属自评分信息")
public class ListDirectlyInfoReq {

    @ApiModelProperty(value = "员工id")
    @NotNull(message = "员工ID不能为空")
    private Integer staffId; // 员工ID

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "ListDirectlyInfoReq{" +
                "staffId=" + staffId +
                '}';
    }
}
