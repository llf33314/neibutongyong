package com.gt.inside.core.controller.devproject;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.devproject.DevProjectVO;
import com.gt.inside.core.exception.devproject.DevProjectException;
import com.gt.inside.core.service.devproject.DevProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by psr on 2017/10/10 0010.
 */
@Api(value = "/app/dev/project", description = "开发项目")
@RestController
@RequestMapping(value = "/app/dev/project")
public class DevProjectController {

    private static Logger logger = Logger.getLogger(DevProjectController.class);

    @Autowired
    DevProjectService devProjectService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = DevProjectVO.class),
    })
    @ApiOperation(value = "获取项目列表", notes = "获取项目列表")
    @RequestMapping(value = "/listProject", method = RequestMethod.POST)
    public ResponseDTO listProject(HttpServletRequest request) {
        try {
            List<DevProjectVO> devProjectVOList = devProjectService.listRunProject();
            return ResponseDTO.createBySuccess("获取项目列表成功", devProjectVOList);
        } catch (DevProjectException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
