// 首页
const homeAppRouter = {
  path: '/home',
  name: 'home',
  title: '首页',
  component: resolve => {
    require(['@/components/home/vue/index'], resolve)
  },
  redirect: '/index',
  children: [
    {
      path: '/index',
      name: 'index',
      component: resolve => {
        require(['@/components/home/vue/home'], resolve)
      },
      title: '首页'
    }
  ]
}
// 字典
const dict = () => import('@/components/dict/vue/dictList')
const dictInfo = () => import('@/components/dict/vue/dictInfo')

const dictAppRouter = {
  path: '/app/dict',
  name: 'dictMrg',
  title: '字典管理',
  component: resolve => {
    require(['@/components/home/vue/index'], resolve)
  },
  children: [
    {
      path: '/app/dict',
      name: 'dict',
      component: dict,
      title: '字典列表'
    },
    {
      path: '/app/dictInfo',
      name: 'dictInfo',
      component: dictInfo,
      title: '新增'
    }
  ]
}
// import { dictAppRouter } from '@/components/dict/router.js'
// 员工
import { staffAppRouter } from '@/components/organize/staff/router.js'
// 部门
import { departRouter } from '@/components/organize/department/router.js'
// 绩效
import { performanceAppRouter } from '@/components/function/performance/router.js'
// 后台管理
import { manageAppRouter } from '@/components/manage/router.js'

var childrenRouter = [homeAppRouter, dictAppRouter]
// 多个子路由
// childrenRouter = childrenRouter.concat(homeAppRouter)
// childrenRouter = childrenRouter.concat(dictAppRouter)
childrenRouter = childrenRouter.concat(staffAppRouter)
childrenRouter = childrenRouter.concat(departRouter)
childrenRouter = childrenRouter.concat(performanceAppRouter)
childrenRouter = childrenRouter.concat(manageAppRouter)

export const routers = childrenRouter
