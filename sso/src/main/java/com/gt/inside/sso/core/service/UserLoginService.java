package com.gt.inside.sso.core.service;

import com.gt.inside.sso.core.bean.req.LoginReq;
import com.gt.inside.sso.core.bean.res.LoginRes;
import com.gt.inside.sso.core.exception.UserException;

/**
 * 用户登录相关接口
 * Created by psr on 2017/10/19 0019.
 */
public interface UserLoginService {

    /**
     * 用户登录，返回tocken
     * @param loginReq
     * @return
     * @throws UserException
     */
    LoginRes login(LoginReq loginReq) throws UserException;

}
