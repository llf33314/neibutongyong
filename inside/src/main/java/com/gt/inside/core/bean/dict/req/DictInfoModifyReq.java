package com.gt.inside.core.bean.dict.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by psr on 2017/10/25 0025.
 */
@ApiModel(value = "修改字典详情")
public class DictInfoModifyReq {

    @ApiModelProperty(value = "字典详情id")
    @NotNull(message = "字典详情id不能为空")
    private Integer id;

    @ApiModelProperty(value = "字典详情内容")
    @NotNull(message = "字典详情内容不能为空")
    private String infoContent;

    @ApiModelProperty(value = "字典详情编码")
    @NotNull(message = "字典详情编码不能为空")
    private Integer infoCode;

    @ApiModelProperty(value = "字典详情描述[选填]")
    private String infoRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "DictInfoModifyReq{" +
                "id=" + id +
                ", infoContent='" + infoContent + '\'' +
                ", infoCode=" + infoCode +
                ", infoRemark='" + infoRemark + '\'' +
                '}';
    }
}
