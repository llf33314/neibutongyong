package com.gt.inside.sso.core.dao;

import com.gt.inside.sso.core.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 角色表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
public interface RoleDAO extends BaseMapper<Role> {

    Integer selectUserRoleStatus(int userId);
}