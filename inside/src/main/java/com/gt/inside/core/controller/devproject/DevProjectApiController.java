package com.gt.inside.core.controller.devproject;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.devproject.DevProjectVO;
import com.gt.inside.core.bean.devproject.req.DevProjectAddReq;
import com.gt.inside.core.bean.devproject.req.DevProjectListReq;
import com.gt.inside.core.bean.devproject.req.DevProjectModifyReq;
import com.gt.inside.core.bean.devproject.res.DevProjectListRes;
import com.gt.inside.core.exception.devproject.DevProjectException;
import com.gt.inside.core.service.devproject.DevProjectService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by psr on 2017/10/10 0010.
 */
@Api(value = "/api/dev/project", description = "开发项目后台管理")
@RestController
@RequestMapping(value = "/api/dev/project")
public class DevProjectApiController extends BaseController {

    private static Logger logger = Logger.getLogger(DevProjectApiController.class);

    @Autowired
    DevProjectService devProjectService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = DevProjectVO.class),
    })
    @ApiOperation(value = "分页获取项目列表", notes = "分页获取项目列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") DevProjectListReq devProjectListReq) {
        try {
            ResponseDTO<List<DevProjectListRes>> responseDTO =  devProjectService.listDevProjectByPage(devProjectListReq);
            return responseDTO;
        } catch (DevProjectException e){
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
    @ApiOperation(value = "新增开发项目", notes = "新增开发项目")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody @ApiParam("新增对象")DevProjectAddReq devProjectAddReq, BindingResult bindingResult){
        InvalidParameter(bindingResult);
        try {
            devProjectService.addDevProject(devProjectAddReq);
            return ResponseDTO.createBySuccessMessage("新增开发项目成功");
        } catch (DevProjectException e){
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
    @ApiOperation(value = "编辑开发项目", notes = "编辑开发项目")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseDTO modify(@RequestBody @ApiParam("新增对象")DevProjectModifyReq devProjectModifyReq, BindingResult bindingResult){
        InvalidParameter(bindingResult);
        try {
            devProjectService.modifyDevProject(devProjectModifyReq);
            return ResponseDTO.createBySuccessMessage("编辑开发项目成功");
        } catch (DevProjectException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
