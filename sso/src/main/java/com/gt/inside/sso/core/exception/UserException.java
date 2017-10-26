package com.gt.inside.sso.core.exception;

import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/19 0019.
 */
public class UserException extends SystemException {
    public UserException(String message) {
        super(message);
    }

    public UserException(int code, String message) {
        super(code, message);
    }

    public UserException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
