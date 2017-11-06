package com.gt.inside.core.bean.function.performance.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "自评分信息列表")
public class ListOwnInfoRes {

    @ApiModelProperty(value = "自评分id")
    private Integer id; // 自评分id

    @ApiModelProperty(value = "状态（0：可编辑，1：不可编辑）")
    private Integer status; // 状态（0：可编辑，1：不可编辑）

    @ApiModelProperty(value = "评级纬度")
    private String performanceName; // 评级纬度

    @ApiModelProperty(value = "评价内容")
    private String performanceContent; // 评价内容

    @ApiModelProperty(value = "标准分")
    private Integer performanceScore; // 标准分

    @ApiModelProperty(value = "自评分")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnScore() {
        return ownScore;
    }

    public void setOwnScore(Integer ownScore) {
        this.ownScore = ownScore;
    }

    @Override
    public String toString() {
        return "ListOwnInfoRes{" +
                "id=" + id +
                ", status=" + status +
                ", performanceName='" + performanceName + '\'' +
                ", performanceContent='" + performanceContent + '\'' +
                ", performanceScore=" + performanceScore +
                ", ownScore=" + ownScore +
                '}';
    }
}
