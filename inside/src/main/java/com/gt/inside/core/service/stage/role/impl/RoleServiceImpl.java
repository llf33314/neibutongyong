package com.gt.inside.core.service.stage.role.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.core.bean.stage.role.dto.RoleUserHasDTO;
import com.gt.inside.core.entity.stage.role.Role;
import com.gt.inside.core.dao.stage.role.RoleDAO;
import com.gt.inside.core.service.stage.role.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-27
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDAO, Role> implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    /**
     * 分页获取角色用户关系
     *
     * @param page
     * @param userId
     * @return
     */
    @Override
    public List<RoleUserHasDTO> listRoleUserHas(Page<RoleUserHasDTO> page, Integer userId) {
        return roleDAO.listRoleUserHas(page, userId);
    }
}
