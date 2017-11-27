import axios from './../../../http'

let inside_base = window.INSIDE_BASE_URL;

/* 获取字典列表 */
export const requestListDict = params => { return axios.post(`${inside_base}/app/dict/listByPage`, params).then(res => res.data) }
/* 新增字典 */
export const requestAddDict = params => { return axios.post(`${inside_base}/app/dict/add`, params).then(res => res.data) }
/* 修改字典 */
export const requestModifyDict = params => { return axios.post(`${inside_base}/app/dict/modify`, params).then(res => res.data) }
/* 删除字典 */
export const requestDelDict = params => { return axios.post(`${inside_base}/app/dict/del`, params).then(res => res.data) }
/* 获取字典详情列表 */
export const requestListDictInfo = params => { return axios.post(`${inside_base}/app/dict/listInfoByPage`, params).then(res => res.data) }
/* 新增字典详情 */
export const requestAddDictInfo = params => { return axios.post(`${inside_base}/app/dict/addInfo`, params).then(res => res.data) }
/* 修改字典详情 */
export const requestModifyDictInfo = params => { return axios.post(`${inside_base}/app/dict/modifyInfo`, params).then(res => res.data) }
/* 删除字典详情 */
export const requestDelDictInfo = params => { return axios.post(`${inside_base}/app/dict/delInfo`, params).then(res => res.data) }