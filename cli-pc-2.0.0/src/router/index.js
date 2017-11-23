import Vue from 'vue'
import Router from 'vue-router'
import axios from './../http'

const menu = () => import('@/components/home/vue/menu')
const home = () => import('@/components/home/vue/home')
Vue.use(Router)

import { routers } from './router'

// 主路由
var routes = [{
  path: '/index',
  name: 'index',
  component: menu,
  redirect: '/home',
  children: routers
}];

const router = new Router({
  // mode: 'history',
  routes
});

// 路由过滤器
router.beforeEach((to, from, next) => {
  /** login function */
  // 统一登录页面返回token信息
  if (to.fullPath.startsWith("/token/")) {
    var _token = to.fullPath.substring(to.fullPath.lastIndexOf("/") + 1, to.fullPath.length);
    if (_token != null && _token != 'undefind') {
      axios.defaults.headers.common['token'] = _token;
      window.localStorage.token = _token;
      next({ path: '/index' });
    }

  }
  // 获取缓存的token
  var token = window.localStorage.getItem('token') || '';
  if (token) {
    if (!axios.defaults.headers.common['token']) {
      axios.defaults.headers.common['token'] = token;
    }
    next();
  } else {
    // 跳转到统一登录页面
    window.location.href = window.SSO_LOGIN_URL;
  }
  /** login function end */
})
export default router;
