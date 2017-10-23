package com.gt.inside.api.util;

import com.gt.inside.api.enums.Content;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.exception.SystemException;

/**
 * Created by psr on 2017/10/17 0017.
 */
public class CommonUtil {

    /**
     * 获取tockenID
     * @param tocken
     * @return
     */
    public static Integer getTokenID(String tocken){
        if (!tocken.startsWith(Content.tokenKey)){
            throw new SystemException(ResponseEnums.TOKEN_ERROR);
        }
        String tockenIdStr = tocken.replace(Content.tokenKey, "");
        return Integer.valueOf(tockenIdStr);
    }

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj)) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 判断对象是否不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj)) {
                b = false;
            } else {
                b = true;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

}
