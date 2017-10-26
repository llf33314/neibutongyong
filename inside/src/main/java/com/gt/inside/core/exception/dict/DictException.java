package com.gt.inside.core.exception.dict;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class DictException extends SystemException {

    public DictException(String message) {
        super(message);
    }

    public DictException(int code, String message) {
        super(code, message);
    }

    public DictException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
