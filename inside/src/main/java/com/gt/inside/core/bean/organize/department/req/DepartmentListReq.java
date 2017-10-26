package com.gt.inside.core.bean.organize.department.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 * Created by psr on 2017/10/26 0026.
 */
@ApiModel(value = "部门列表")
public class DepartmentListReq extends PageReq{

    @ApiModelProperty(value = "搜索条件[选填]")
    private String departmentSearch;

    public String getDepartmentSearch() {
        return departmentSearch;
    }

    public void setDepartmentSearch(String departmentSearch) {
        this.departmentSearch = departmentSearch;
    }

    @Override
    public String toString() {
        return "DepartmentListReq{" +
                "departmentSearch='" + departmentSearch + '\'' +
                ", current=" + current +
                ", size=" + size +
                '}';
    }
}
