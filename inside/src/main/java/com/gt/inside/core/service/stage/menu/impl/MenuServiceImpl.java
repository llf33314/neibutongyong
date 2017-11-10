package com.gt.inside.core.service.stage.menu.impl;

import com.gt.inside.core.bean.stage.menu.dto.MenuMainDTO;
import com.gt.inside.core.entity.stage.menu.Menu;
import com.gt.inside.core.dao.stage.menu.MenuDAO;
import com.gt.inside.core.service.stage.menu.MenuService;
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
 * @since 2017-10-27
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDAO, Menu> implements MenuService {

    @Autowired
    MenuDAO menuDAO;

    /**
     * 获取所有菜单及其子菜单
     *
     * @return
     */
    @Override
    public List<MenuMainDTO> selectListAllMenuWithSub() {
        return menuDAO.selectListAllMenuWithSub();
    }
}
