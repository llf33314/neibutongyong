package com.gt.inside.core.controller.dict;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.devproject.DevProjectVO;
import com.gt.inside.core.bean.dict.req.DictListReq;
import com.gt.inside.core.entity.dict.Dict;
import com.gt.inside.core.exception.devproject.DevProjectException;
import com.gt.inside.core.service.dict.DictService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by psr on 2017/10/25 0025.
 */
@Api(value = "/app/dict", description = "字典后台管理")
@RestController
@RequestMapping(value = "/app/dict")
public class DictStageController {

    private static Logger logger = Logger.getLogger(DictStageController.class);

    @Autowired
    DictService dictService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = DevProjectVO.class),
    })
    @ApiOperation(value = "分页获取字典列表", notes = "分页获取字典列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") DictListReq dictListReq) {
        try {
            ResponseDTO<List<Dict>> responseDTO =  dictService.listDictByPage(dictListReq);
            return responseDTO;
        } catch (DevProjectException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
