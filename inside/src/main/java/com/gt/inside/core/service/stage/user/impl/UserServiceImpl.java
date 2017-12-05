package com.gt.inside.core.service.stage.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.stage.role.dto.RoleUserHasDTO;
import com.gt.inside.core.bean.stage.user.req.*;
import com.gt.inside.core.bean.stage.user.res.ListUserRes;
import com.gt.inside.core.dao.stage.user.UserDAO;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.entity.stage.user.User;
import com.gt.inside.core.entity.stage.user.UserRole;
import com.gt.inside.core.exception.stage.user.UserException;
import com.gt.inside.core.service.organize.staff.StaffService;
import com.gt.inside.core.service.stage.role.RoleService;
import com.gt.inside.core.service.stage.user.UserRoleService;
import com.gt.inside.core.service.stage.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    StaffService staffService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    /**
     * 默认密码
     */
    private static String defaultPwd = "gt123456";

    /**
     * 分页获取用户信息
     *
     * @param listUserReq
     * @return
     */
    @Override
    public ResponseDTO<List<ListUserRes>> listByPage(ListUserReq listUserReq) {
        Page<ListUserRes> page = new Page<>(listUserReq.getCurrent(), listUserReq.getSize());
        List<ListUserRes> listUserResList = userDAO.listByPageBySearchAndStatus(page, listUserReq.getUserSearch(), listUserReq.getUserStatus());
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取用户信息成功", listUserResList, pageDTO);
    }

    /**
     * 新增用户
     *
     * @param addUserReq
     */
    @Override
    public void addUser(AddUserReq addUserReq) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("login_name", addUserReq.getLoginName());
        User userCheck = selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(userCheck)){
            throw new UserException(ResponseEnums.USER_HAS);
        }
        User user = new User();
        user.setLoginName(addUserReq.getLoginName());
        user.setUserName(addUserReq.getUserName());
        user.setUserPwd(addUserReq.getPassword());
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setDeleteFlag(0);
        insert(user);
    }

    /**
     * 编辑用户
     *
     * @param modifyUserReq
     */
    @Override
    public void modifyUser(ModifyUserReq modifyUserReq) {
        User user = selectById(modifyUserReq.getUserId());
        if (CommonUtil.isNotEmpty(user)){
            throw new UserException(ResponseEnums.USER_NULL);
        }
        user.setUserName(modifyUserReq.getUserName());
        updateAllColumnById(user);
    }

    /**
     * 重置密码
     *
     * @param restPwdReq
     */
    @Override
    public void restPwd(RestPwdReq restPwdReq) {
        User user = selectById(restPwdReq.getUserId());
        if (CommonUtil.isEmpty(user)){
            throw new UserException(ResponseEnums.USER_NULL);
        }
        if (user.getDeleteFlag().equals(1)){
            throw new UserException(ResponseEnums.USER_NULL);
        }
        user.setUserPwd(defaultPwd);
        updateAllColumnById(user);
    }

    /**
     * 停用用户
     *
     * @param disableUserReq
     */
    @Override
    public void disableUser(DisableUserReq disableUserReq) {
        User user = selectById(disableUserReq.getUserId());
        if (CommonUtil.isEmpty(user)){
            throw new UserException(ResponseEnums.USER_NULL);
        }
        user.setUserStatus(1);
        updateAllColumnById(user);
    }

    /**
     * 删除用户
     *
     * @param delUserReq
     */
    @Override
    public void delUser(DelUserReq delUserReq) {
        User user = selectById(delUserReq.getUserId());
        if (CommonUtil.isEmpty(user)){
            throw new UserException(ResponseEnums.USER_NULL);
        }
        user.setDeleteFlag(1);
        updateAllColumnById(user);
        // 删除员关系
        Staff staff = staffService.selectByUserId(delUserReq.getUserId());
        if (CommonUtil.isNotEmpty(staff)){
            staffService.delUserId(staff);
        }
        // 删除角色关系
        EntityWrapper<UserRole> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_id", delUserReq.getUserId());
        userRoleService.delete(entityWrapper);
        deleteById(user.getId());
    }

    /**
     * 分页获取用户可关联员工列表
     *
     * @param listStaffReq
     * @return
     */
    @Override
    public ResponseDTO<List<Staff>> listStaffByPage(ListStaffReq listStaffReq) {
        Page<Staff> page = new Page<>(listStaffReq.getCurrent(), listStaffReq.getSize());
        EntityWrapper<Staff> entityWrapper = new EntityWrapper<>();
        entityWrapper.isNull("user_id");
        List<Staff> staffList = staffService.selectPage(page,entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取用户可关联员工列表成功", staffList, pageDTO);
    }

    /**
     * 关联员工
     *
     * @param relationStaffReq
     */
    @Override
    public void relationStaff(RelationStaffReq relationStaffReq) {
        Staff staffCheck = staffService.selectByUserId(relationStaffReq.getUserId());
        if (CommonUtil.isNotEmpty(staffCheck)){
            staffCheck.setUserId(null);
            staffService.updateAllColumnById(staffCheck);
        }
        Staff staff = staffService.selectById(relationStaffReq.getStaffId());
        if (CommonUtil.isEmpty(staff)){
            throw new UserException(ResponseEnums.STAFF_NULL);
        }
        staff.setUserId(relationStaffReq.getUserId());
        staffService.updateById(staff);
    }

    /**
     * 分页获取角色用户关系
     *
     * @param listRoleReq
     * @return
     */
    @Override
    public ResponseDTO<List<RoleUserHasDTO>> listRoleByPage(ListRoleReq listRoleReq) {
        Page<RoleUserHasDTO> page = new Page<>(listRoleReq.getCurrent(), listRoleReq.getSize());
        List<RoleUserHasDTO> roleUserHasDTOList = roleService.listRoleUserHas(page, listRoleReq.getUserId());
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取角色用户关系", roleUserHasDTOList, pageDTO);
    }

    /**
     * 关联角色
     *
     * @param relationRoleReq
     */
    @Override
    public void relationRole(RelationRoleReq relationRoleReq) {
        EntityWrapper<UserRole> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("role_id", relationRoleReq.getRoleId());
        entityWrapper.eq("user_id", relationRoleReq.getUserId());
        UserRole userRoleCheck = userRoleService.selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(userRoleCheck)){
            throw new UserException(ResponseEnums.INFONULL);
        }
        UserRole userRole = new UserRole();
        userRole.setRoleId(relationRoleReq.getRoleId());
        userRole.setUserId(relationRoleReq.getUserId());
        userRoleService.insert(userRole);
    }

    /**
     * 取消关联角色
     *
     * @param cancelRelationRoleReq
     */
    @Override
    public void cancelRelationRole(CancelRelationRoleReq cancelRelationRoleReq) {
        EntityWrapper<UserRole> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("role_id", cancelRelationRoleReq.getRoleId());
        entityWrapper.eq("user_id", cancelRelationRoleReq.getUserId());
        UserRole userRole = userRoleService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(userRole)){
            throw new UserException(ResponseEnums.VAILD);
        }
        userRoleService.delete(entityWrapper);
    }

    /**
     * 修改密码
     *
     * @param modifyPwdReq
     */
    @Override
    public void modifyPwd(UserDTO userDTO, ModifyPwdReq modifyPwdReq) {
        User user = selectById(userDTO.getUserId());
        if (CommonUtil.isEmpty(user)){
            throw new UserException(ResponseEnums.USER_NULL);
        }
        if (user.getDeleteFlag().equals(1)){
            throw new UserException(ResponseEnums.USER_NULL);
        }
        if (!user.getUserPwd().equals(modifyPwdReq.getOldPwd())){
            throw new UserException(ResponseEnums.USER_PWD_FAIL);
        }
        user.setUserPwd(modifyPwdReq.getNewPwd());
        updateById(user);
    }
}
