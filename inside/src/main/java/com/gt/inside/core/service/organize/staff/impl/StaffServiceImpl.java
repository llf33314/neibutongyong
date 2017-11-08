package com.gt.inside.core.service.organize.staff.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.core.dao.organize.staff.StaffDAO;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.service.organize.staff.StaffService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-26
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffDAO, Staff> implements StaffService {

    /**
     * 根据用户id查询员工
     *
     * @param userId
     */
    @Override
    public Staff selectByUserId(Integer userId) {
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_id", userId);
        return selectOne(entityWrapper);
    }

    /**
     * 删除员工用户id
     *
     * @param staff
     */
    @Override
    public void delUserId(Staff staff) {
        staff.setUserId(null);
        updateAllColumnById(staff);
    }
}
