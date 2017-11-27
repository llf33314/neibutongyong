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
        title:'绩效评分',
        children: [
          {
            path: '/app/performance/total',
            name: 'total',
            component: total,
            title:'绩效总览'
          },
          {
            path: '/app/performance/organize',
            name: 'organize',
            component: organize,
            title:'组织关系设置'
          },
          {
            path: '/app/performance/own',
            name: 'own',
            component: own,
            title:'自评分'
          },
          {
            path: '/app/performance/directly',
            name: 'directly',
            component: directly,
            title:'绩效评分列表'
          },
          {
            path: '/app/performance/directlyInfo',
            name: 'directlyInfo',
            component: directlyInfo,
            title:'评分员工'
          },
          {
            path: '/app/performance/branch',
            name: 'branch',
            component: branch,
            title:'绩效评级列表'
          }
        ]
    }
]