package com.gt.inside.core.controller.stage.menu;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.stage.menu.req.*;
import com.gt.inside.core.entity.stage.menu.Menu;
import com.gt.inside.core.exception.stage.menu.MenuException;
import com.gt.inside.core.service.stage.menu.MenuStageService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by psr on 2017/11/8 0008.
 */
@Api(value = "/app/menu", description = "菜单管理")
@RestController
@RequestMapping(value = "/app/menu")
public class MenuStageController extends BaseController{

    private static Logger logger = Logger.getLogger(MenuStageController.class);

    @Autowired
    MenuStageService menuStageService;

    // 分页获取菜单列表
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "菜单对象", response = Menu.class),
    })
    @ApiOperation(value = "分页获取菜单列表", notes = "分页获取菜单列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") ListMenuReq listMenuReq) {
        try {
            logger.debug(listMenuReq.toString());
            ResponseDTO<List<Menu>> responseDTO =  menuStageService.listByPage(listMenuReq);
            return responseDTO;
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 新增主菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody @ApiParam("请求对象") @Valid AddMenuReq addMenuReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addMenuReq.toString());
            menuStageService.add(addMenuReq);
            return ResponseDTO.createBySuccessMessage("新增菜单成功");
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 编辑主菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "修改菜单", notes = "修改菜单")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseDTO modify(@RequestBody @ApiParam("请求对象") @Valid ModifyMenuReq modifyMenuReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(modifyMenuReq.toString());
            menuStageService.modify(modifyMenuReq);
            return ResponseDTO.createBySuccessMessage("修改菜单成功");
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 删除主菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseDTO del(@RequestBody @ApiParam("请求对象") @Valid DelMenuReq delMenuReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(delMenuReq.toString());
            menuStageService.del(delMenuReq);
            return ResponseDTO.createBySuccessMessage("删除菜单成功");
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 分页获取子菜单列表
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "菜单对象", response = Menu.class),
    })
    @ApiOperation(value = "分页获取子菜单列表", notes = "分页获取子菜单列表")
    @RequestMapping(value = "/listSubByPage", method = RequestMethod.POST)
    public ResponseDTO listSubByPage(@RequestBody @ApiParam("分页请求") ListSubMenuReq listSubMenuReq) {
        try {
            logger.debug(listSubMenuReq.toString());
            ResponseDTO<List<Menu>> responseDTO =  menuStageService.listSubByPage(listSubMenuReq);
            return responseDTO;
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 新增子菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "新增子菜单", notes = "新增子菜单")
    @RequestMapping(value = "/addSub", method = RequestMethod.POST)
    public ResponseDTO addSub(@RequestBody @ApiParam("请求对象") @Valid AddSubMenuReq addSubMenuReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addSubMenuReq.toString());
            menuStageService.addSub(addSubMenuReq);
            return ResponseDTO.createBySuccessMessage("新增子菜单成功");
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 编辑子菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "修改子菜单", notes = "修改子菜单")
    @RequestMapping(value = "/modifySub", method = RequestMethod.POST)
    public ResponseDTO modifySub(@RequestBody @ApiParam("请求对象") @Valid ModifySubMenuReq modifySubMenuReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(modifySubMenuReq.toString());
            menuStageService.modifySub(modifySubMenuReq);
            return ResponseDTO.createBySuccessMessage("修改子菜单成功");
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 删除子菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @RequestMapping(value = "/delSub", method = RequestMethod.POST)
    public ResponseDTO delSub(@RequestBody @ApiParam("请求对象") @Valid DelSubMenuReq delSubMenuReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(delSubMenuReq.toString());
            menuStageService.delSub(delSubMenuReq);
            return ResponseDTO.createBySuccessMessage("删除子菜单成功");
        } catch (MenuException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
