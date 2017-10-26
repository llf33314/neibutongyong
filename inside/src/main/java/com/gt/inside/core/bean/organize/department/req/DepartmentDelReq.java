package com.gt.inside.core.bean.organize.department.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author psr
 * Created by psr on 2017/10/26 0026.
 */
@ApiModel(value = "删除部门")
public class DepartmentDelReq {

    @ApiModelProperty(value = "部门id")
    @NotNull(message = "部门id不能为空")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DepartmentDelReq{" +
                "id=" + id +
                '}';
    }
}
