package com.gt.inside.core.bean.dict.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/25 0025.
 */
@ApiModel(value = "新增字典详情")
public class DictInfoAddReq {

    @ApiModelProperty(value = "字典id")
    @NotNull(message = "字典ID不能为空")
    private Integer dictId;

    @ApiModelProperty(value = "字典详情内容")
    @NotNull(message = "字典详情内容不能为空")
    private String infoContent;

    @ApiModelProperty(value = "字典详情编码")
    @NotNull(message = "字典详情编码不能为空")
    private Integer infoCode;

    @ApiModelProperty(value = "字典详情描述[选填]")
    private String infoRemark;

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Integer getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(Integer infoCode) {
        this.infoCode = infoCode;
    }

    public String getInfoRemark() {
        return infoRemark;
    }

    public void setInfoRemark(String infoRemark) {
        this.infoRemark = infoRemark;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    @Override
    public String toString() {
        return "DictInfoAddReq{" +
                "dictId=" + dictId +
                ", infoContent='" + infoContent + '\'' +
                ", infoCode=" + infoCode +
                ", infoRemark='" + infoRemark + '\'' +
                '}';
    }
}
