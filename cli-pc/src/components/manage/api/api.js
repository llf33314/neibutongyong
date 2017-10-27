import axios from './../../../http'

let inside_base = window.INSIDE_BASE_URL;

/* 获取字典列表 */
export const requestListDict = params => { return axios.post(`${inside_base}/app/dict/listByPage`, params).then(res => res.data) }