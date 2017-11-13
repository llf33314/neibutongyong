package com.gt.inside.core.bean.function.performance.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/13 0013.
 */
@ApiModel(value = "绩效权限")
public class PowerRes {

    @ApiModelProperty(value = "组织关系设置")
    private boolean organizeSetFlag = false;

    @ApiModelProperty(value = "自评分")
    private boolean ownFlag = true;

    @ApiModelProperty(value = "直属领导评分")
    private boolean directlyFlag = false;

    @ApiModelProperty(value = "分管领导评分")
    private boolean branchFlag = false;

    public boolean isOrganizeSetFlag() {
        return organizeSetFlag;
    }

    public void setOrganizeSetFlag(boolean organizeSetFlag) {
        this.organizeSetFlag = organizeSetFlag;
    }

    public boolean isDirectlyFlag() {
        return directlyFlag;
    }

    public void setDirectlyFlag(boolean directlyFlag) {
        this.directlyFlag = directlyFlag;
    }

    public boolean isBranchFlag() {
        return branchFlag;
    }

    public void setBranchFlag(boolean branchFlag) {
        this.branchFlag = branchFlag;
    }

    public boolean isOwnFlag() {
        return ownFlag;
    }

    public void setOwnFlag(boolean ownFlag) {
        this.ownFlag = ownFlag;
    }

    @Override
    public String toString() {
        return "PowerRes{" +
                "organizeSetFlag=" + organizeSetFlag +
                ", ownFlag=" + ownFlag +
                ", directlyFlag=" + directlyFlag +
                ", branchFlag=" + branchFlag +
                '}';
    }
}
