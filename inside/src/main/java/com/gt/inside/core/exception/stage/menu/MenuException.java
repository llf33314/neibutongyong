package com.gt.inside.core.exception.stage.menu;


import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class MenuException extends SystemException {

    public MenuException(String message) {
        super(message);
    }

    public MenuException(int code, String message) {
        super(code, message);
    }

    public MenuException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
