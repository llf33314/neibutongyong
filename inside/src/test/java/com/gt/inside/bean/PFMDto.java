package com.gt.inside.bean;

import com.gt.inside.api.util.excel.ExcelResources;

/**
 * Created by psr on 2017/11/6 0006.
 */
public class PFMDto {

    private Integer index; // 序号

    private String name; // 姓名

    private String zw; // 职务

    private String jb; // 级别

    private Integer zrg = 5; // 责任感

    private Integer jjx = 10; // 积极性

    private Integer xzx = 10; // 协作性

    private Integer zxl = 5; // 执行力

    private Integer xxl = 10; // 学习发展能力

    private Integer zyzs = 5; // 专业知识

    private String gzyj; // 工作业绩

    private Integer yj = 60; // 业绩分

    private Integer total = 100; // 总分

    private String level; // 评级

    @ExcelResources(title="",order=1)
    public Integer getIndex() {
        return index;
    }

    @ExcelResources(title="",order=2)
    public String getName() {
        return name;
    }

    @ExcelResources(title="",order=3)
    public String getZw() {
        return zw;
    }

    @ExcelResources(title="",order=4)
    public String getJb() {
        return jb;
    }

    @ExcelResources(title="",order=6)
    public Integer getZrg() {
        return zrg;
    }

    @ExcelResources(title="",order=7)
    public Integer getJjx() {
        return jjx;
    }

    @ExcelResources(title="",order=8)
    public Integer getXzx() {
        return xzx;
    }

    @ExcelResources(title="",order=9)
    public Integer getZxl() {
        return zxl;
    }

    @ExcelResources(title="",order=10)
    public Integer getXxl() {
        return xxl;
    }

    @ExcelResources(title="",order=11)
    public Integer getZyzs() {
        return zyzs;
    }

    @ExcelResources(title="",order=12)
    public String getGzyj() {
        return gzyj;
    }

    @ExcelResources(title="",order=15)
    public Integer getYj() {
        return yj;
    }

    @ExcelResources(title="",order=16)
    public Integer getTotal() {
        return total;
    }

    @ExcelResources(title="",order=17)
    public String getLevel() {
        return level;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    public void setGzyj(String gzyj) {
        this.gzyj = gzyj;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
