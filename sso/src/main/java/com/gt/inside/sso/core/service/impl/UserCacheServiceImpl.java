package com.gt.inside.sso.core.service.impl;

import com.gt.inside.sso.core.entity.UserCache;
import com.gt.inside.sso.core.dao.UserCacheDAO;
import com.gt.inside.sso.core.service.UserCacheService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户缓存表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Service
public class UserCacheServiceImpl extends ServiceImpl<UserCacheDAO, UserCache> implements UserCacheService {

    @Autowired
    UserCacheDAO userCacheDAO;

    /**
     * 清除超时token缓存
     *
     * @param overTime
     */
    @Override
    public int deleteOverToken(int overTime) {
        return userCacheDAO.deleteOverToken(overTime);
    }
}
