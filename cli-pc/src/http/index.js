import axios from 'axios'
import Promise from 'promise'
import {router} from './../router/index'
import qs from 'qs'

const Axios = axios.create({
  //  baseURL: "http://192.168.3.98:7072",
  // timeout: 10000,
  // responseType: "json",
  // withCredentials: true, // 是否允许带cookie这些
});

// 添加请求拦截器
Axios.interceptors.request.use(
  config => {
   
    return config
  },
  err => {
   
    return err
  })

// http response 拦截器 返回状态判断
Axios.interceptors.response.use(
  response => {
    if (response.data.code == 201) {
      localStorage.removeItem('token');
      router.replace({
        path: '/index',
        query: { redirect: router.currentRoute.fullPath }
      })
    }
   
    return response
  },
  error => {
    
    return error   // 返回接口返回的错误信息
  })
export default Axios
