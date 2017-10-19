package com.gt.inside.sso.core.controller;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.sso.core.bean.req.LoginReq;
import com.gt.inside.sso.core.bean.res.LoginRes;
import com.gt.inside.sso.core.exception.UserException;
import com.gt.inside.sso.core.service.UserLoginService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录相关服务
 * Created by psr on 2017/10/19 0019.
 */
@Api(value = "/m/", description = "登录服务")
@RestController
@RequestMapping(value = "/m/")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    UserLoginService userLoginService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseDTO login(@RequestBody @ApiParam("用户登录对象") LoginReq loginReq, BindingResult bindingResult){
        try {
            LoginRes loginRes = userLoginService.login(loginReq);
            return ResponseDTO.createBySuccess("用户登录成功", loginRes);
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
