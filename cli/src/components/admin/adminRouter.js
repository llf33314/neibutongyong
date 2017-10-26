const login = () =>
  import ('@/components/admin/login/login')
const menu = () =>
  import ('@/components/admin/menu/menu')


var adminRouter = [{
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/menu',
    name: 'menu',
    component: menu
  }
]
//adminRouter = adminRouter.concat(appTvShow)

export default adminRouter;
