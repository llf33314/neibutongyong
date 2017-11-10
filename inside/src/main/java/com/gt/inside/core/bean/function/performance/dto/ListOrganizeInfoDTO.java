package com.gt.inside.core.bean.function.performance.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
@ApiModel(value = "组织评分详情")
public class ListOrganizeInfoDTO {

    @ApiModelProperty(value = "自评分id")
    private Integer id; // 自评分id

    @ApiModelProperty(value = "评价状态（0：已评，1：未评）")
    private Integer orgScoreStatus; // 评价状态（0：已评，1：未评）")

    @ApiModelProperty(value = "评级纬度")
    private String performanceName; // 评级纬度

    @ApiModelProperty(value = "评价内容")
    private String performanceContent; // 评价内容

    @ApiModelProperty(value = "标准分")
    private Integer performanceScore; // 标准分

    @ApiModelProperty(value = "自评分")
    private Integer ownScore; // 自评分

    @ApiModelProperty(value = "组织评分")
    private Integer orgScore; // 组织评分

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

    public Integer getOrgScoreStatus() {
        return orgScoreStatus;
    }

    public void setOrgScoreStatus(Integer orgScoreStatus) {
        this.orgScoreStatus = orgScoreStatus;
    }

    public Integer getOrgScore() {
        return orgScore;
    }

    public void setOrgScore(Integer orgScore) {
        this.orgScore = orgScore;
    }

    @Override
    public String toString() {
        return "ListOrganizeInfoDTO{" +
                "id=" + id +
                ", orgScoreStatus=" + orgScoreStatus +
                ", performanceName='" + performanceName + '\'' +
                ", performanceContent='" + performanceContent + '\'' +
                ", performanceScore=" + performanceScore +
                ", ownScore=" + ownScore +
                ", orgScore=" + orgScore +
                '}';
    }
}
