package com.gt.inside.api.dto;

import com.gt.inside.api.enums.Content;

/**
 * tocken DTO
 * Created by psr on 2017/10/19 0019.
 */
public class TokenDTO {

    private String token;

    public String getToken() {
        return token.replace(Content.tokenKey, "");
    }

    public void setToken(String token) {
        this.token = token;
    }

}
