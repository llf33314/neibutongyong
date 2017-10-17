import axios from './../../../../http'

let base = 'http://192.168.3.98:7075'
/* 登录请求 */
export const requestGetAllMenu = params => { return axios.post(`${base}/app/user/getAllMenu`, params).then(res => res.data) }
