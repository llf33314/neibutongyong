package com.gt.inside.core.dao.stage.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.core.bean.stage.user.res.ListUserRes;
import com.gt.inside.core.entity.stage.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-17
 */
public interface UserDAO extends BaseMapper<User> {
    /**
     * 分页获取用户信息
     * @param page
     * @param userSearch
     * @param userStatus
     * @return
     */
    List<ListUserRes> listByPageBySearchAndStatus(@Param("page") Page<ListUserRes> page, @Param("userSearch") String userSearch, @Param("userStatus") Integer userStatus);
}