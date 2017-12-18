import Vue from 'vue'
import Router from 'vue-router'
import axios from './../http'
// 首页
import { homeAdminRouter } from '@/components/home/router.js'
// 字典
import { dictAppRouter } from '@/components/dict/router.js'
// 员工
import { staffAppRouter } from '@/components/organize/staff/router.js'
// 部门
import { departRouter } from '@/components/organize/department/router.js'
// 绩效
import { performanceAppRouter } from '@/components/function/performance/router.js'
// 后台管理
import { manageAppRouter } from '@/components/manage/router.js'
//周报
import { weeklyRouter } from '@/components/weekly/router/index.js'

const menu = () => import('@/components/home/vue/menu')
const home = () => import('@/components/home/vue/home')

Vue.use(Router)

var childrenRouter = [];

// 多个子路由
childrenRouter = childrenRouter.concat(homeAdminRouter);
childrenRouter = childrenRouter.concat(dictAppRouter);
childrenRouter = childrenRouter.concat(staffAppRouter);
childrenRouter = childrenRouter.concat(departRouter);
childrenRouter = childrenRouter.concat(performanceAppRouter);
childrenRouter = childrenRouter.concat(manageAppRouter);
childrenRouter = childrenRouter.concat(weeklyRouter);


// 主路由
var routes = [{
  path: '/index',
  name: 'index',
  component: menu,
  redirect: '/home',
  children: childrenRouter
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
