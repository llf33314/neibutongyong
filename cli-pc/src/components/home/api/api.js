import axios from './../../../http'

let base = window.BASE_URL;
/* 测试cookie */
export const requestTest = params => { return axios.post(`${base}/app/test/test`, params).then(res => res.data) }