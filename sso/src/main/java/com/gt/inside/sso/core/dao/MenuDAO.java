package com.gt.inside.sso.core.dao;

import com.gt.inside.api.dto.MenuDTO;
import com.gt.inside.sso.core.entity.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 菜单表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
public interface MenuDAO extends BaseMapper<Menu> {

    List<MenuDTO> selectListUserRoleMenuDTO(int userId);

    List<MenuDTO> selectListAllMenuDTO();
}