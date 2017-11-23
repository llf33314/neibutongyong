import axios from './../../../http'

let inside_base = window.INSIDE_BASE_URL;
let sso_base = window.SSO_BASE_URL;

/* SSO LoginOut */
export const requestSSOLoginOut = params => { return axios.post(`${sso_base}/m/loginOut`, params).then(res => res.data) }
/* 获取用户菜单 */
export const requestUserMenu = params => { return axios.post(`${inside_base}/app/user/getUserMenus`, params).then(res => res.data) }
/* 测试cookie */
export const requestTest = params => { return axios.post(`${inside_base}/app/test/test`, params).then(res => res.data) }