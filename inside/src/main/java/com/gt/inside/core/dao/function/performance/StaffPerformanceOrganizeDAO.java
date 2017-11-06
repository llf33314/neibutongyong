package com.gt.inside.core.dao.function.performance;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeDTO;
import com.gt.inside.core.entity.function.performance.StaffPerformanceOrganize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 员工绩效评分组织关系表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
public interface StaffPerformanceOrganizeDAO extends BaseMapper<StaffPerformanceOrganize> {

    /**
     * 根据code查询组织关系
     * @param code
     * @param staffIdList
     * @return
     */
    List<ListOrganizeDTO> selectListByOrgCode(@Param("code") Integer code, @Param("staffIdList") List<Integer> staffIdList);

    /**
     * 通过组织关系获取员工信息
     * @param page
     * @param staffOrgId
     * @param code
     * @return
     */
    List<ListOrganizeDTO> selectPageByOrgIdAndCode(@Param("page") Page<ListOrganizeDTO> page, @Param("staffOrgId") Integer staffOrgId, @Param("code") Integer code);
}