package com.gt.inside.sso.core.dao;

import com.gt.inside.sso.core.entity.UserCache;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
  * 用户缓存表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
public interface UserCacheDAO extends BaseMapper<UserCache> {

    /**
     * 清除超时token缓存
     *
     * @param overTime
     */
    @Delete("DELETE FROM t_user_cache WHERE TIMESTAMPDIFF(HOUR, login_time, NOW()) >= #{overTime}")
    int deleteOverToken(int overTime);
}