package com.gt.inside.core.service.function.performance.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeInfoDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceInfo;
import com.gt.inside.core.dao.function.performance.StaffPerformanceInfoDAO;
import com.gt.inside.core.service.function.performance.StaffPerformanceInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工绩效评分详情表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Service
public class StaffPerformanceInfoServiceImpl extends ServiceImpl<StaffPerformanceInfoDAO, StaffPerformanceInfo> implements StaffPerformanceInfoService {

    @Autowired
    StaffPerformanceInfoDAO staffPerformanceInfoDAO;

    /**
     * 根据员工与月份查询评分详情
     *
     * @param staffId
     * @param monthId
     * @return
     */
    @Override
    public List<StaffPerformanceInfo> selectListByStaffIdAndMonthId(Integer staffId, Integer monthId) {
        EntityWrapper<StaffPerformanceInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("staff_id", staffId);
        entityWrapper.eq("month_id", monthId);
        return selectList(entityWrapper);
    }

    /**
     * 根据员工，月份，组织id，组织码查询组织评分详情
     *
     * @param orgCode
     * @param staffId
     * @param monthId
     * @param orgId
     * @return
     */
    @Override
    public List<ListOrganizeInfoDTO> selectOrganizeListByStaffIdAndMonthIdAndOrgId(Integer staffId, Integer monthId, Integer orgId, Integer orgCode) {
        return staffPerformanceInfoDAO.selectOrganizeListByStaffIdAndMonthIdAndOrgId(staffId, monthId, orgId, orgCode);
    }

    /**
     * 获取员工们相关组织，相关月份的评分信息
     *
     * @param staffIds
     * @param monthId
     * @param orgCode
     * @return
     */
    @Override
    public List<ListOrganizeInfoDTO> selectListByStaffIdsAndMonthIdAndOrgCode(List<Integer> staffIds, Integer monthId, Integer orgCode) {
        return staffPerformanceInfoDAO.selectListByStaffIdsAndMonthIdAndOrgCode(staffIds, monthId, orgCode);
    }
}
