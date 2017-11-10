package com.gt.inside.core.bean.project.devproject.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by psr on 2017/10/17 0017.
 */
@ApiModel(value = "编辑对象")
public class DevProjectModifyReq {

    @ApiModelProperty(value = "项目id")
    @NotNull(message = "项目id不能为空")
    private Integer id; // 项目id

    @ApiModelProperty(value = "项目名")
    @NotNull(message = "项目名不能为空")
    private String projectName; // 项目名

    @ApiModelProperty(value = "项目完成时间")
    @NotNull(message = "项目完成时间不能为空")
    private Date projectTime; // 项目完成时间

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
