package com.gt.inside.core.dao.function.performance;

import com.gt.inside.core.bean.function.performance.dto.ListOrganizeTotalDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceTotal;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 员工绩效汇总表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
public interface StaffPerformanceTotalDAO extends BaseMapper<StaffPerformanceTotal> {
    /**
     * 根据组织关系，获取员工对应评分信息
     * @param staffIds
     * @param code
     * @return
     */
    List<ListOrganizeTotalDTO> selectListWithOrgCode(@Param("staffIds") List<Integer> staffIds, @Param("code") Integer code, @Param("staffOrgId") Integer staffOrgId);

    /**
     * 根据组织关系及月份，获取员工对应评分信息
     * @param staffIds
     * @param code
     * @param staffOrgId
     * @param monthId
     * @return
     */
    List<ListOrganizeTotalDTO> selectListByMonIdWithOrgCode(@Param("staffIds") List<Integer> staffIds, @Param("code") Integer code, @Param("staffOrgId") Integer staffOrgId, @Param("monthId") Integer monthId);
}