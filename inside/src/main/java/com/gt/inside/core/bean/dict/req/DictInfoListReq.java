package com.gt.inside.core.bean.dict.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/17 0017.
 */
@ApiModel(value = "分页获取字典详情")
public class DictInfoListReq extends PageReq {

    @NotNull(message = "字典编号不能为空")
    @ApiModelProperty(value = "字典编号")
    private Integer dictId;

    @ApiModelProperty(value = "字典详情描述内容或字典详情编号[查询条件选填]")
    private String dictSearch;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictSearch() {
        return dictSearch;
    }

    public void setDictSearch(String dictSearch) {
        this.dictSearch = dictSearch;
    }

    @Override
    public String toString() {
        return "DictInfoListReq{" +
                "current=" + current +
                ", dictId=" + dictId +
                ", dictSearch='" + dictSearch + '\'' +
                ", size=" + size +
                '}';
    }
}
