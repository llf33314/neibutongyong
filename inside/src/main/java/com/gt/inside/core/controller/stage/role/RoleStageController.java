package com.gt.inside.core.controller.stage.role;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.stage.menu.dto.MenuMainDTO;
import com.gt.inside.core.bean.stage.menu.req.RelationMenuReq;
import com.gt.inside.core.bean.stage.menu.res.ListMenuRes;
import com.gt.inside.core.bean.stage.role.req.*;
import com.gt.inside.core.entity.stage.role.Role;
import com.gt.inside.core.exception.stage.role.RoleException;
import com.gt.inside.core.service.common.SSOService;
import com.gt.inside.core.service.stage.role.RoleStageService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by psr on 2017/11/9 0009.
 */
@Api(value = "/app/role", description = "角色管理")
@RestController
@RequestMapping(value = "/app/role")
public class RoleStageController extends BaseController {

    private static Logger logger = Logger.getLogger(RoleStageController.class);

    @Autowired
    RoleStageService roleStageService;

    @Autowired
    SSOService ssoService;

    // 分页获取角色列表
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "角色对象", response = Role.class),
    })
    @ApiOperation(value = "分页获取角色列表", notes = "分页获取角色列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") ListRoleReq listRoleReq) {
        try {
            logger.debug(listRoleReq.toString());
            ResponseDTO<List<Role>> responseDTO =  roleStageService.listByPage(listRoleReq);
            return responseDTO;
        } catch (RoleException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 新增主角色
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "新增角色", notes = "新增角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody @ApiParam("请求对象") @Valid AddRoleReq addRoleReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addRoleReq.toString());
            roleStageService.add(addRoleReq);
            return ResponseDTO.createBySuccessMessage("新增角色成功");
        } catch (RoleException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 编辑主角色
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "修改角色", notes = "修改角色")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseDTO modify(@RequestBody @ApiParam("请求对象") @Valid ModifyRoleReq modifyRoleReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(modifyRoleReq.toString());
            roleStageService.modify(modifyRoleReq);
            return ResponseDTO.createBySuccessMessage("修改角色成功");
        } catch (RoleException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 删除主角色
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "删除角色", notes = "删除角色")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseDTO del(@RequestBody @ApiParam("请求对象") @Valid DelRoleReq delRoleReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(delRoleReq.toString());
            roleStageService.del(delRoleReq);
            return ResponseDTO.createBySuccessMessage("删除角色成功");
        } catch (RoleException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 获取所有菜单列表
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "角色对象", response = MenuMainDTO.class),
    })
    @ApiOperation(value = "获取所有可关联菜单列表", notes = "获取所有可关联菜单列表")
    @RequestMapping(value = "/listMenu", method = RequestMethod.POST)
    public ResponseDTO listMenu(@RequestBody @ApiParam("请求对象") @Valid ListMenuReq listMenuReq, BindingResult bindingResult, @RequestHeader String token) {
        try {
            logger.debug(listMenuReq.toString());
            ListMenuRes listMenuRes =  roleStageService.listMenu(listMenuReq);
            return ResponseDTO.createBySuccess("获取所有可关联菜单列表成功", listMenuRes);
        } catch (RoleException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 关联角色菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "关联角色菜单", notes = "关联角色菜单")
    @RequestMapping(value = "/relationMenu", method = RequestMethod.POST)
    public ResponseDTO relationMenu(@RequestBody @ApiParam("请求对象") @Valid RelationMenuReq relationMenuReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(relationMenuReq.toString());
            roleStageService.relationMenu(relationMenuReq);
            return ResponseDTO.createBySuccessMessage("关联角色菜单成功");
        } catch (RoleException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
