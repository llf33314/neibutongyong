import axios from './../../../http'

let inside_base = window.INSIDE_BASE_URL + "/weekly";

/*  */
export const requestListStaff = params => {
  return axios.post(`${inside_base}/app/staff/listByPage`, params).then(res => res.data)
}
