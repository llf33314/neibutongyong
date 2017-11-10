package com.gt.inside.core.exception.stage.role;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class RoleException extends SystemException {

    public RoleException(String message) {
        super(message);
    }

    public RoleException(int code, String message) {
        super(code, message);
    }

    public RoleException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
