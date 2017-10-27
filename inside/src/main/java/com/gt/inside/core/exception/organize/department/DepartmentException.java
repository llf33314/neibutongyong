package com.gt.inside.core.exception.organize.department;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class DepartmentException extends SystemException {

    public DepartmentException(String message) {
        super(message);
    }

    public DepartmentException(int code, String message) {
        super(code, message);
    }

    public DepartmentException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
