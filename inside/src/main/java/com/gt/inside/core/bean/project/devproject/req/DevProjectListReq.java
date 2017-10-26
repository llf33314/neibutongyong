package com.gt.inside.core.bean.project.devproject.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/17 0017.
 */
@ApiModel(value = "分页获取开发项目")
public class DevProjectListReq extends PageReq {

    @ApiModelProperty(value = "项目状态（0：进行中，1：已完成）[选填，不填则查找所有]")
    private Integer projectStatus; // 项目状态（0：进行中，1：已完成）

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Override
    public String toString() {
        return "DevProjectListReq{" +
                "projectStatus=" + projectStatus +
                ", current=" + current +
                ", size=" + size +
                '}';
    }
}
