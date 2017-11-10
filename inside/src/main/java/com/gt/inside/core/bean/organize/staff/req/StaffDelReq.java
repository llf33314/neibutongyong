package com.gt.inside.core.bean.organize.staff.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/26 0026.
 */
@ApiModel(value = "删除员工")
public class StaffDelReq {

    @ApiModelProperty(value = "员工id")
    @NotNull(message = "员工id不能为空")
    private Integer id; // 员工id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StaffDelReq{" +
                "id=" + id +
                '}';
    }
}
