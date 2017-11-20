import axios from './../../../http'

let base = window.TestDOMAIN
/* 登录请求 */
export const requestListProject = params => { return axios.post(`${base}/m/dev/project/listProject`, params).then(res => res.data) }
