package com.gt.inside.core.exception.function.performance;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class PerformanceException extends SystemException {

    public PerformanceException(String message) {
        super(message);
    }

    public PerformanceException(int code, String message) {
        super(code, message);
    }

    public PerformanceException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
