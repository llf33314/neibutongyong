package com.gt.inside.core.bean.dict.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/17 0017.
 */
@ApiModel(value = "分页获取字典")
public class DictListReq extends PageReq {

    @ApiModelProperty(value = "字典名或字典代号[查询条件选填]")
    private String dictSearch;

    public String getDictSearch() {
        return dictSearch;
    }

    public void setDictSearch(String dictSearch) {
        this.dictSearch = dictSearch;
    }

    @Override
    public String toString() {
        return "DictListReq{" +
                "dictSearch='" + dictSearch + '\'' +
                ", current=" + current +
                ", size=" + size +
                '}';
    }
}
