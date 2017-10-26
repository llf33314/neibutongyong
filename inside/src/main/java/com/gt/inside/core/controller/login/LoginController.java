package com.gt.inside.core.controller.login;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.exception.user.UserException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by psr on 2017/10/17 0017.
 */
@Api(value = "/m/login", description = "登录管理（暂未使用）")
@Controller
//@RequestMapping(value = "/m/login")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Value("${inside.sso.url}")
    private String ssoUrl;

    @Value("${inside.sso.sign.key}")
    private String signKey;

    @Value("${inside.login.url}")
    private String loginUrl;

    @Value("${inside.web.url}")
    private String webUrl;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "用户登录", notes = "用户登录")
//    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO login(HttpServletRequest httpServletRequest){
        try {
            logger.debug("login --> " + httpServletRequest.getHeader("token"));
            String token = httpServletRequest.getHeader("token");
            if(token == null){
                return ResponseDTO.createBySuccessCodeMessage(ResponseEnums.LOGIN.getCode(), ResponseEnums.LOGIN.getDesc(), ssoUrl + "/m/route/login?redirectUrl=" + loginUrl);
            }else {
                //不为空
                UserDTO userDTO = CommonUtil.getUser(ssoUrl + "api/token/getUser", token, signKey);
                if (CommonUtil.isEmpty(userDTO)) {
                    return ResponseDTO.createBySuccessCodeMessage(ResponseEnums.LOGIN.getCode(), ResponseEnums.LOGIN.getDesc(), ssoUrl + "m/route/login?redirectUrl=" + loginUrl);
                }
            }
            return ResponseDTO.createBySuccess("用户已登录", token);
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiResponses({
            @ApiResponse(code = 0, message = "重定向页面", response = String.class),
    })
    @ApiOperation(value = "登录重定向", notes = "登录重定向")
//    @RequestMapping(value = "success/{token}", method = RequestMethod.GET)
    public String login(HttpServletRequest request, @PathVariable String token, HttpServletResponse response){
        logger.debug("login token -->" + token);
        try {
            // 缓存
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:" + webUrl + token;
    }

}
