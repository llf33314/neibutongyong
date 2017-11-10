package com.gt.inside.core.service.function.performance.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gt.inside.api.util.DateTimeKit;
import com.gt.inside.core.entity.function.performance.StaffPerformanceMonth;
import com.gt.inside.core.dao.function.performance.StaffPerformanceMonthDAO;
import com.gt.inside.core.service.function.performance.StaffPerformanceMonthService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 绩效月份表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Service
public class StaffPerformanceMonthServiceImpl extends ServiceImpl<StaffPerformanceMonthDAO, StaffPerformanceMonth> implements StaffPerformanceMonthService {

    /**
     * 获取当前月份信息
     *
     * @return
     */
    @Override
    public StaffPerformanceMonth getNowMonth() {
        EntityWrapper<StaffPerformanceMonth> entityWrapperMonth = new EntityWrapper<>();
        entityWrapperMonth.between("month_date", DateTimeKit.formatTimeUntilDay(DateTimeKit.getThisMonthFirstDay()), DateTimeKit.formatTimeUntilDay(DateTimeKit.getThisMonthLastDay()));
        StaffPerformanceMonth staffPerformanceMonth = selectOne(entityWrapperMonth);
        return staffPerformanceMonth;
    }
}
