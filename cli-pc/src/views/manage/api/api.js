import axios from './../../../http'

let inside_base = window.INSIDE_BASE_URL;

/* 获取用户列表 */
export const requestListUser = params => { return axios.post(`${inside_base}/app/user/listByPage`, params).then(res => res.data) }
/* 新增用户 */
export const requestAddUser = params => { return axios.post(`${inside_base}/app/user/add`, params).then(res => res.data) }
/* 重置密码 */
export const requestRestPwdUser = params => { return axios.post(`${inside_base}/app/user/restPwd`, params).then(res => res.data) }
/* 停用用户 */
export const requestDisableUser = params => { return axios.post(`${inside_base}/app/user/disable`, params).then(res => res.data) }
/* 删除用户 */
export const requestDelUser = params => { return axios.post(`${inside_base}/app/user/del`, params).then(res => res.data) }
/* 获取用户可关联员工 */
export const requestListUserStaff = params => { return axios.post(`${inside_base}/app/user/listStaffByPage`, params).then(res => res.data) }
/* 关联员工 */
export const requestRelationStaff = params => { return axios.post(`${inside_base}/app/user/relationStaff`, params).then(res => res.data) }
/* 获取角色用户关系 */
export const requestListRoleByPage = params => { return axios.post(`${inside_base}/app/user/listRoleByPage`, params).then(res => res.data) }
/* 关联角色 */
export const requestRelationRole = params => { return axios.post(`${inside_base}/app/user/relationRole`, params).then(res => res.data) }
/* 取消关联角色 */
export const requestCancelRelationRole = params => { return axios.post(`${inside_base}/app/user/cancelRelationRole`, params).then(res => res.data) }

/* 分页获取菜单列表 */
export const requestListMenu = params => { return axios.post(`${inside_base}/app/menu/listByPage`, params).then(res => res.data) }
/* 新增菜单 */
export const requestAddMenu = params => { return axios.post(`${inside_base}/app/menu/add`, params).then(res => res.data) }
/* 修改菜单 */
export const requestModifyMenu = params => { return axios.post(`${inside_base}/app/menu/modify`, params).then(res => res.data) }
/* 删除菜单 */
export const requestDelMenu = params => { return axios.post(`${inside_base}/app/menu/del`, params).then(res => res.data) }
/* 分页获取子菜单列表 */
export const requestListMenuSub = params => { return axios.post(`${inside_base}/app/menu/listSubByPage`, params).then(res => res.data) }
/* 新增子菜单 */
export const requestAddMenuSub = params => { return axios.post(`${inside_base}/app/menu/addSub`, params).then(res => res.data) }
/* 修改子菜单 */
export const requestModifyMenuSub = params => { return axios.post(`${inside_base}/app/menu/modifySub`, params).then(res => res.data) }
/* 删除子菜单 */
export const requestDelMenuSub = params => { return axios.post(`${inside_base}/app/menu/delSub`, params).then(res => res.data) }

/* 分页获取角色列表 */
export const requestListRole = params => { return axios.post(`${inside_base}/app/role/listByPage`, params).then(res => res.data) }
/* 新增角色 */
export const requestAddRole = params => { return axios.post(`${inside_base}/app/role/add`, params).then(res => res.data) }
/* 修改角色 */
export const requestModifyRole = params => { return axios.post(`${inside_base}/app/role/modify`, params).then(res => res.data) }
/* 删除角色 */
export const requestDelRole = params => { return axios.post(`${inside_base}/app/role/del`, params).then(res => res.data) }
/* 查询可关联的菜单 */
export const requestListAllMenu = params => { return axios.post(`${inside_base}/app/role/listMenu`, params).then(res => res.data) }
/* 关联菜单 */
export const requestRelationRoleMenu = params => { return axios.post(`${inside_base}/app/role/relationMenu`, params).then(res => res.data) }