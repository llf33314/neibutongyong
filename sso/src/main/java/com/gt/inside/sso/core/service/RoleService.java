package com.gt.inside.sso.core.service;

import com.gt.inside.sso.core.entity.Role;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取用户角色权限
     * @param userId
     * @return
     */
    Integer selectUserRoleStatus(int userId);
}
