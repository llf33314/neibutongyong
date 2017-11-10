package com.gt.inside.core.bean.organize.staff.req;

import com.gt.inside.api.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 * Created by psr on 2017/10/26 0026.
 */
@ApiModel(value = "分页获取员工")
public class StaffListReq extends PageReq {

    @ApiModelProperty(value = "员工搜索信息[选填]")
    private String staffSearch;

    @ApiModelProperty(value = "员工状态（0：在职，1：离职）")
    private Integer staffStatus;

    public String getStaffSearch() {
        return staffSearch;
    }

    public void setStaffSearch(String staffSearch) {
        this.staffSearch = staffSearch;
    }

    public Integer getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(Integer staffStatus) {
        this.staffStatus = staffStatus;
    }

    @Override
    public String toString() {
        return "StaffListReq{" +
                "staffSearch='" + staffSearch + '\'' +
                ", current=" + current +
                ", staffStatus=" + staffStatus +
                ", size=" + size +
                '}';
    }
}
