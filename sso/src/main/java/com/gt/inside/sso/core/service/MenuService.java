package com.gt.inside.sso.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.api.dto.MenuDTO;
import com.gt.inside.sso.core.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
public interface MenuService extends IService<Menu> {

    /**
     * 根据用户角色获取相应的菜单
     * @param userId
     * @return
     */
    List<MenuDTO> selectListUserRoleMenuDTO(int userId);

    /**
     * 获取所有菜单
     * @return
     */
    List<MenuDTO> selectListAllMenuDTO();
}
