package com.gt.inside.core.controller.organize.department;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.organize.department.req.DepartmentAddReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentDelReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentListReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentModifyReq;
import com.gt.inside.core.entity.organize.department.Department;
import com.gt.inside.core.exception.dict.DictException;
import com.gt.inside.core.service.organize.department.DepartmentService;
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
 * @author psr
 * Created by psr on 2017/10/26 0026.
 */
@Api(value = "/app/department", description = "部门管理")
@RestController
@RequestMapping(value = "/app/department")
public class DepartmentStageController extends BaseController {

    private static Logger logger = Logger.getLogger(DepartmentStageController.class);

    @Autowired
    DepartmentService departmentService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = Department.class),
    })
    @ApiOperation(value = "分页获取部门列表", notes = "分页获取部门列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") DepartmentListReq departmentListReq) {
        try {
            logger.debug(departmentListReq.toString());
            ResponseDTO<List<Department>> responseDTO =  departmentService.listDepartmentByPage(departmentListReq);
            return responseDTO;
        } catch (DictException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = Department.class),
    })
    @ApiOperation(value = "获取部门列表", notes = "获取部门列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public ResponseDTO listAll() {
        try {
            logger.debug("listAll");
            List<Department> departmentList =  departmentService.listAllDepartment();
            return ResponseDTO.createBySuccess("获取部门成功", departmentList);
        } catch (DictException e){
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
    @ApiOperation(value = "新增部门列表", notes = "新增部门列表")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody @ApiParam("新增对象") DepartmentAddReq departmentAddReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(departmentAddReq.toString());
            departmentService.addDepartment(departmentAddReq);
            return ResponseDTO.createBySuccessMessage("新增部门成功");
        } catch (DictException e){
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
    @ApiOperation(value = "修改部门列表", notes = "修改部门列表")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseDTO modify(@RequestBody @ApiParam("修改对象") DepartmentModifyReq departmentModifyReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(departmentModifyReq.toString());
            departmentService.modifyDepartment(departmentModifyReq);
            return ResponseDTO.createBySuccessMessage("修改部门成功");
        } catch (DictException e){
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
    @ApiOperation(value = "删除部门", notes = "删除部门")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseDTO del(@RequestBody @ApiParam("删除对象") DepartmentDelReq departmentDelReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(departmentDelReq.toString());
            departmentService.delDepartment(departmentDelReq);
            return ResponseDTO.createBySuccessMessage("删除部门成功");
        } catch (DictException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }


}
