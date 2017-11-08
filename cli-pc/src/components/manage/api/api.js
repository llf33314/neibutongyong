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