import axios from './../../../../http'

let inside_base = window.INSIDE_BASE_URL;

/* 获取员工列表 */
export const requestListStaff = params => { return axios.post(`${inside_base}/app/staff/listByPage`, params).then(res => res.data) }
/* 新增员工 */
export const requestAddStaff = params => { return axios.post(`${inside_base}/app/staff/add`, params).then(res => res.data) }
/* 修改员工 */
export const requestModifyStaff = params => { return axios.post(`${inside_base}/app/staff/modify`, params).then(res => res.data) }
/* 删除员工 */
export const requestDelStaff = params => { return axios.post(`${inside_base}/app/staff/del`, params).then(res => res.data) }
/* 离职员工 */
export const requestQuitStaff = params => { return axios.post(`${inside_base}/app/staff/quit`, params).then(res => res.data) }
/* 获取部门列表 */
export const requestListDepartment = params => { return axios.post(`${inside_base}/app/department/listAll`, params).then(res => res.data) }