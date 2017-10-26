package com.gt.inside.core.controller.dict;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.dict.req.*;
import com.gt.inside.core.entity.dict.Dict;
import com.gt.inside.core.entity.dict.DictInfo;
import com.gt.inside.core.exception.dict.DictException;
import com.gt.inside.core.service.dict.DictService;
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
 * Created by psr on 2017/10/25 0025.
 */
@Api(value = "/app/dict", description = "字典管理")
@RestController
@RequestMapping(value = "/app/dict")
public class DictStageController extends BaseController {

    private static Logger logger = Logger.getLogger(DictStageController.class);

    @Autowired
    DictService dictService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = Dict.class),
    })
    @ApiOperation(value = "分页获取字典列表", notes = "分页获取字典列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") DictListReq dictListReq) {
        try {
            logger.debug(dictListReq.toString());
            ResponseDTO<List<Dict>> responseDTO =  dictService.listDictByPage(dictListReq);
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
    })
    @ApiOperation(value = "新增字典列表", notes = "新增字典列表")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody @ApiParam("新增对象") DictAddReq dictAddReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(dictAddReq.toString());
            dictService.addDict(dictAddReq);
            return ResponseDTO.createBySuccessMessage("新增字典成功");
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
    @ApiOperation(value = "修改字典列表", notes = "修改字典列表")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseDTO modify(@RequestBody @ApiParam("修改对象") DictModifyReq dictModifyReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(dictModifyReq.toString());
            dictService.modifyDict(dictModifyReq);
            return ResponseDTO.createBySuccessMessage("修改字典成功");
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
    @ApiOperation(value = "删除字典", notes = "删除字典")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseDTO del(@RequestBody @ApiParam("删除对象") DictDelReq dictDelReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(dictDelReq.toString());
            dictService.delDict(dictDelReq);
            return ResponseDTO.createBySuccessMessage("删除字典成功");
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
            @ApiResponse(code = 2, message = "项目对象", response = DictInfo.class),
    })
    @ApiOperation(value = "分页获取字典详情列表", notes = "分页获取字典详情列表")
    @RequestMapping(value = "/listInfoByPage", method = RequestMethod.POST)
    public ResponseDTO listInfoByPage(@RequestBody @ApiParam("分页请求") DictInfoListReq dictInfoListReq) {
        try {
            logger.debug(dictInfoListReq.toString());
            ResponseDTO<List<DictInfo>> responseDTO =  dictService.listDictInfoByPage(dictInfoListReq);
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
    })
    @ApiOperation(value = "新增字典详情", notes = "新增字典详情")
    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    public ResponseDTO addInfo(@RequestBody @ApiParam("新增对象") DictInfoAddReq dictInfoAddReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(dictInfoAddReq.toString());
            dictService.addDictInfo(dictInfoAddReq);
            return ResponseDTO.createBySuccessMessage("新增字典详情成功");
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
    @ApiOperation(value = "修改字典详情", notes = "修改字典详情")
    @RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
    public ResponseDTO modifyInfo(@RequestBody @ApiParam("修改对象") DictInfoModifyReq dictInfoModifyReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(dictInfoModifyReq.toString());
            dictService.modifyDictInfo(dictInfoModifyReq);
            return ResponseDTO.createBySuccessMessage("修改字典详情成功");
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
    @ApiOperation(value = "修改字典详情", notes = "修改字典详情")
    @RequestMapping(value = "/delInfo", method = RequestMethod.POST)
    public ResponseDTO delInfo(@RequestBody @ApiParam("修改对象") DictInfoDelReq dictInfoDelReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(dictInfoDelReq.toString());
            dictService.delDictInfo(dictInfoDelReq);
            return ResponseDTO.createBySuccessMessage("删除字典详情成功");
        } catch (DictException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }


}
