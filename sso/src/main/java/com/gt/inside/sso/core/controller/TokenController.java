package com.gt.inside.sso.core.controller;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.exception.SystemException;
import com.gt.inside.sso.core.exception.UserException;
import com.gt.inside.sso.core.service.UserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Token服务
 * Created by psr on 2017/10/20 0020.
 */
@Api(value = "/api/token", description = "Token服务")
@RestController
@RequestMapping(value = "/api/token/")
public class TokenController {

    private static Logger logger = Logger.getLogger(TokenController.class);

    @Autowired
    UserTokenService userTokenService;

    /**
     * 根据token获取user
     * @return
     */
    @ApiOperation(value = "根据token获取user")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResponseDTO getUser(@RequestHeader(value = "token") String token){
        try {
            logger.debug(token);
            UserDTO userDTO = userTokenService.getUserByToken(token);
            return ResponseDTO.createBySuccess("获取用户信息成功", userDTO);
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (SystemException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    /**
     * 触发token，增加token有效时间
     * @return
     */
    @ApiOperation(value = "触发token，增加token有效时间")
    @RequestMapping(value = "/trigger", method = RequestMethod.POST)
    public ResponseDTO trigger(@RequestHeader(value = "token") String token){
        try {
            logger.debug(token);
            userTokenService.triggerToken(token);
            return ResponseDTO.createBySuccessMessage("触发token成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (SystemException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
