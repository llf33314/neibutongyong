package com.gt.inside.api.util;

import com.gt.inside.api.dto.SignDTO;
import com.gt.inside.api.enums.ResponseEnums;

/**
 * 签名工具类
 * @author psr
 * @date 2017/8/1
 * @version v1.0
 */
public class SignUtils {

    /**
     * 签名
     * @param signKey 签名密钥
     * @return SignBean 签名类JavaBean
     */
    public static SignDTO sign(String signKey){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String randNum = String.valueOf((int)((Math.random()*9+1)*10000));
        String sign = MD5Util.getMD5SM(signKey + timeStamp + randNum);
        SignDTO signDTO = new SignDTO(sign, timeStamp, randNum);
        return signDTO;
    }

    /**
     * 签名验证
     * @param signKey 签名密钥
     * @param signBean 签名Bean
     * @return 结果code（对应SignEnum里面的code）
     */
    public static Integer decSign(String signKey, SignDTO signBean){
        String reqTime = signBean.getTimeStamp();
        // 判断时间是否在10分钟内
        boolean timeOut = contrastTimeNow(Long.parseLong(reqTime)) > 10;
        if(timeOut){
            return ResponseEnums.SIGN_TIME_OUT.getCode();
        }
        // 根据key+时间撮+随机数-->MD5加密
        String reqSign = signBean.getSign();
        String sign = MD5Util.getMD5SM(signKey + reqTime + signBean.getRandNum());
        boolean signFail = !sign.equals(reqSign);
        if(signFail){
            return ResponseEnums.SIGN_ERROR.getCode();
        }
        return ResponseEnums.SIGN_SUCCESS.getCode();
    }

    /**
     * 对比两个时间戳相差的分钟数
     * @param bigTime 较大的时间
     * @param smallTime 较小的时间
     * @return
     */
    private static long contrastTime(Long bigTime, Long smallTime){
        return (bigTime - smallTime) / (1000 * 60);
    }

    /**
     * 对比时间戳和当前时间戳相差的分钟数
     * @param paramTime 需要对比的时间
     * @return
     */
    private static long contrastTimeNow(Long paramTime){
        return contrastTime(System.currentTimeMillis(), paramTime);
    }

}
