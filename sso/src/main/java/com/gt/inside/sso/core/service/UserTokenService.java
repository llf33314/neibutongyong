package com.gt.inside.sso.core.service;

import com.gt.inside.api.dto.UserDTO;

/**
 * 用户登录相关接口
 * Created by psr on 2017/10/19 0019.
 */
public interface UserTokenService {

    /**
     * 触发token，改变登录时间为当前时间
     * @param token
     */
    void triggerToken(String token);

    /**
     * 根据token，获取用户信息
     * @param token
     */
    UserDTO getUserByToken(String token);
}
