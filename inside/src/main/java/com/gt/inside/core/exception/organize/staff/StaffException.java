package com.gt.inside.core.exception.organize.staff;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class StaffException extends SystemException {

    public StaffException(String message) {
        super(message);
    }

    public StaffException(int code, String message) {
        super(code, message);
    }

    public StaffException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
