package com.gt.inside.core.controller.stage.user;

import com.gt.inside.api.base.BaseController;
import com.gt.inside.api.dto.MenuDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.exception.SystemException;
import com.gt.inside.core.bean.stage.role.dto.RoleUserHasDTO;
import com.gt.inside.core.bean.stage.user.req.*;
import com.gt.inside.core.bean.stage.user.res.ListUserRes;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.exception.stage.user.UserException;
import com.gt.inside.core.service.common.SSOService;
import com.gt.inside.core.service.stage.user.UserService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by psr on 2017/10/17 0017.
 */
@Api(value = "/app/user", description = "用户管理")
@RestController
@RequestMapping(value = "/app/user")
public class UserStageController extends BaseController {

    private static Logger logger = Logger.getLogger(UserStageController.class);

    @Autowired
    UserService userService;

    @Autowired
    SSOService ssoService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（用户对象）", response = UserDTO.class),
    })
    @ApiOperation(value = "获取用户", notes = "获取用户")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResponseDTO getUser(@RequestHeader String token){
        try {
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            return ResponseDTO.createBySuccess("获取用户成功", userDTO);
        } catch (SystemException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 获取用户菜单
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "菜单对象", response = MenuDTO.class),
    })
    @ApiOperation(value = "获取用户菜单", notes = "获取用户菜单")
    @RequestMapping(value = "/getUserMenus", method = RequestMethod.POST)
    public ResponseDTO getUserMenus(@RequestHeader String token){
        try {
            UserDTO userDTO = ssoService.getSSOUerDTO(token);
            List<MenuDTO> menuDTOList = userDTO.getMenuDTOList();
            return ResponseDTO.createBySuccess("获取用户菜单成功", menuDTOList);
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 分页获取用户列表
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "用户对象", response = ListUserRes.class),
    })
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResponseDTO listByPage(@RequestBody @ApiParam("分页请求") ListUserReq listUserReq) {
        try {
            logger.debug(listUserReq.toString());
            ResponseDTO<List<ListUserRes>> responseDTO =  userService.listByPage(listUserReq);
            return responseDTO;
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 新增用户
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody @ApiParam("请求对象") @Valid AddUserReq addUserReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(addUserReq.toString());
            userService.addUser(addUserReq);
            return ResponseDTO.createBySuccessMessage("新增用户成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 编辑用户
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "编辑用户（暂未使用）", notes = "编辑用户")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseDTO modify(@RequestBody @ApiParam("请求对象") @Valid ModifyUserReq modifyUserReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(modifyUserReq.toString());
            userService.modifyUser(modifyUserReq);
            return ResponseDTO.createBySuccessMessage("编辑用户成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 重置密码
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "重置密码", notes = "重置密码")
    @RequestMapping(value = "/restPwd", method = RequestMethod.POST)
    public ResponseDTO restPwd(@RequestBody @ApiParam("请求对象") @Valid RestPwdReq restPwdReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(restPwdReq.toString());
            userService.restPwd(restPwdReq);
            return ResponseDTO.createBySuccessMessage("重置密码成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 停用用户
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "停用用户", notes = "停用用户")
    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    public ResponseDTO disable(@RequestBody @ApiParam("请求对象") @Valid DisableUserReq disableUserReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(disableUserReq.toString());
            userService.disableUser(disableUserReq);
            return ResponseDTO.createBySuccessMessage("停用用户成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 删除用户
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseDTO del(@RequestBody @ApiParam("请求对象") @Valid DelUserReq delUserReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(delUserReq.toString());
            userService.delUser(delUserReq);
            return ResponseDTO.createBySuccessMessage("删除用户成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 获取可以关联的员工
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = Staff.class),
    })
    @ApiOperation(value = "分页获取可以关联的员工列表", notes = "分页获取可以关联的员工列表")
    @RequestMapping(value = "/listStaffByPage", method = RequestMethod.POST)
    public ResponseDTO listStaffByPage(@RequestBody @ApiParam("请求对象") ListStaffReq listStaffReq) {
        try {
            logger.debug(listStaffReq.toString());
            ResponseDTO<List<Staff>> responseDTO =  userService.listStaffByPage(listStaffReq);
            return responseDTO;
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 关联员工
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "关联员工", notes = "关联员工")
    @RequestMapping(value = "/relationStaff", method = RequestMethod.POST)
    public ResponseDTO relationStaff(@RequestBody @ApiParam("请求对象") @Valid RelationStaffReq relationStaffReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(relationStaffReq.toString());
            userService.relationStaff(relationStaffReq);
            return ResponseDTO.createBySuccessMessage("关联员工成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 获取角色用户关系
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "项目对象", response = RoleUserHasDTO.class),
    })
    @ApiOperation(value = "分页获取可以关联的员工列表", notes = "分页获取可以关联的员工列表")
    @RequestMapping(value = "/listRoleByPage", method = RequestMethod.POST)
    public ResponseDTO listRoleByPage(@RequestBody @ApiParam("请求对象") ListRoleReq listRoleReq) {
        try {
            logger.debug(listRoleReq.toString());
            ResponseDTO<List<RoleUserHasDTO>> responseDTO =  userService.listRoleByPage(listRoleReq);
            return responseDTO;
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 关联角色
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "关联角色", notes = "关联角色")
    @RequestMapping(value = "/relationRole", method = RequestMethod.POST)
    public ResponseDTO relationRole(@RequestBody @ApiParam("请求对象") @Valid RelationRoleReq relationRoleReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(relationRoleReq.toString());
            userService.relationRole(relationRoleReq);
            return ResponseDTO.createBySuccessMessage("关联角色成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 取消关联角色
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
    })
    @ApiOperation(value = "取消关联角色", notes = "取消关联角色")
    @RequestMapping(value = "/cancelRelationRole", method = RequestMethod.POST)
    public ResponseDTO cancelRelationRole(@RequestBody @ApiParam("请求对象") @Valid CancelRelationRoleReq cancelRelationRoleReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug(cancelRelationRoleReq.toString());
            userService.cancelRelationRole(cancelRelationRoleReq);
            return ResponseDTO.createBySuccessMessage("取消关联角色成功");
        } catch (UserException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }
}
