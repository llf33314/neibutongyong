package com.gt.inside.core.service.function.performance.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceOrganize;
import com.gt.inside.core.dao.function.performance.StaffPerformanceOrganizeDAO;
import com.gt.inside.core.service.function.performance.StaffPerformanceOrganizeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工绩效评分组织关系表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Service
public class StaffPerformanceOrganizeServiceImpl extends ServiceImpl<StaffPerformanceOrganizeDAO, StaffPerformanceOrganize> implements StaffPerformanceOrganizeService {

    @Autowired
    StaffPerformanceOrganizeDAO staffPerformanceOrganizeDAO;

    /**
     * 获取对应code的组织关系
     *
     * @param code
     * @param staffIdList
     * @return
     */
    @Override
    public List<ListOrganizeDTO> selectListByOrgCode(Integer code, List<Integer> staffIdList) {
        return staffPerformanceOrganizeDAO.selectListByOrgCode(code, staffIdList);
    }

    /**
     * 通过组织关系获取员工信息
     *
     * @param page
     * @param staffOrgId
     * @param code
     * @return
     */
    @Override
    public List<ListOrganizeDTO> selectPageByOrgIdAndCode(Page<ListOrganizeDTO> page, Integer staffOrgId, Integer code) {
        return staffPerformanceOrganizeDAO.selectPageByOrgIdAndCode(page, staffOrgId, code);
    }
}
