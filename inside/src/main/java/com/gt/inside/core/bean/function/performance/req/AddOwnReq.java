package com.gt.inside.core.bean.function.performance.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "新增自评分")
public class AddOwnReq {

    @ApiModelProperty(value = "状态（0：可编辑，1：不可编辑）")
    private Integer status; // 状态（0：可编辑，1：不可编辑）

    @ApiModelProperty(value = "评分码，对应字典1002详情code")
    private Integer performanceCode; // 评分码，对应字典1002详情code

    @ApiModelProperty(value = "评级纬度")
    private String performanceName; // 评级纬度

    @ApiModelProperty(value = "评价内容")
    @NotNull(message = "评价内容不能为空")
    private String performanceContent; // 评价内容

    @ApiModelProperty(value = "标准分")
    private Integer performanceScore; // 标准分

    @ApiModelProperty(value = "自评分")
    @NotNull(message = "分数不能为空")
    private Integer ownScore; // 自评分

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getPerformanceContent() {
        return performanceContent;
    }

    public void setPerformanceContent(String performanceContent) {
        this.performanceContent = performanceContent;
    }

    public Integer getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Integer performanceScore) {
        this.performanceScore = performanceScore;
    }

    public Integer getOwnScore() {
        return ownScore;
    }

    public void setOwnScore(Integer ownScore) {
        this.ownScore = ownScore;
    }

    public Integer getPerformanceCode() {
        return performanceCode;
    }

    public void setPerformanceCode(Integer performanceCode) {
        this.performanceCode = performanceCode;
    }

    @Override
    public String toString() {
        return "AddOwnReq{" +
                "status=" + status +
                ", performanceCode=" + performanceCode +
                ", performanceName='" + performanceName + '\'' +
                ", performanceContent='" + performanceContent + '\'' +
                ", performanceScore=" + performanceScore +
                ", ownScore=" + ownScore +
                '}';
    }
}
