package com.gt.inside.core.dao.stage.menu;

import com.gt.inside.core.bean.stage.menu.dto.MenuMainDTO;
import com.gt.inside.core.entity.stage.menu.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 菜单表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-27
 */
public interface MenuDAO extends BaseMapper<Menu> {
    /**
     * 获取所有菜单及其子菜单
     * @return
     */
    List<MenuMainDTO> selectListAllMenuWithSub();

}