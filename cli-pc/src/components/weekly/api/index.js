import axios from './../../../http'

let inside_base = window.INSIDE_BASE_URL + "/weekly";

/* 新增周报 */
export const add = params => {
  return axios.post(`${inside_base}/app/weekly/add`, params).then(res => res.data)
}
// 获取上周周报信息
export const listLast = params => {
  return axios.post(`${inside_base}/app/weekly/listLast`, params).then(res => res.data)
}
// 获取本周周报信息
export const listThis = params => {
  return axios.post(`${inside_base}/app/weekly/listThis`, params).then(res => res.data)
}
