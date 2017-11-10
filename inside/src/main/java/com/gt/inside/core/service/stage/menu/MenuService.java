package com.gt.inside.core.service.stage.menu;

import com.gt.inside.core.bean.stage.menu.dto.MenuMainDTO;
import com.gt.inside.core.entity.stage.menu.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-27
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取所有菜单及其子菜单
     * @return
     */
    List<MenuMainDTO> selectListAllMenuWithSub();

}
