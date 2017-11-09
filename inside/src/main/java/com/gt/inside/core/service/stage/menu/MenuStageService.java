package com.gt.inside.core.service.stage.menu;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.stage.menu.req.*;
import com.gt.inside.core.entity.stage.menu.Menu;

import java.util.List;

/**
 * Created by psr on 2017/11/8 0008.
 */
public interface MenuStageService {
    /**
     * 分页获取菜单
     * @param listMenuReq
     * @return
     */
    ResponseDTO<List<Menu>> listByPage(ListMenuReq listMenuReq);

    /**
     * 新增菜单
     * @param addMenuReq
     */
    void add(AddMenuReq addMenuReq);

    /**
     * 修改菜单
     * @param modifyMenuReq
     */
    void modify(ModifyMenuReq modifyMenuReq);

    /**
     * 删除菜单
     * @param delMenuReq
     */
    void del(DelMenuReq delMenuReq);

    /**
     * 分页获取子菜单列表
     * @param listSubMenuReq
     * @return
     */
    ResponseDTO<List<Menu>> listSubByPage(ListSubMenuReq listSubMenuReq);

    /**
     * 新增子菜单
     * @param addSubMenuReq
     */
    void addSub(AddSubMenuReq addSubMenuReq);

    /**
     * 修改子菜单
     * @param modifySubMenuReq
     */
    void modifySub(ModifySubMenuReq modifySubMenuReq);

    /**
     * 删除子菜单
     * @param delSubMenuReq
     */
    void delSub(DelSubMenuReq delSubMenuReq);
}
