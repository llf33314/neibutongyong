package com.gt.inside.core.service.user;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.core.bean.user.req.LoginReq;
import com.gt.inside.core.bean.user.res.MenuRes;
import com.gt.inside.core.entity.user.User;
import com.gt.inside.core.exception.user.UserException;

import java.util.List;

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

    /**
     * 获取所有菜单
     * @return
     */
    List<MenuRes> getAllMenu() throws UserException;
}
