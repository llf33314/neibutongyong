package com.gt.inside.core.dao.function.performance;

import com.gt.inside.core.bean.function.performance.dto.ListOrganizeInfoDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 员工绩效评分详情表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
public interface StaffPerformanceInfoDAO extends BaseMapper<StaffPerformanceInfo> {
    /**
     * 根据员工，月份，组织id，组织码查询组织评分详情
     * @param staffId
     * @param monthId
     * @param orgId
     * @param orgCode
     * @return
     */
    List<ListOrganizeInfoDTO> selectOrganizeListByStaffIdAndMonthIdAndOrgId(@Param("staffId") Integer staffId, @Param("monthId") Integer monthId, @Param("orgId") Integer orgId, @Param("orgCode") Integer orgCode);

    /**
     * 获取员工们相关组织，相关月份的评分信息
     * @param staffIds
     * @param monthId
     * @param orgCode
     * @return
     */
    List<ListOrganizeInfoDTO> selectListByStaffIdsAndMonthIdAndOrgCode(@Param("staffIds") List<Integer> staffIds, @Param("monthId") Integer monthId, @Param("orgCode") Integer orgCode);
}