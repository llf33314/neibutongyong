package com.gt.inside.core.bean.stage.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/7 0007.
 */
@ApiModel(value = "修改密码")
public class ModifyPwdReq {

    @ApiModelProperty(value = "旧密码")
    @NotNull(message = "旧密码不能为空")
    private String oldPwd; // 旧密码

    @ApiModelProperty(value = "新密码")
    @NotNull(message = "新密码不能为空")
    private String newPwd; // 新密码

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public String toString() {
        return "ModifyPwdReq{" +
                "oldPwd='" + oldPwd + '\'' +
                ", newPwd='" + newPwd + '\'' +
                '}';
    }
}
