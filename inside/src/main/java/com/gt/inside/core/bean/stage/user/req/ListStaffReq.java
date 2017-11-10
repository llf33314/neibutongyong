package com.gt.inside.core.bean.stage.user.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "用户可选择员工列表请求类")
public class ListStaffReq extends PageReq {
    @Override
    public String toString() {
        return "ListStaffReq{" +
                "current=" + current +
                ", size=" + size +
                '}';
    }
}
