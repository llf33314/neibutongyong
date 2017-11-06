package com.gt.inside.core.service.common;

import com.gt.inside.api.dto.UserDTO;

/**
 * Created by psr on 2017/10/31 0031.
 */
public interface SSOService {

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    UserDTO getSSOUerDTO(String token);

}
