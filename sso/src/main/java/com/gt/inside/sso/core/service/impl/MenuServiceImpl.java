package com.gt.inside.sso.core.service.impl;

import com.gt.inside.api.dto.MenuDTO;
import com.gt.inside.sso.core.entity.Menu;
import com.gt.inside.sso.core.dao.MenuDAO;
import com.gt.inside.sso.core.service.MenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDAO, Menu> implements MenuService {

    @Autowired
    MenuDAO menuDAO;

    /**
     * 根据用户角色获取相应的菜单
     *
     * @param userId
     * @return
     */
    @Override
    public List<MenuDTO> selectListUserRoleMenuDTO(int userId) {
        return menuDAO.selectListUserRoleMenuDTO(userId);
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    @Override
    public List<MenuDTO> selectListAllMenuDTO() {
        return menuDAO.selectListAllMenuDTO();
    }
}
