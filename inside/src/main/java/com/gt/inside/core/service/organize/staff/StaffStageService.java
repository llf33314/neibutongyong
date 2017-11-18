package com.gt.inside.core.service.organize.staff;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.organize.staff.req.*;
import com.gt.inside.core.bean.organize.staff.res.ListStaffDutiesRes;
import com.gt.inside.core.bean.organize.staff.res.ListStaffLevelRes;
import com.gt.inside.core.bean.organize.staff.res.ListStaffTypeRes;
import com.gt.inside.core.entity.organize.staff.Staff;

import java.util.List;

/**
 * Created by psr on 2017/10/26 0026.
 */
public interface StaffStageService {
    /**
     * 分页获取员工
     * @param staffListReq
     * @return
     */
    ResponseDTO<List<Staff>> listStaffByPage(StaffListReq staffListReq);

    /**
     * 新增员工
     * @param staffAddReq
     */
    void addStaff(StaffAddReq staffAddReq);

    /**
     * 修改员工
     * @param staffModifyReq
     */
    void modifyStaff(StaffModifyReq staffModifyReq);

    /**
     * 删除员工
     * @param staffDelReq
     */
    void delStaff(StaffDelReq staffDelReq);

    /**
     * 离职员工
     * @param staffQuitReq
     */
    void quitStaff(StaffQuitReq staffQuitReq);

    /**
     * 员工类型列表
     * @return
     */
    List<ListStaffTypeRes> listStaffType();

    /**
     * 员工级别列表
     * @return
     */
    List<ListStaffLevelRes> listStaffLevel(ListStaffLevelReq listStaffLevelReq);

    /**
     * 员工职务列表
     * @return
     */
    List<ListStaffDutiesRes> listStaffDuties();
}
