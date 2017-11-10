package com.gt.inside.core.bean.organize.department.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author psr
 * Created by psr on 2017/10/26 0026.
 */
@ApiModel(value = "新增部门")
public class DepartmentAddReq {

    @ApiModelProperty(value = "部门名称")
    @NotNull(message = "部门名称不能为空")
    private String depName;

    @ApiModelProperty(value = "部门地址[选填]")
    private String depAdd;

    @ApiModelProperty(value = "部门描述[选填]")
    private String depRemark;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepAdd() {
        return depAdd;
    }

    public void setDepAdd(String depAdd) {
        this.depAdd = depAdd;
    }

    public String getDepRemark() {
        return depRemark;
    }

    public void setDepRemark(String depRemark) {
        this.depRemark = depRemark;
    }

    @Override
    public String toString() {
        return "DepartmentAddReq{" +
                "depName='" + depName + '\'' +
                ", depAdd='" + depAdd + '\'' +
                ", depRemark='" + depRemark + '\'' +
                '}';
    }
}
