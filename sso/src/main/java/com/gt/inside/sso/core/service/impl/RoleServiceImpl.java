package com.gt.inside.sso.core.service.impl;

import com.gt.inside.sso.core.entity.Role;
import com.gt.inside.sso.core.dao.RoleDAO;
import com.gt.inside.sso.core.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDAO, Role> implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    /**
     * 获取用户角色权限
     *
     * @param userId
     * @return
     */
    @Override
    public Integer selectUserRoleStatus(int userId) {
        return roleDAO.selectUserRoleStatus(userId);
    }
}
