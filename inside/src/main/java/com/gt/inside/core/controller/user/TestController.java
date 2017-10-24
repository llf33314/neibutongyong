package com.gt.inside.core.controller.user;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.user.res.MenuRes;
import com.gt.inside.core.exception.user.UserException;
import com.gt.inside.core.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by psr on 2017/10/17 0017.
 */
@Api(value = "/app/test", description = "用户管理")
@RestController
@RequestMapping(value = "/app/test")
public class TestController extends BaseController {

    private static Logger logger = Logger.getLogger(TestController.class);

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "测试接口", notes = "测试接口")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseDTO test(){
        try {
            return ResponseDTO.createBySuccessMessage("测试接口成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
