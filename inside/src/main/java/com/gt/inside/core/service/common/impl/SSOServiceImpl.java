package com.gt.inside.core.service.common.impl;

import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.service.common.SSOService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by psr on 2017/10/31 0031.
 */
@Service
public class SSOServiceImpl implements SSOService {

    @Value("${inside.sso.url}")
    private String ssoUrl;

    @Value("${inside.sso.sign.key}")
    private String signKey;

    @Override
    public UserDTO getSSOUerDTO(String token) {
        return CommonUtil.getUser(ssoUrl + "api/token/getUser", token, signKey);
    }

}
