package com.gt.inside.core.controller.home;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.util.SocketUtil;
import com.gt.inside.core.exception.stage.user.UserException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by psr on 2017/10/17 0017.
 */
@Api(value = "/app/test", description = "测试接口")
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

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "测试socket接口", notes = "测试socket接口")
    @RequestMapping(value = "/testSocket", method = RequestMethod.POST)
    public ResponseDTO testSocket(){
        try {
            SocketUtil.sendMessage("发送成功");
            return ResponseDTO.createBySuccessMessage("测试socket接口成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
