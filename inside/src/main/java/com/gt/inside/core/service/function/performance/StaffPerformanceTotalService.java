package com.gt.inside.core.service.function.performance;

import com.gt.inside.core.bean.function.performance.dto.ListOrganizeTotalDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceTotal;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 员工绩效汇总表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
public interface StaffPerformanceTotalService extends IService<StaffPerformanceTotal> {
    /**
     * 根据组织关系，获取员工对应评分信息
     * @param staffIds
     * @param code
     * @return
     */
    List<ListOrganizeTotalDTO> selectListWithOrgCode(List<Integer> staffIds, Integer code, Integer staffOrgId);

    /**
     * 根据组织关系及月份，获取员工对应评分信息
     * @param staffIds
     * @param code
     * @param staffOrgId
     * @param monthId
     * @return
     */
    List<ListOrganizeTotalDTO> selectListByMonIdWithOrgCode(List<Integer> staffIds, Integer code, Integer staffOrgId, Integer monthId);
}
