package com.gt.inside.core.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.common.enums.ResponseEnums;
import com.gt.inside.core.bean.user.req.LoginReq;
import com.gt.inside.core.dao.user.UserDAO;
import com.gt.inside.core.entity.user.User;
import com.gt.inside.core.exception.user.UserException;
import com.gt.inside.core.service.user.UserService;
import com.gt.inside.core.util.ObjectUtil;
import org.springframework.stereotype.Service;

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
        if (ObjectUtil.isEmpty(user)){
            throw new UserException(ResponseEnums.LOGINNULL);
        }
    }
}
