package com.gt.inside.core.service.function.performance.impl;

import com.gt.inside.core.bean.function.performance.dto.ListOrganizeTotalDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceTotal;
import com.gt.inside.core.dao.function.performance.StaffPerformanceTotalDAO;
import com.gt.inside.core.service.function.performance.StaffPerformanceTotalService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工绩效汇总表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Service
public class StaffPerformanceTotalServiceImpl extends ServiceImpl<StaffPerformanceTotalDAO, StaffPerformanceTotal> implements StaffPerformanceTotalService {

    @Autowired
    StaffPerformanceTotalDAO staffPerformanceTotalDAO;

    /**
     * 根据组织关系，获取员工对应评分信息
     *
     * @param staffIds
     * @param code
     * @return
     */
    @Override
    public List<ListOrganizeTotalDTO> selectListWithOrgCode(List<Integer> staffIds, Integer code, Integer staffOrgId) {
        return staffPerformanceTotalDAO.selectListWithOrgCode(staffIds, code, staffOrgId);
    }

    /**
     * 根据组织关系及月份，获取员工对应评分信息
     *
     * @param staffIds
     * @param code
     * @param staffOrgId
     * @param monthId
     * @return
     */
    @Override
    public List<ListOrganizeTotalDTO> selectListByMonIdWithOrgCode(List<Integer> staffIds, Integer code, Integer staffOrgId, Integer monthId) {
        return staffPerformanceTotalDAO.selectListByMonIdWithOrgCode(staffIds, code, staffOrgId, monthId);
    }
}
