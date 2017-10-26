// 异步加载
const home = () => import('@/components/home/vue/home')
export const homeAdminRouter = [
    {
        path: '/home',
        name: 'home',
        component: home,
    }
]