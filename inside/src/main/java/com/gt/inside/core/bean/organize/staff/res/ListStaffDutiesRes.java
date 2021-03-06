package com.gt.inside.core.bean.organize.staff.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/18 0018.
 */
@ApiModel(value = "获取员工职务")
public class ListStaffDutiesRes {

    @ApiModelProperty(value = "职务code")
    private Integer code; // 职务code

    @ApiModelProperty(value = "职务名称")
    private String name; // 职务名称

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListStaffTypeRes{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
