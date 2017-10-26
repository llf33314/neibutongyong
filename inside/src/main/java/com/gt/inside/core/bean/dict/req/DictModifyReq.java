package com.gt.inside.core.bean.dict.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by psr on 2017/10/25 0025.
 */
@ApiModel(value = "编辑字典")
public class DictModifyReq {

    @ApiModelProperty(value = "字典id")
    @NotNull(message = "字典id不能为空")
    private Integer id;

    @ApiModelProperty(value = "字典名称")
    @NotNull(message = "字典名称不能为空")
    private String dictName;

    @ApiModelProperty(value = "字典编码")
    @NotNull(message = "字典编码不能为空")
    private Integer dictCode;

    @ApiModelProperty(value = "字典描述[选填]")
    private String dictRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "DictModifyReq{" +
                "id=" + id +
                ", dictName='" + dictName + '\'' +
                ", dictCode=" + dictCode +
                ", dictRemark='" + dictRemark + '\'' +
                '}';
    }
}
