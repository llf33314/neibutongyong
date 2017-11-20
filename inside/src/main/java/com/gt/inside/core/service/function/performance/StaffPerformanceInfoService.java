package com.gt.inside.core.service.function.performance;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeInfoDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceInfo;

import java.util.List;

/**
 * <p>
 * 员工绩效评分详情表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
public interface StaffPerformanceInfoService extends IService<StaffPerformanceInfo> {
    /**
     * 根据员工与月份查询评分详情
     * @param id
     * @param id1
     * @return
     */
    List<StaffPerformanceInfo> selectListByStaffIdAndMonthId(Integer id, Integer id1);

    /**
     * 根据员工，月份，组织id，组织码查询组织评分详情
     *
     * @param orgCode
     * @param staffId
     * @param monthId
     * @param orgId
     * @return
     */
    List<ListOrganizeInfoDTO> selectOrganizeListByStaffIdAndMonthIdAndOrgId(Integer staffId, Integer monthId, Integer orgId, Integer orgCode);

    /**
     * 获取员工们相关组织，相关月份的评分信息
     * @param staffIds
     * @param monthId
     * @param orgCode
     * @return
     */
    List<ListOrganizeInfoDTO> selectListByStaffIdsAndMonthIdAndOrgCode(List<Integer> staffIds, Integer monthId, Integer orgCode);
}
