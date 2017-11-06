package com.gt.inside.core.bean.function.performance.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by psr on 2017/11/3 0003.
 */
@ApiModel(value = "新增直属领导评分信息")
public class AddDirectlyInfoReq {

    @ApiModelProperty(value = "员工id")
    @NotNull(message = "员工id不能为空")
    private Integer staffId;

    @ApiModelProperty(value = "评分详情")
    @NotNull(message = "评分详情不能为空")
    private List<AddDirectlyReq> addDirectlyReqList;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public List<AddDirectlyReq> getAddDirectlyReqList() {
        return addDirectlyReqList;
    }

    public void setAddDirectlyReqList(List<AddDirectlyReq> addDirectlyReqList) {
        this.addDirectlyReqList = addDirectlyReqList;
    }

    @Override
    public String toString() {
        return "AddDirectlyInfoReq{" +
                "staffId=" + staffId +
                ", addDirectlyReqList=" + addDirectlyReqList +
                '}';
    }
}
