package com.gt.inside.core.bean.dict.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/25 0025.
 */
@ApiModel(value = "新增字典")
public class DictAddReq {

    @ApiModelProperty(value = "字典名称")
    @NotNull(message = "字典名称不能为空")
    private String dictName;

    @ApiModelProperty(value = "字典编码")
    @NotNull(message = "字典编码不能为空")
    private Integer dictCode;

    @ApiModelProperty(value = "字典描述[选填]")
    private String dictRemark;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public Integer getDictCode() {
        return dictCode;
    }

    public void setDictCode(Integer dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    @Override
    public String toString() {
        return "DictAddReq{" +
                "dictName='" + dictName + '\'' +
                ", dictCode=" + dictCode +
                ", dictRemark='" + dictRemark + '\'' +
                '}';
    }
}
