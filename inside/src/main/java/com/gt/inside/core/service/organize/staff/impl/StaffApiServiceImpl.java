package com.gt.inside.core.service.organize.staff.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.service.organize.staff.StaffApiService;
import com.gt.inside.core.service.organize.staff.StaffService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by psr on 2017/10/26 0026.
 */
@Service
public class StaffApiServiceImpl implements StaffApiService {

    private static Logger logger = Logger.getLogger(StaffApiServiceImpl.class);

    @Autowired
    StaffService staffService;

    /**
     * 根据用户id查找关联的员工
     *
     * @param userId
     * @return
     */
    @Override
    public Staff getStaffByUserId(Integer userId) {
        logger.debug("userId --> " + userId);
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("user_id", userId);
        Staff staff = staffService.selectOne(entityWrapper);
        return staff;
    }
}
