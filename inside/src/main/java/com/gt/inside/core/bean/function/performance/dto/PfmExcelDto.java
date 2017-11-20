package com.gt.inside.core.bean.function.performance.dto;

import com.gt.inside.api.util.excel.ExcelResources;

/**
 * Created by psr on 2017/11/6 0006.
 */
public class PfmExcelDto {

    private Integer index; // 序号

    private String name; // 姓名

    private String duties; // 职务

    private String pLevel; // 级别

    private String scoreOrg = "直属领导评分"; // 评分组织

    private Integer duty = 0; // 责任感

    private Integer active = 0; // 积极性

    private Integer cooperation = 0; // 协作性

    private Integer execute = 0; // 执行力

    private Integer study = 0; // 学习发展能力

    private Integer knowledge = 0; // 专业知识

    private String workContent; // 工作业绩

    private Integer workScore = 0; // 业绩分

    private Integer totalScre = 0; // 总分

    private String level; // 评级

    @ExcelResources(title = "", order = 1)
    public Integer getIndex() {
        return index;
    }

    @ExcelResources(title = "", order = 2)
    public String getName() {
        return name;
    }

    @ExcelResources(title = "", order = 3)
    public String getDuties() {
        return duties;
    }

    @ExcelResources(title = "", order = 4)
    public String getpLevel() {
        return pLevel;
    }

    @ExcelResources(title = "", order = 5)
    public String getScoreOrg() {
        return scoreOrg;
    }

    @ExcelResources(title = "", order = 6)
    public Integer getDuty() {
        return duty;
    }

    @ExcelResources(title = "", order = 7)
    public Integer getActive() {
        return active;
    }

    @ExcelResources(title = "", order = 8)
    public Integer getCooperation() {
        return cooperation;
    }

    @ExcelResources(title = "", order = 9)
    public Integer getExecute() {
        return execute;
    }

    @ExcelResources(title = "", order = 10)
    public Integer getStudy() {
        return study;
    }

    @ExcelResources(title = "", order = 11)
    public Integer getKnowledge() {
        return knowledge;
    }

    @ExcelResources(title = "", order = 12)
    public String getWorkContent() {
        return workContent;
    }

    @ExcelResources(title = "", order = 13)
    public Integer getWorkScore() {
        return workScore;
    }

    @ExcelResources(title = "", order = 14)
    public Integer getTotalScre() {
        return totalScre;
    }

    @ExcelResources(title = "", order = 15)
    public String getLevel() {
        return level;
    }

    /**
     * 序号
     * @param index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 职务
     * @param duties
     */
    public void setDuties(String duties) {
        this.duties = duties;
    }

    /**
     * P级别
     * @param pLevel
     */
    public void setpLevel(String pLevel) {
        this.pLevel = pLevel;
    }

    /**
     * 评分组织
     * @param scoreOrg
     */
    public void setScoreOrg(String scoreOrg) {
        this.scoreOrg = scoreOrg;
    }

    /**
     * 责任感
     * @param duty
     */
    public void setDuty(Integer duty) {
        this.duty = duty;
    }

    /**
     * 积极性
     * @param active
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     * 协作性
     * @param cooperation
     */
    public void setCooperation(Integer cooperation) {
        this.cooperation = cooperation;
    }

    /**
     * 执行力
     * @param execute
     */
    public void setExecute(Integer execute) {
        this.execute = execute;
    }

    /**
     * 学习发展能力
     * @param study
     */
    public void setStudy(Integer study) {
        this.study = study;
    }

    /**
     * 专业知识
     * @param knowledge
     */
    public void setKnowledge(Integer knowledge) {
        this.knowledge = knowledge;
    }

    /**
     * 工作业绩
     * @param workContent
     */
    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    /**
     * 业绩分
     * @param workScore
     */
    public void setWorkScore(Integer workScore) {
        this.workScore = workScore;
    }

    /**
     * 总分
     * @param totalScre
     */
    public void setTotalScre(Integer totalScre) {
        this.totalScre = totalScre;
    }

    /**
     * 总分
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }
}
