package com.gt.inside.core.dao.stage.role;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.core.bean.stage.role.dto.RoleUserHasDTO;
import com.gt.inside.core.entity.stage.role.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 角色表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-27
 */
public interface RoleDAO extends BaseMapper<Role> {
    /**
     * 分页获取用户角色关系
     * @param page
     * @param userId
     * @return
     */
    List<RoleUserHasDTO> listRoleUserHas(@Param("page") Page<RoleUserHasDTO> page, @Param("userId") Integer userId);
}