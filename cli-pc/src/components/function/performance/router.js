// 异步加载
const index = () => import('@/components/function/performance/vue/index')
const total = () => import('@/components/function/performance/vue/total')
const organize = () => import('@/components/function/performance/vue/organize')
const own = () => import('@/components/function/performance/vue/own')
const directlyInfo = () => import('@/components/function/performance/vue/directlyInfo')
const directly = () => import('@/components/function/performance/vue/directly')
const branch = () => import('@/components/function/performance/vue/branch')
export const performanceAppRouter = [
    {
        path: '/app/performance',
        name: 'index',
        component: index,
        redirect: '/app/performance/total',
        children: [
          {
            path: '/app/performance/total',
            name: 'total',
            component: total,
          },
          {
            path: '/app/performance/organize',
            name: 'organize',
            component: organize,
          },
          {
            path: '/app/performance/own',
            name: 'own',
            component: own,
          },
          {
            path: '/app/performance/directly',
            name: 'directly',
            component: directly,
          },
          {
            path: '/app/performance/directlyInfo',
            name: 'directlyInfo',
            component: directlyInfo,
          },
          {
            path: '/app/performance/branch',
            name: 'branch',
            component: branch,
          }
        ]
    }
]