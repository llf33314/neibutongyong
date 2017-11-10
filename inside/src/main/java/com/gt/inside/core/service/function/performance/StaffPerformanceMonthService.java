package com.gt.inside.core.service.function.performance;

import com.gt.inside.core.entity.function.performance.StaffPerformanceMonth;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 绩效月份表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
public interface StaffPerformanceMonthService extends IService<StaffPerformanceMonth> {
    /**
     * 获取当前月份信息
     * @return
     */
    StaffPerformanceMonth getNowMonth();
}
