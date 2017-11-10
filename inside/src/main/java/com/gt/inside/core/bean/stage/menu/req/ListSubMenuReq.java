package com.gt.inside.core.bean.stage.menu.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/8 0008.
 */
@ApiModel(value = "分页获取子菜单")
public class ListSubMenuReq extends PageReq {

    @ApiModelProperty(value = "主菜单id")
    @NotNull(message = "主菜单id不能为空")
    private Integer pid; // 主菜单id

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "ListSubMenuReq{" +
                "current=" + current +
                ", pid=" + pid +
                ", size=" + size +
                '}';
    }
}
