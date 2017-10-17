import Vue from 'vue'
import Router from 'vue-router'

import {
  appTvShow
} from '@/components/app/tvShow/router.js'
const login = ()=> import('@/components/login/login')
Vue.use(Router)
var routes = [{
  path:'/login',
  name:'login',
  component:login
}]
// 合并多个路由的数组
routes = routes.concat(appTvShow)


const router = new Router({
  // mode: 'history',
  routes
});

/*router.beforeEach((to, from, next) => {
  let user = window.JSON.parse(localStorage.getItem('user'))
  if (!user && to.path !== '/login') {
    next({path: '/login'})
  } else {
    next()
  }

  if (window.localStorage.getItem('tocken')) {
    if (window.localStorage.getItem('tocken')) {
      next();
    }
    else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  }
  else {
    next();
  }
})*/
export default router;
