package com.gt.inside.core.bean.devproject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/10 0010.
 */
@ApiModel("开发项目返回对象")
public class DevProjectVO {

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目结束天数")
    private String endDayNum;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEndDayNum() {
        return endDayNum;
    }

    public void setEndDayNum(String endDayNum) {
        this.endDayNum = endDayNum;
    }

    @Override
    public String toString() {
        return "DevProjectVO{" +
                "projectName='" + projectName + '\'' +
                ", endDayNum='" + endDayNum + '\'' +
                '}';
    }
}
