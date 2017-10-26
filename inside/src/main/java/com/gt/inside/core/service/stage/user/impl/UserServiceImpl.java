package com.gt.inside.core.service.stage.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.stage.user.req.LoginReq;
import com.gt.inside.core.bean.stage.user.res.MenuRes;
import com.gt.inside.core.dao.stage.user.UserDAO;
import com.gt.inside.core.entity.stage.menu.Menu;
import com.gt.inside.core.entity.stage.user.User;
import com.gt.inside.core.exception.stage.user.UserException;
import com.gt.inside.core.service.stage.menu.MenuService;
import com.gt.inside.core.service.stage.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {

    @Autowired
    MenuService menuService;

    /**
     * 用户登录
     * @param loginReq
     * @throws UserException
     */
    @Override
    public void login(LoginReq loginReq) throws UserException {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("login_name", loginReq.getLoginName());
        entityWrapper.eq("user_pwd", loginReq.getPassword());
        User user = selectOne(entityWrapper);
        if (CommonUtil.isEmpty(user)){
            throw new UserException(ResponseEnums.LOGIN_NULL);
        }
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    @Override
    public List<MenuRes> getAllMenu() throws UserException {
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<>();
        List<Menu> menuList = menuService.selectList(entityWrapper);
        List<MenuRes> menuResList = new ArrayList<>();
        for (Menu menu : menuList){
            MenuRes menuRes = new MenuRes();
            menuRes.setName(menu.getMenuName());
            menuRes.setUrl(menu.getMenuUrl());
            menuRes.setIcon(menu.getMenuIcon());
            menuResList.add(menuRes);
        }
        return menuResList;
    }
}
