package com.gt.inside.core.service.function.performance;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceOrganize;

import java.util.List;

/**
 * <p>
 * 员工绩效评分组织关系表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
public interface StaffPerformanceOrganizeService extends IService<StaffPerformanceOrganize> {

    /**
     * 通过员工id获取员工对应code的组织关系
     * @param code
     * @param staffIdList
     * @return
     */
    List<ListOrganizeDTO> selectListByOrgCode(Integer code, List<Integer> staffIdList);

    /**
     * 通过组织关系获取员工信息
     * @param page
     * @param staffOrgId
     * @param code
     * @return
     */
    List<ListOrganizeDTO> selectPageByOrgIdAndCode(Page<ListOrganizeDTO> page, Integer staffOrgId, Integer code);
}
