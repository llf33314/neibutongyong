package com.gt.inside.core.service.stage.menu;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.stage.menu.req.AddMenuReq;
import com.gt.inside.core.bean.stage.menu.req.DelMenuReq;
import com.gt.inside.core.bean.stage.menu.req.ListMenuReq;
import com.gt.inside.core.bean.stage.menu.req.ModifyMenuReq;
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
}
