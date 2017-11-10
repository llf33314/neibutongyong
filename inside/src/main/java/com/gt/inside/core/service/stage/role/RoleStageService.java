package com.gt.inside.core.service.stage.role;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.stage.menu.dto.MenuMainDTO;
import com.gt.inside.core.bean.stage.menu.req.RelationMenuReq;
import com.gt.inside.core.bean.stage.menu.res.ListMenuRes;
import com.gt.inside.core.bean.stage.role.req.*;
import com.gt.inside.core.entity.stage.role.Role;

import java.util.List;

/**
 * Created by psr on 2017/11/9 0009.
 */
public interface RoleStageService {
    /**
     * 分页获取角色
     * @param listRoleReq
     * @return
     */
    ResponseDTO<List<Role>> listByPage(ListRoleReq listRoleReq);

    /**
     * 新增角色
     * @param addRoleReq
     */
    void add(AddRoleReq addRoleReq);

    /**
     * 修改角色
     * @param modifyRoleReq
     */
    void modify(ModifyRoleReq modifyRoleReq);

    /**
     * 删除角色
     * @param delRoleReq
     */
    void del(DelRoleReq delRoleReq);

    /**
     * 获取所有角色可关联菜单
     * @param listMenuReq
     * @return
     */
    ListMenuRes listMenu(ListMenuReq listMenuReq);

    /**
     * 关联角色菜单
     * @param relationMenuReq
     */
    void relationMenu(RelationMenuReq relationMenuReq);
}
