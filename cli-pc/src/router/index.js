import Vue from 'vue'
import Router from 'vue-router'
import axios from './../http'

const menu = () => import('@/components/home/vue/menu')
const home = () => import('@/components/home/vue/home')
const dict = () => import('@/components/dict/vue/dictList')

Vue.use(Router)
var routes = [{
  path: '/index',
  name: 'index',
  component: menu,
  redirect: '/home',
  children: [
    {
      path: '/home',
      name: 'home',
      component: home,
    },
    {
      path: '/app/dict',
      name: 'dict',
      component: dict,
    }
  ]
}]

// 合并多个路由的数组
// routes.children = routes[0].children.concat(dictAppRouter);

const router = new Router({
  // mode: 'history',
  routes
});

router.beforeEach((to, from, next) => {
  /** login function one */
  // if (to.fullPath.startsWith("/token/")) {
  //   var _t = to.fullPath.substring(to.fullPath.lastIndexOf("/") + 1, to.fullPath.length);
  //   axios.defaults.headers.common['token'] = token;
  // }
  // var token = window.localStorage.getItem('token') || '';
  // if (token) {
  //   if (!axios.defaults.headers.common['token']) {
  //     axios.defaults.headers.common['token'] = token;
  //   }
  //   next();
  // } else {
  //   axios.post(window.INSIDE_BASE_URL + 'm/login').then((res) => {
  //     console.log(res.data);
  //     if (res.data.code == 100) {
  //       window.localStorage.token = res.data.data;
  //       next();
  //     } else {
  //       window.location.href = res.data.data;
  //     }
  //   })
  // }
  /** login function one end */

  /** login function second */
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
  /** login function second end */

  // let user = window.JSON.parse(localStorage.getItem('user'))
  // if (!user && to.path !== '/login') {
  //   next({path: '/login'})
  // } else {
  //   next()
  // }

  // if (window.localStorage.getItem('tocken')) {
  //   if (window.localStorage.getItem('tocken')) {
  //     next();
  //   }
  //   else {
  //     next({
  //       path: '/login',
  //       query: {redirect: to.fullPath}
  //     })
  //   }
  // }
  // else {
  //   next();
  // }
})
export default router;
