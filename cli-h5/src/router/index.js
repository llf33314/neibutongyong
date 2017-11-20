import Vue from 'vue'
import Router from 'vue-router'

import { tvShow } from '@/components/tvShow/router.js'

Vue.use(Router)
var routes = []
// 合并多个路由的数组
routes = routes.concat(tvShow)

const router = new Router({
  routes
})

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
export default router
