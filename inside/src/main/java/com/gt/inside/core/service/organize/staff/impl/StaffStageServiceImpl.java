package com.gt.inside.core.service.organize.staff.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.organize.staff.req.*;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.exception.organize.staff.StaffException;
import com.gt.inside.core.service.organize.staff.StaffService;
import com.gt.inside.core.service.organize.staff.StaffStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by psr on 2017/10/26 0026.
 */
@Service
public class StaffStageServiceImpl implements StaffStageService {

    @Autowired
    StaffService staffService;

    /**
     * 分页获取员工
     *
     * @param staffListReq
     * @return
     */
    @Override
    public ResponseDTO<List<Staff>> listStaffByPage(StaffListReq staffListReq) {
        Page<Staff> page = new Page<>(staffListReq.getCurrent(), staffListReq.getSize());
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        if (CommonUtil.isNotEmpty(staffListReq.getStaffSearch())){
            entityWrapper.like("staff_code", staffListReq.getStaffSearch()).or().like("staff_name", staffListReq.getStaffSearch())
            .or().like("staff_phone", staffListReq.getStaffSearch());
        }
        if (CommonUtil.isNotEmpty(staffListReq.getStaffStatus())){
            entityWrapper.eq("staff_status", staffListReq.getStaffStatus());
        }
        List<Staff> staffList = staffService.selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取员工成功", staffList, pageDTO);
    }

    /**
     * 新增员工
     *
     * @param staffAddReq
     */
    @Override
    public void addStaff(StaffAddReq staffAddReq) {
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("staff_code", staffAddReq.getStaffCode());
        Staff staffSelect = staffService.selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(staffSelect)){
            throw new StaffException(ResponseEnums.STAFF_HAS);
        }
        Staff staff = new Staff();
        staff.setCreateTime(new Date());
        staff.setDeleteFlag(0);
        staff.setDepId(staffAddReq.getDepId());
        staff.setStaffCode(staffAddReq.getStaffCode());
        staff.setStaffJoinTime(staffAddReq.getStaffJoinTime());
        staff.setStaffName(staffAddReq.getStaffName());
        staff.setStaffEnName(staffAddReq.getStaffEnName());
        staff.setStaffPhone(staffAddReq.getStaffPhone());
        staff.setStaffStatus(0);
        staffService.insertAllColumn(staff);
    }

    /**
     * 修改员工
     *
     * @param staffModifyReq
     */
    @Override
    public void modifyStaff(StaffModifyReq staffModifyReq) {
        EntityWrapper<Staff> entityWrapperCheck = new EntityWrapper<>();
        entityWrapperCheck.eq("delete_flag", 0);
        entityWrapperCheck.eq("staff_code", staffModifyReq.getStaffCode());
        Staff staffSelect = staffService.selectOne(entityWrapperCheck);
        if (CommonUtil.isNotEmpty(staffSelect) && !staffSelect.getId().equals(staffModifyReq.getId())){
            throw new StaffException(ResponseEnums.STAFF_HAS);
        }
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", staffModifyReq.getId());
        Staff staff = staffService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(staff)){
            throw new StaffException(ResponseEnums.MODIFY_NULL);
        }
        staff.setDepId(staffModifyReq.getDepId());
        staff.setStaffCode(staffModifyReq.getStaffCode());
        staff.setStaffJoinTime(staffModifyReq.getStaffJoinTime());
        staff.setStaffName(staffModifyReq.getStaffName());
        staff.setStaffEnName(staffModifyReq.getStaffEnName());
        staff.setStaffPhone(staffModifyReq.getStaffPhone());
        staffService.updateAllColumnById(staff);
    }

    /**
     * 删除员工
     *
     * @param staffDelReq
     */
    @Override
    public void delStaff(StaffDelReq staffDelReq) {
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", staffDelReq.getId());
        Staff staff = staffService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(staff)){
            throw new StaffException(ResponseEnums.DEL_NULL);
        }
        staff.setDeleteFlag(1);
        staffService.updateById(staff);
        staffService.deleteById(staff.getId());
    }

    /**
     * 离职员工
     *
     * @param staffQuitReq
     */
    @Override
    public void quitStaff(StaffQuitReq staffQuitReq) {
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", staffQuitReq.getId());
        Staff staff = staffService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(staff)){
            throw new StaffException(ResponseEnums.STAFF_NULL);
        }
        staff.setStaffStatus(1);
        staffService.updateById(staff);
    }
}
