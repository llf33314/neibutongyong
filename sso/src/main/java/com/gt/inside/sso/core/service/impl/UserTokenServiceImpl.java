package com.gt.inside.sso.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.sso.core.entity.UserCache;
import com.gt.inside.sso.core.exception.UserException;
import com.gt.inside.sso.core.service.UserCacheService;
import com.gt.inside.sso.core.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户登录相关接口实现
 * Created by psr on 2017/10/19 0019.
 */
@Service
public class UserTokenServiceImpl implements UserTokenService{

    @Autowired
    UserCacheService userCacheService;

    /**
     * 根据token，获取用户信息
     *
     * @param token
     */
    @Override
    public UserDTO getUserByToken(String token) {
        int tokenID = CommonUtil.getTokenID(token);
        UserCache userCache = userCacheService.selectById(tokenID);
        if (CommonUtil.isEmpty(userCache)){
            throw new UserException(ResponseEnums.LOGIN_NEED);
        }
        UserDTO userDTO = JSON.parseObject(userCache.getUserInfo(), UserDTO.class);
        userDTO.setUserId(userCache.getUserId());
        return userDTO;
    }

    /**
     * 触发token，改变登录时间为当前时间
     *
     * @param token
     */
    @Override
    public void triggerToken(String token) {
        int tokenID = CommonUtil.getTokenID(token);
        UserCache userCache = new UserCache();
        userCache.setId(tokenID);
        userCache.setLoginTime(new Date());
        userCacheService.updateById(userCache);
    }

}
