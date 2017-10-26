package com.gt.inside.sso.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.sso.core.entity.UserCache;

/**
 * <p>
 * 用户缓存表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
public interface UserCacheService extends IService<UserCache> {

    /**
     * 清除超时token缓存
     * @param overTime
     */
    int deleteOverToken(int overTime);
}
