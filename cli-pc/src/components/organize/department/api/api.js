import axios from './../../../../http'

let inside_base = window.INSIDE_BASE_URL;


// 修改部门列表
export const requestModifyDepart = params => { return axios.post(`${inside_base}/app/department/modify`, params).then(res => res.data) }

// 删除部门
export const requestDelDepart = params => { return axios.post(`${inside_base}/app/department/del`, params).then(res => res.data) }

//分页获取部门列表
export const requestListDepartInfo = params => { return axios.post(`${inside_base}/app/department/listByPage`, params).then(res => res.data) }

//新增部门列表
export const requestAddDepartInfo = params => { return axios.post(`${inside_base}/app/department/add`, params).then(res => res.data) }

