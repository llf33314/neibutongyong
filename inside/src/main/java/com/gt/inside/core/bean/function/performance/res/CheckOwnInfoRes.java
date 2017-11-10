package com.gt.inside.core.bean.function.performance.res;

import com.gt.inside.api.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by psr on 2017/11/1 0001.
 */
@ApiModel(value = "查询自评分信息对象")
public class CheckOwnInfoRes {

    @ApiModelProperty(value = "用户名")
    private String userName; // 用户名

    @ApiModelProperty(value = "查询是否已评分（true：已评，false：未评）")
    private boolean checkOwnInfoBoolean = true; // 查询是否已评分，默认已评

    @ApiModelProperty(value = "查询是否已评分，默认已评")
    private String monthDate; // 月份时间

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isCheckOwnInfoBoolean() {
        return checkOwnInfoBoolean;
    }

    public void setCheckOwnInfoBoolean(boolean checkOwnInfoBoolean) {
        this.checkOwnInfoBoolean = checkOwnInfoBoolean;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }

    @Override
    public String toString() {
        return "CheckOwnInfoRes{" +
                "userName='" + userName + '\'' +
                ", checkOwnInfoBoolean=" + checkOwnInfoBoolean +
                ", monthDate=" + monthDate +
                '}';
    }
}
