// 异步加载
const index = () =>
  import ('@/components/app/tvShow/vue/index')
export const appTvShow = [{
  path: '/app/index',
  name: 'index',
  component: index
}]
