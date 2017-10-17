package com.gt.inside.core.controller.user;

import com.gt.inside.common.base.BaseController;
import com.gt.inside.common.dto.ResponseDTO;
import com.gt.inside.core.bean.user.req.LoginReq;
import com.gt.inside.core.exception.user.UserException;
import com.gt.inside.core.service.user.UserService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by psr on 2017/10/17 0017.
 */
@Api(value = "/app/login", description = "登录管理")
@RestController
@RequestMapping(value = "/app/login")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseDTO login(@RequestBody @ApiParam("用户登录对象") LoginReq loginReq, BindingResult bindingResult){
        InvalidParameter(bindingResult);
        try {
            logger.debug(loginReq.toString());
            userService.login(loginReq);
            return ResponseDTO.createBySuccessMessage("用户登录成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
