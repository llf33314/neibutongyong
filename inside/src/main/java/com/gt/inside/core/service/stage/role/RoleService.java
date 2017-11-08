package com.gt.inside.core.service.stage.role;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.core.bean.stage.role.dto.RoleUserHasDTO;
import com.gt.inside.core.entity.stage.role.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-27
 */
public interface RoleService extends IService<Role> {
    /**
     * 分页获取角色用户关系
     * @param page
     * @param userId
     * @return
     */
    List<RoleUserHasDTO> listRoleUserHas(Page<RoleUserHasDTO> page, Integer userId);
}
