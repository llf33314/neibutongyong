package com.gt.inside.core.service.user;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.core.bean.user.req.LoginReq;
import com.gt.inside.core.entity.user.User;
import com.gt.inside.core.exception.user.UserException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-17
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param loginReq
     * @throws UserException
     */
    void login(LoginReq loginReq) throws UserException;
}
