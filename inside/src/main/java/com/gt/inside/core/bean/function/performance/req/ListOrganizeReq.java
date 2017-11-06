package com.gt.inside.core.bean.function.performance.req;

import com.gt.inside.api.base.PageReq;
import com.gt.inside.api.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "分页查询组织关系")
public class ListOrganizeReq extends PageReq {

    @ApiModelProperty(value = "部门id")
    private Integer departmentId; // 部门id

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "ListOrganizeReq{" +
                "departmentId=" + departmentId +
                ", current=" + current +
                ", size=" + size +
                '}';
    }
}
