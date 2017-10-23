package com.gt.inside.api.exception;

import com.gt.inside.api.enums.ResponseEnums;

/**
 * Created by psr on 2017/10/20 0020.
 */
public class SignException extends SystemException {
    public SignException(String message) {
        super(message);
    }

    public SignException(int code, String message) {
        super(code, message);
    }

    public SignException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
