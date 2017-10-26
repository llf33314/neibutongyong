package com.gt.inside.core.exception.user;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
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
