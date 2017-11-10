package com.gt.inside.core.controller.organize.staff;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.organize.staff.req.*;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.exception.dict.DictException;
import com.gt.inside.core.exception.organize.staff.StaffException;
import com.gt.inside.core.service.organize.staff.StaffStageService;
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
@Api(value = "/app/staff", description = "员工管理")
@RestController
@RequestMapping(value = "/app/staff")
public class StaffStageController extends BaseController {

    private static Logger logger = Logger.getLogger(StaffStageController.class);

    @Autowired
    StaffStageService staffStageService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = Staff.class),
    })
    @ApiOperation(value = "分页获取员工列表", notes = "分页获取员工列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") StaffListReq staffListReq) {
        try {
            logger.debug(staffListReq.toString());
            ResponseDTO<List<Staff>> responseDTO =  staffStageService.listStaffByPage(staffListReq);
            return responseDTO;
        } catch (StaffException e){
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
    @ApiOperation(value = "新增员工列表", notes = "新增员工列表")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody @ApiParam("新增对象") StaffAddReq staffAddReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(staffAddReq.toString());
            staffStageService.addStaff(staffAddReq);
            return ResponseDTO.createBySuccessMessage("新增员工成功");
        } catch (StaffException e){
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
    @ApiOperation(value = "修改员工列表", notes = "修改员工列表")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseDTO modify(@RequestBody @ApiParam("修改对象") StaffModifyReq staffModifyReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(staffModifyReq.toString());
            staffStageService.modifyStaff(staffModifyReq);
            return ResponseDTO.createBySuccessMessage("修改员工成功");
        } catch (StaffException e){
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
    @ApiOperation(value = "删除员工", notes = "删除员工")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseDTO del(@RequestBody @ApiParam("删除对象") StaffDelReq staffDelReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(staffDelReq.toString());
            staffStageService.delStaff(staffDelReq);
            return ResponseDTO.createBySuccessMessage("删除员工成功");
        } catch (StaffException e){
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
    @ApiOperation(value = "离职员工", notes = "离职员工")
    @RequestMapping(value = "/quit", method = RequestMethod.POST)
    public ResponseDTO quit(@RequestBody @ApiParam("离职对象") StaffQuitReq staffQuitReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(staffQuitReq.toString());
            staffStageService.quitStaff(staffQuitReq);
            return ResponseDTO.createBySuccessMessage("离职员工成功");
        } catch (StaffException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
