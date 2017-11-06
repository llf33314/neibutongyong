import axios from './../../../../http'

let inside_base = window.INSIDE_BASE_URL;

/* 获取绩效权限 */
export const requestGetPower = params => { return axios.post(`${inside_base}/app/performance/getPower`, params).then(res => res.data) }
/* 获取绩效总览 */
export const requestListTotal = params => { return axios.post(`${inside_base}/app/performance/listTotal`, params).then(res => res.data) }
/* 分页获取绩效组织关系 */
export const requestListOrganize = params => { return axios.post(`${inside_base}/app/performance/listOrganize`, params).then(res => res.data) }
/* 获取部门列表 */
export const requestListDepartment = params => { return axios.post(`${inside_base}/app/department/listAll`, params).then(res => res.data) }
/* 获取员工列表 */
export const requestListStaff = params => { return axios.post(`${inside_base}/app/staff/listByPage`, params).then(res => res.data) }
/* 新增或修改直属领导 */
export const requestAddOrModifyDirectly = params => { return axios.post(`${inside_base}/app/performance/addOrModifyDirectly`, params).then(res => res.data) }
/* 新增或修改分管领导 */
export const requestAddOrModifyBranch = params => { return axios.post(`${inside_base}/app/performance/addOrModifyBranch`, params).then(res => res.data) }
/* 查询是否已经自评分 */
export const requestCheckOwnInfo = params => { return axios.post(`${inside_base}/app/performance/checkOwnInfo`, params).then(res => res.data) }
/* 查询自评分列表 */
export const requestListOwnInfo = params => { return axios.post(`${inside_base}/app/performance/listOwnInfo`, params).then(res => res.data) }
/* 获取绩效静态信息 */
export const requestListStaticInfo = params => { return axios.post(`${inside_base}/app/performance/listStaticInfo`, params).then(res => res.data) }
/* 获取用户信息 */
export const requestGetUser = params => { return axios.post(`${inside_base}/app/user/getUser`, params).then(res => res.data) }
/* 新增自评分信息 */
export const requestAddOwn = params => { return axios.post(`${inside_base}/app/performance/addOwn`, params).then(res => res.data) }
/* 获取直属员工列表 */
export const requestListDirectlyStaff = params => { return axios.post(`${inside_base}/app/performance/listDirectlyStaff`, params).then(res => res.data) }
/* 获取直属员工评分详情 */
export const requestListDirectlyInfo = params => { return axios.post(`${inside_base}/app/performance/listDirectlyInfo`, params).then(res => res.data) }
/* 新增直属领导评分 */
export const requestAddDirectly = params => { return axios.post(`${inside_base}/app/performance/addDirectly`, params).then(res => res.data) }
/* 获取分管员工列表 */
export const requestListBranchStaff = params => { return axios.post(`${inside_base}/app/performance/listBranchStaff`, params).then(res => res.data) }
/* 获取评级字典 */
export const requestListLevelDict = params => { return axios.post(`${inside_base}/app/performance/listLevelDict`, params).then(res => res.data) }
/* 新增评级 */
export const requestAddLevel = params => { return axios.post(`${inside_base}/app/performance/addLevel`, params).then(res => res.data) }
/* 判断评级是否可发布 */
export const requestCheckReleaseLevel = params => { return axios.post(`${inside_base}/app/performance/checkReleaseLevel`, params).then(res => res.data) }
/* 发布评级 */
export const requestReleaseLevel = params => { return axios.post(`${inside_base}/app/performance/releaseLevel`, params).then(res => res.data) }