package com.gt.inside.core.service.stage.role.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.stage.menu.dto.MenuMainDTO;
import com.gt.inside.core.bean.stage.menu.req.RelationMenuReq;
import com.gt.inside.core.bean.stage.menu.res.ListMenuRes;
import com.gt.inside.core.bean.stage.role.req.*;
import com.gt.inside.core.entity.stage.role.Role;
import com.gt.inside.core.entity.stage.role.RoleMenu;
import com.gt.inside.core.entity.stage.user.UserRole;
import com.gt.inside.core.exception.stage.menu.MenuException;
import com.gt.inside.core.service.stage.menu.MenuService;
import com.gt.inside.core.service.stage.role.RoleMenuService;
import com.gt.inside.core.service.stage.role.RoleService;
import com.gt.inside.core.service.stage.role.RoleStageService;
import com.gt.inside.core.service.stage.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by psr on 2017/11/9 0009.
 */
@Service
public class RoleStageServiceImpl implements RoleStageService {

    @Autowired
    RoleService roleService;

    @Autowired
    RoleMenuService roleMenuService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    MenuService menuService;

    /**
     * 分页获取角色
     *
     * @param listRoleReq
     * @return
     */
    @Override
    public ResponseDTO<List<Role>> listByPage(ListRoleReq listRoleReq) {
        Page<Role> page = new Page<>(listRoleReq.getCurrent(), listRoleReq.getSize());
        EntityWrapper<Role> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("role_power", 0);
        if (CommonUtil.isNotEmpty(listRoleReq.getRoleSearch())){
            entityWrapper.like("role_name", listRoleReq.getRoleSearch());
        }
        List<Role> roleList = roleService.selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取角色成功", roleList, pageDTO);
    }
    /**
     * 新增角色
     *
     * @param addRoleReq
     */
    @Override
    public void add(AddRoleReq addRoleReq) {
        Role role = new Role();
        role.setRoleName(addRoleReq.getRoleName());
        role.setRolePower(0);
        role.setRoleRemark(addRoleReq.getRoleRemark());
        role.setCreateTime(new Date());
        role.setDeleteFlag(0);
        roleService.insertAllColumn(role);
    }

    /**
     * 修改角色
     *
     * @param modifyRoleReq
     */
    @Override
    public void modify(ModifyRoleReq modifyRoleReq) {
        Role role = roleService.selectById(modifyRoleReq.getId());
        if (CommonUtil.isEmpty(role)){
            throw new MenuException(ResponseEnums.MODIFY_NULL);
        }
        role.setRoleName(modifyRoleReq.getRoleName());
        role.setRoleRemark(modifyRoleReq.getRoleRemark());
        roleService.updateAllColumnById(role);
    }

    /**
     * 删除角色
     *
     * @param delRoleReq
     */
    @Override
    public void del(DelRoleReq delRoleReq) {
        EntityWrapper<Role> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", delRoleReq.getId());
        Role role = roleService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(role)){
            throw new MenuException(ResponseEnums.DEL_NULL);
        }
        role.setDeleteFlag(1);
        roleService.updateAllColumnById(role);
        // 删除对应所有角色菜单
        EntityWrapper<RoleMenu> delRoleMenuEntityWrapper = new EntityWrapper<>();
        delRoleMenuEntityWrapper.eq("role_id", delRoleReq.getId());
        roleMenuService.delete(delRoleMenuEntityWrapper);
        // 删除对应的用户角色
        EntityWrapper<UserRole> delUserRoleentityWrapper = new EntityWrapper<>();
        entityWrapper.eq("role_id", delRoleReq.getId());
        userRoleService.delete(delUserRoleentityWrapper);
        roleService.deleteById(delRoleReq.getId());
    }

    /**
     * 获取所有角色可关联菜单
     *
     * @param listMenuReq
     * @return
     */
    @Override
    public ListMenuRes listMenu(ListMenuReq listMenuReq) {
        ListMenuRes listMenuRes = new ListMenuRes();
        List<MenuMainDTO> menuMainDTOList = menuService.selectListAllMenuWithSub();
        listMenuRes.setMenuMainDTOList(menuMainDTOList);
        EntityWrapper<RoleMenu> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("role_id", listMenuReq.getRoleId());
        List<RoleMenu> roleMenuList = roleMenuService.selectList(entityWrapper);
        List<Integer> idList = new ArrayList<>();
        for (RoleMenu roleMenu : roleMenuList){
            idList.add(roleMenu.getMenuId());
        }
        listMenuRes.setIdList(idList);
        return listMenuRes;
    }

    /**
     * 关联角色菜单
     *
     * @param relationMenuReq
     */
    @Override
    public void relationMenu(RelationMenuReq relationMenuReq) {
        // 删除对应所有角色菜单
        EntityWrapper<RoleMenu> delRoleMenuEntityWrapper = new EntityWrapper<>();
        delRoleMenuEntityWrapper.eq("role_id", relationMenuReq.getRoleId());
        roleMenuService.delete(delRoleMenuEntityWrapper);
        List<RoleMenu> roleMenuList = new ArrayList<>();
        for (Integer menuId : relationMenuReq.getMenuIdList()){
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(menuId);
            roleMenu.setRoleId(relationMenuReq.getRoleId());
            roleMenuList.add(roleMenu);
        }
        roleMenuService.insertBatch(roleMenuList);
    }
}
