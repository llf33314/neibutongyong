package com.gt.inside.core.bean.stage.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "关联员工")
public class RelationStaffReq {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId; //  用户id

    @ApiModelProperty(value = "员工id")
    @NotNull(message = "员工id不能为空")
    private Integer staffId; // 员工id

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "RelationStaffReq{" +
                "userId=" + userId +
                ", staffId=" + staffId +
                '}';
    }
}
