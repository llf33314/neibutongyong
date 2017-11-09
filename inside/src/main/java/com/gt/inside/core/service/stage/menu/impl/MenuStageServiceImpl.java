package com.gt.inside.core.service.stage.menu.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.stage.menu.req.*;
import com.gt.inside.core.entity.stage.menu.Menu;
import com.gt.inside.core.exception.stage.menu.MenuException;
import com.gt.inside.core.service.stage.menu.MenuService;
import com.gt.inside.core.service.stage.menu.MenuStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by psr on 2017/11/8 0008.
 */
@Service
public class MenuStageServiceImpl implements MenuStageService {

    @Autowired
    MenuService menuService;

    /**
     * 分页获取菜单
     *
     * @param listMenuReq
     * @return
     */
    @Override
    public ResponseDTO<List<Menu>> listByPage(ListMenuReq listMenuReq) {
        Page<Menu> page = new Page<>(listMenuReq.getCurrent(), listMenuReq.getSize());
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("p_id", 0);
        if (CommonUtil.isNotEmpty(listMenuReq.getMenuSearch())){
            entityWrapper.like("menu_name", listMenuReq.getMenuSearch());
        }
        List<Menu> menuList = menuService.selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取菜单成功", menuList, pageDTO);
    }

    /**
     * 新增菜单
     *
     * @param addMenuReq
     */
    @Override
    public void add(AddMenuReq addMenuReq) {
        Menu menu = new Menu();
        menu.setMenuName(addMenuReq.getMenuName());
        menu.setMenuIcon(addMenuReq.getMenuIcon());
        menu.setMenuSub(addMenuReq.getMenuSub());
        menu.setMenuUrl(addMenuReq.getMenuUrl());
        menu.setpId(0);
        menu.setCreateTime(new Date());
        menu.setDeleteFlag(0);
        menuService.insertAllColumn(menu);
    }

    /**
     * 修改菜单
     *
     * @param modifyMenuReq
     */
    @Override
    public void modify(ModifyMenuReq modifyMenuReq) {
        Menu menu = menuService.selectById(modifyMenuReq.getId());
        if (CommonUtil.isEmpty(menu)){
            throw new MenuException(ResponseEnums.MODIFY_NULL);
        }
        menu.setMenuName(modifyMenuReq.getMenuName());
        menu.setMenuIcon(modifyMenuReq.getMenuIcon());
        menu.setMenuUrl(modifyMenuReq.getMenuUrl());
        menu.setMenuSub(modifyMenuReq.getMenuSub());
        menuService.updateAllColumnById(menu);
    }

    /**
     * 删除菜单
     *
     * @param delMenuReq
     */
    @Override
    public void del(DelMenuReq delMenuReq) {
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", delMenuReq.getId());
        Menu menu = menuService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(menu)){
            throw new MenuException(ResponseEnums.DEL_NULL);
        }
        menu.setDeleteFlag(1);
        menuService.updateAllColumnById(menu);
        EntityWrapper<Menu> delEntityWrapper = new EntityWrapper<>();
        delEntityWrapper.eq("p_id", delMenuReq.getId());
        menuService.delete(delEntityWrapper);
        menuService.deleteById(delMenuReq.getId());
    }

    /**
     * 分页获取子菜单列表
     *
     * @param listSubMenuReq
     * @return
     */
    @Override
    public ResponseDTO<List<Menu>> listSubByPage(ListSubMenuReq listSubMenuReq) {
        Page<Menu> page = new Page<>(listSubMenuReq.getCurrent(), listSubMenuReq.getSize());
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("p_id", listSubMenuReq.getPid());
        List<Menu> menuList = menuService.selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取子菜单成功", menuList, pageDTO);
    }

    /**
     * 新增子菜单
     *
     * @param addSubMenuReq
     */
    @Override
    public void addSub(AddSubMenuReq addSubMenuReq) {
        Menu menu = new Menu();
        menu.setpId(addSubMenuReq.getPid());
        menu.setMenuName(addSubMenuReq.getMenuName());
        menu.setMenuSub(0);
        menu.setMenuUrl(addSubMenuReq.getMenuUrl());
        menu.setpId(0);
        menu.setCreateTime(new Date());
        menu.setDeleteFlag(0);
        menuService.insertAllColumn(menu);
    }

    /**
     * 修改子菜单
     *
     * @param modifySubMenuReq
     */
    @Override
    public void modifySub(ModifySubMenuReq modifySubMenuReq) {
        Menu menu = menuService.selectById(modifySubMenuReq.getId());
        if (CommonUtil.isEmpty(menu)){
            throw new MenuException(ResponseEnums.MODIFY_NULL);
        }
        menu.setMenuName(modifySubMenuReq.getMenuName());
        menu.setMenuUrl(modifySubMenuReq.getMenuUrl());
        menuService.updateAllColumnById(menu);
    }

    /**
     * 删除子菜单
     *
     * @param delSubMenuReq
     */
    @Override
    public void delSub(DelSubMenuReq delSubMenuReq) {
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", delSubMenuReq.getId());
        Menu menu = menuService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(menu)){
            throw new MenuException(ResponseEnums.DEL_NULL);
        }
        menu.setDeleteFlag(1);
        menuService.updateAllColumnById(menu);
        menuService.deleteById(delSubMenuReq.getId());
    }
}
