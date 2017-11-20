package com.gt.inside.core.service.organize.staff;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.core.entity.organize.staff.Staff;

import java.util.List;

/**
 * Created by psr on 2017/10/26 0026.
 */
public interface StaffApiService {

    /**
     * 根据用户id查找关联的员工
     * @param userId
     * @return
     */
    Staff getStaffByUserId(Integer userId);

    /**
     * 分页根据部门查询员工
     * @param current
     * @param size
     * @param departmentId
     */
    Page<Staff> listStaffByPageWithDepart(Integer current, Integer size, Integer departmentId);

    /**
     * 根据id，获取相关用户信息
     * @param staffIds
     * @return
     */
    List<Staff> getStaffByIds(List<Integer> staffIds);
}
