// 异步加载
const home2 = () => import('@/components/home/vue/home')
export const homeAdminRouter = [
    {
        path: '/home2',
        name: 'home2',
        component: home2,
    }
]