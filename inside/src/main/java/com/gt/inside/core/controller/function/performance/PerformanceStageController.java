package com.gt.inside.core.controller.function.performance;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.core.bean.function.performance.req.*;
import com.gt.inside.core.bean.function.performance.res.*;
import com.gt.inside.core.exception.function.performance.PerformanceException;
import com.gt.inside.core.service.common.SSOService;
import com.gt.inside.core.service.function.performance.PerformanceStageService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
@Api(value = "/app/performance", description = "员工绩效管理")
@RestController
@RequestMapping(value = "/app/performance")
public class PerformanceStageController extends BaseController {

    private static Logger logger = Logger.getLogger(PerformanceStageController.class);

    @Autowired
    SSOService ssoService;

    @Autowired
    PerformanceStageService performanceStageService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "数组对象", response = ListTotalRes.class),
    })
    @ApiOperation(value = "获取员工绩效管理权限", notes = "获取员工绩效管理权限")
    @RequestMapping(value = "/getPower", method = RequestMethod.POST)
    public ResponseDTO getPower(@RequestHeader String token) {
        try {
            logger.debug("getPower");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            PowerRes powerRes =  performanceStageService.getPower(userDTO);
            return ResponseDTO.createBySuccess("获取员工绩效管理权限成功", powerRes);
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListTotalRes.class),
    })
    @ApiOperation(value = "获取绩效总览列表", notes = "获取绩效总览列表")
    @RequestMapping(value = "/listTotal", method = RequestMethod.POST)
    public ResponseDTO listTotal(@RequestHeader String token) {
        try {
            logger.debug("listTotal");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            List<ListTotalRes> listPerformanceTotalResList =  performanceStageService.listTotal(userDTO);
            return ResponseDTO.createBySuccess("获取绩效总览列表成功", listPerformanceTotalResList);
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListOrganizeRes.class),
    })
    @ApiOperation(value = "获取组织关系列表", notes = "获取组织关系列表")
    @RequestMapping(value = "/listOrganize", method = RequestMethod.POST)
    public ResponseDTO listOrganize(@RequestBody @ApiParam(value = "查询对象") ListOrganizeReq listOrganizeReq, @RequestHeader String token) {
        try {
            logger.debug(listOrganizeReq.toString());
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            ResponseDTO<List<ListOrganizeRes>> responseDTO =  performanceStageService.listOrganizeByPage(userDTO, listOrganizeReq);
            return responseDTO;
        } catch (PerformanceException e){
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
    @ApiOperation(value = "新增或修改直属领导", notes = "新增或修改直属领导")
    @RequestMapping(value = "/addOrModifyDirectly", method = RequestMethod.POST)
    public ResponseDTO addOrModifyDirectly(@RequestBody @ApiParam("请求对象") @Valid AddOrModifyOrganizeReq addOrModifyOrganizeReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addOrModifyOrganizeReq.toString());
            performanceStageService.addOrModifyDirectly(addOrModifyOrganizeReq);
            return ResponseDTO.createBySuccessMessage("新增或修改直属领导成功");
        } catch (PerformanceException e){
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
    @ApiOperation(value = "新增或修改分管领导", notes = "新增或修改分管领导")
    @RequestMapping(value = "/addOrModifyBranch", method = RequestMethod.POST)
    public ResponseDTO addOrModifyBranch(@RequestBody @ApiParam("请求对象") @Valid AddOrModifyOrganizeReq addOrModifyOrganizeReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addOrModifyOrganizeReq.toString());
            performanceStageService.addOrModifyBranch(addOrModifyOrganizeReq);
            return ResponseDTO.createBySuccessMessage("新增或修改分管领导成功");
        } catch (PerformanceException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（返回对象）", response = CheckOwnInfoRes.class),
    })
    @ApiOperation(value = "查询是否已经自评分", notes = "查询是否已经自评分")
    @RequestMapping(value = "/checkOwnInfo", method = RequestMethod.POST)
    public ResponseDTO checkOwnInfo(@RequestHeader String token) {
        try {
            logger.debug("checkOwnInfo");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            CheckOwnInfoRes checkOwnInfoRes = performanceStageService.checkOwnInfo(userDTO);
            return ResponseDTO.createBySuccess("查询是否已经自评分成功", checkOwnInfoRes);
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListOwnInfoRes.class),
    })
    @ApiOperation(value = "查询自评分列表", notes = "查询自评分列表")
    @RequestMapping(value = "/listOwnInfo", method = RequestMethod.POST)
    public ResponseDTO listOwnInfo(@RequestHeader String token) {
        try {
            logger.debug("listOwnInfo");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            List<ListOwnInfoRes> listOwnInfoResList =  performanceStageService.listOwnInfo(userDTO);
            return ResponseDTO.createBySuccess("查询自评分列表成功", listOwnInfoResList);
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListStaticInfoRes.class),
    })
    @ApiOperation(value = "获取绩效静态信息", notes = "获取绩效静态信息")
    @RequestMapping(value = "/listStaticInfo", method = RequestMethod.POST)
    public ResponseDTO listStaticInfo() {
        try {
            logger.debug("listStaticInfo");
            List<ListStaticInfoRes> listStaticInfoResList =  performanceStageService.listStaticInfo();
            return ResponseDTO.createBySuccess("获取绩效静态信息成功", listStaticInfoResList);
        } catch (PerformanceException e){
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
    @ApiOperation(value = "新增自评分", notes = "新增自评分")
    @RequestMapping(value = "/addOwn", method = RequestMethod.POST)
    public ResponseDTO addOwn(@RequestBody @ApiParam("新增对象") @Valid List<AddOwnReq> addOwnReqs, BindingResult bindingResult, @RequestHeader String token) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addOwnReqs.size());
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            performanceStageService.addOwn(userDTO, addOwnReqs);
            return ResponseDTO.createBySuccessMessage("新增自评分成功");
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListDirectlyStaffRes.class),
    })
    @ApiOperation(value = "获取直属员工列表", notes = "获取直属员工列表")
    @RequestMapping(value = "/listDirectlyStaff", method = RequestMethod.POST)
    public ResponseDTO listDirectlyStaff(@RequestBody @ApiParam("请求对象") @Valid ListDirectlyStaffReq listDirectlyStaffReq, BindingResult bindingResult, @RequestHeader String token) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(listDirectlyStaffReq.toString());
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            ResponseDTO<List<ListDirectlyStaffRes>> responseDTO =  performanceStageService.listDirectlyStaffByPage(userDTO, listDirectlyStaffReq);
            return responseDTO;
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListDirectlyInfoRes.class),
    })
    @ApiOperation(value = "查询评分详情列表", notes = "查询评分详情列表")
    @RequestMapping(value = "/listDirectlyInfo", method = RequestMethod.POST)
    public ResponseDTO listDirectlyInfo(@RequestBody @ApiParam("请求对象") @Valid ListDirectlyInfoReq listDirectlyInfoReq, BindingResult bindingResult, @RequestHeader String token) {
        InvalidParameter(bindingResult);
        try {
            logger.debug("listDirectlyInfo");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            List<ListDirectlyInfoRes> listDirectlyInfoResList =  performanceStageService.listDirectlyInfoByStaffId(userDTO, listDirectlyInfoReq);
            return ResponseDTO.createBySuccess("查询评分详情列表成功", listDirectlyInfoResList);
        } catch (PerformanceException e){
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
    @ApiOperation(value = "直属领导评分", notes = "直属领导评分")
    @RequestMapping(value = "/addDirectly", method = RequestMethod.POST)
    public ResponseDTO addDirectly(@RequestBody @ApiParam("请求对象") @Valid AddDirectlyInfoReq addDirectlyInfoReq, BindingResult bindingResult, @RequestHeader String token) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addDirectlyInfoReq.toString());
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            performanceStageService.addDirectly(userDTO, addDirectlyInfoReq);
            return ResponseDTO.createBySuccessMessage("直属领导评分成功");
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListBranchStaffRes.class),
    })
    @ApiOperation(value = "获取分管员工列表", notes = "获取分管员工列表")
    @RequestMapping(value = "/listBranchStaff", method = RequestMethod.POST)
    public ResponseDTO listBranchStaff(@RequestBody @ApiParam("请求对象") @Valid ListBranchStaffReq listBranchStaffReq, BindingResult bindingResult, @RequestHeader String token) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(listBranchStaffReq.toString());
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            ResponseDTO<List<ListBranchStaffRes>> responseDTO =  performanceStageService.listBranchStaffByPage(userDTO, listBranchStaffReq);
            return responseDTO;
        } catch (PerformanceException e){
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
            @ApiResponse(code = 2, message = "数组对象", response = ListLevelDictRes.class),
    })
    @ApiOperation(value = "获取评级字典", notes = "获取评级字典")
    @RequestMapping(value = "/listLevelDict", method = RequestMethod.POST)
    public ResponseDTO listLevelDict(@RequestHeader String token) {
        try {
            logger.debug("listLevelDict");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            List<ListLevelDictRes> listLevelDictResList =  performanceStageService.listLevelDict(userDTO);
            return ResponseDTO.createBySuccess("获取评级字典成功", listLevelDictResList);
        } catch (PerformanceException e){
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
    @ApiOperation(value = "获取评级字典", notes = "获取评级字典")
    @RequestMapping(value = "/addLevel", method = RequestMethod.POST)
    public ResponseDTO addLevel(@RequestBody @Param("请求对象") @Valid AddLevelReq addLevelReq, @RequestHeader String token) {
        try {
            logger.debug(addLevelReq.toString());
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            performanceStageService.addLevel(userDTO, addLevelReq);
            return ResponseDTO.createBySuccessMessage("获取评级字典成功");
        } catch (PerformanceException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（布朗对象）", response = Boolean.class),
    })
    @ApiOperation(value = "判断评级是否可发布", notes = "判断评级是否可发布")
    @RequestMapping(value = "/checkReleaseLevel", method = RequestMethod.POST)
    public ResponseDTO checkReleaseLevel(@RequestHeader String token) {
        try {
            logger.debug("checkReleaseLevel");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            boolean flag = performanceStageService.checkReleaseLevel(userDTO);
            return ResponseDTO.createBySuccess("判断评级是否可发布成功", flag);
        } catch (PerformanceException e){
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
    @ApiOperation(value = "发布评级", notes = "发布评级")
    @RequestMapping(value = "/releaseLevel", method = RequestMethod.POST)
    public ResponseDTO releaseLevel(@RequestHeader String token) {
        try {
            logger.debug("releaseLevel");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            performanceStageService.releaseLevel(userDTO);
            return ResponseDTO.createBySuccessMessage("发布评级成功");
        } catch (PerformanceException e){
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
    @ApiOperation(value = "导出Excel", notes = "导出Excel")
    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public ResponseDTO exportExcel(@RequestHeader String token) {
        try {
            logger.debug("exportExcel");
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            performanceStageService.exportExcel(userDTO);
            return ResponseDTO.createBySuccessMessage("导出Excel成功");
        } catch (PerformanceException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
