import Vue from 'vue'
import Router from 'vue-router'
// 异步加载
const menu = () =>
  import ('@/components/menu')
const home = () =>
  import ('@/components/home')
Vue.use(Router)
const routes = [{
  path: '/index',
  name: 'index',
  component: menu,
  redirect: '/home',
  children: [{
    path: '/home',
    name: 'home',
    component: home,
  }]
}]

const router = new Router({
  //mode: 'history',
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
