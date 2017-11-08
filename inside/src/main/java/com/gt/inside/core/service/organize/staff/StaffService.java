package com.gt.inside.core.service.organize.staff;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.core.entity.organize.staff.Staff;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-26
 */
public interface StaffService extends IService<Staff> {

    /**
     * 根据用户id查询员工
     * @param userId
     */
    Staff selectByUserId(Integer userId);

    /**
     * 删除员工用户id
     * @param staff
     */
    void delUserId(Staff staff);
}
