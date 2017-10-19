import Vue from 'vue'
import Router from 'vue-router'

import {
  appTvShow
} from '@/components/app/tvShow/router.js'
// 后台路由
import adminRouter from '@/components/admin/adminRouter.js'

Vue.use(Router)
var routes = []
// 合并多个路由的数组
routes = routes.concat(appTvShow)
routes = routes.concat(adminRouter)

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
