package com.gt.inside.sso.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gt.inside.api.dto.MenuDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.ObjectUtil;
import com.gt.inside.sso.core.bean.req.LoginReq;
import com.gt.inside.sso.core.bean.res.LoginRes;
import com.gt.inside.sso.core.entity.User;
import com.gt.inside.sso.core.entity.UserCache;
import com.gt.inside.sso.core.exception.UserException;
import com.gt.inside.sso.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户登录相关接口实现
 * Created by psr on 2017/10/19 0019.
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    UserCacheService userCacheService;

    /**
     * 用户登录，返回tocken
     *
     * @param loginReq
     * @return
     * @exception UserException
     */
    @Override
    public LoginRes login(LoginReq loginReq) throws UserException {
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        userEntityWrapper.eq("login_name", loginReq.getLoginName());
        userEntityWrapper.eq("user_pwd", loginReq.getPassword());
        userEntityWrapper.eq("user_status", 0);
        userEntityWrapper.eq("delete_flag", 0);
        User user = userService.selectOne(userEntityWrapper);
        if (ObjectUtil.isEmpty(user)){
            throw new UserException(ResponseEnums.LOGINNULL);
        }
        int userId = user.getId();
        Integer roleStatus = roleService.selectUserRoleStatus(userId);
        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setRoleStatus(roleStatus);
        List<MenuDTO> menuDTOList = null;
        if (roleStatus == 1){
            menuDTOList = menuService.selectListAllMenuDTO();
        }else {
            menuDTOList = menuService.selectListUserRoleMenuDTO(userId);
        }
        userDTO.setMenuDTOList(menuDTOList);
        UserCache userCache = new UserCache();
        userCache.setLoginTime(new Date());
        userCache.setUserId(userId);
        userCache.setUserInfo(JSONObject.toJSONString(userDTO));
        userCacheService.insertAllColumn(userCache);
        String tocken = userCache.getId() + "";
        LoginRes loginRes = new LoginRes();
        loginRes.setTocken(tocken);
        return loginRes;
    }
}
