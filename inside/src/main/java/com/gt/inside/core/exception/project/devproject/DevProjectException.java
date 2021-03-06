package com.gt.inside.core.exception.project.devproject;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class DevProjectException extends SystemException {

    public DevProjectException(String message) {
        super(message);
    }

    public DevProjectException(int code, String message) {
        super(code, message);
    }

    public DevProjectException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
