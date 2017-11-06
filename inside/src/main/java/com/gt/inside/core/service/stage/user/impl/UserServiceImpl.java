package com.gt.inside.core.service.stage.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.core.dao.stage.user.UserDAO;
import com.gt.inside.core.entity.stage.user.User;
import com.gt.inside.core.service.stage.user.UserService;
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

}
