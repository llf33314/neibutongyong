package com.gt.inside.core.controller.user;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.MenuDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.exception.user.UserException;
import com.gt.inside.core.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by psr on 2017/10/17 0017.
 */
@Api(value = "/app/user", description = "用户管理")
@RestController
@RequestMapping(value = "/app/user")
public class UserController extends BaseController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Value("${inside.sso.url}")
    private String ssoUrl;

    @Value("${inside.sso.sign.key}")
    private String signKey;

    @Autowired
    UserService userService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "菜单对象", response = MenuDTO.class),
    })
    @ApiOperation(value = "获取用户菜单", notes = "获取用户菜单")
    @RequestMapping(value = "/getUserMenus", method = RequestMethod.POST)
    public ResponseDTO getUserMenus(@RequestHeader String token){
        try {
            UserDTO userDTO = CommonUtil.getUser(ssoUrl + "api/token/getUser", token, signKey);
            List<MenuDTO> menuDTOList = userDTO.getMenuDTOList();
            return ResponseDTO.createBySuccess("获取用户菜单成功", menuDTOList);
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
