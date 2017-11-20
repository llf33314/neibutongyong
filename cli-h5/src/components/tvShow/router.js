// 异步加载
const index = () => import('@/components/tvShow/vue/index')
export const tvShow = [
  {
    path: '/tvShow/index',
    name: 'index',
    component: index
  }
]
