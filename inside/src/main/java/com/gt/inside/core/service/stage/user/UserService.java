package com.gt.inside.core.service.stage.user;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.core.bean.stage.role.dto.RoleUserHasDTO;
import com.gt.inside.core.bean.stage.user.req.*;
import com.gt.inside.core.bean.stage.user.res.ListUserRes;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.entity.stage.role.Role;
import com.gt.inside.core.entity.stage.user.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-17
 */
public interface UserService extends IService<User> {
    /**
     * 分页获取用户信息
     * @param listUserReq
     * @return
     */
    ResponseDTO<List<ListUserRes>> listByPage(ListUserReq listUserReq);

    /**
     * 新增用户
     * @param addUserReq
     */
    void addUser(AddUserReq addUserReq);

    /**
     * 重置密码
     * @param restPwdReq
     */
    void restPwd(RestPwdReq restPwdReq);

    /**
     * 停用用户
     * @param disableUserReq
     */
    void disableUser(DisableUserReq disableUserReq);

    /**
     * 删除用户
     * @param delUserReq
     */
    void delUser(DelUserReq delUserReq);

    /**
     * 编辑用户
     * @param modifyUserReq
     */
    void modifyUser(ModifyUserReq modifyUserReq);

    /**
     * 分页获取用户可关联员工列表
     * @param listStaffReq
     * @return
     */
    ResponseDTO<List<Staff>> listStaffByPage(ListStaffReq listStaffReq);

    /**
     * 分页获取角色用户关系
     * @param listRoleReq
     * @return
     */
    ResponseDTO<List<RoleUserHasDTO>> listRoleByPage(ListRoleReq listRoleReq);

    /**
     * 关联员工
     * @param relationStaffReq
     */
    void relationStaff(RelationStaffReq relationStaffReq);

    /**
     * 关联角色
     * @param relationRoleReq
     */
    void relationRole(RelationRoleReq relationRoleReq);

    /**
     * 取消关联角色
     * @param cancelRelationRoleReq
     */
    void cancelRelationRole(CancelRelationRoleReq cancelRelationRoleReq);

    /**
     * 修改密码
     * @param modifyPwdReq
     */
    void modifyPwd(UserDTO userDTO, ModifyPwdReq modifyPwdReq);
}
