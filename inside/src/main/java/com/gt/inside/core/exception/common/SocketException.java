package com.gt.inside.core.exception.common;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * @author psr
 * Created by psr on 2017/10/10 0010.
 */
public class SocketException extends SystemException {

    public SocketException(String message) {
        super(message);
    }

    public SocketException(int code, String message) {
        super(code, message);
    }

    public SocketException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
