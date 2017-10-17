package com.gt.inside.core.bean.devproject.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by psr on 2017/10/17 0017.
 */
@ApiModel(value = "开发项目返回类")
public class DevProjectListRes {

    @ApiModelProperty(value = "项目id")
    private Integer id; // 项目id

    @ApiModelProperty(value = "项目名")
    private String projectName; // 项目名

    @ApiModelProperty(value = "项目完成时间")
    private Date projectTime; // 项目完成时间

    @ApiModelProperty(value = "项目状态（0：进行中，1：已完成）")
    private Integer projectStatus; // 项目状态（0：进行中，1：已完成）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(Date projectTime) {
        this.projectTime = projectTime;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }
}
