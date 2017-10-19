package com.gt.inside.sso.core.service.impl;

import com.gt.inside.sso.core.entity.User;
import com.gt.inside.sso.core.dao.UserDAO;
import com.gt.inside.sso.core.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {
	
}
