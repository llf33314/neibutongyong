package com.gt.inside.core.bean.function.performance.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;

/**
 * Created by psr on 2017/11/1 0001.
 */
@ApiModel(value = "直属领导员工列表请求")
public class ListDirectlyStaffReq extends PageReq{
    @Override
    public String toString() {
        return "ListDirectlyStaffReq{" +
                "current=" + current +
                ", size=" + size +
                '}';
    }
}
