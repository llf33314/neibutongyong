package com.gt.inside.core.bean.dict.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/25 0025.
 */
@ApiModel(value = "删除字典详情")
public class DictInfoDelReq {

    @ApiModelProperty(value = "字典详情id")
    @NotNull(message = "字典详情id不能为空")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DictInfoDelReq{" +
                "id=" + id +
                '}';
    }
}
