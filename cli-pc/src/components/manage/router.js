// 异步加载
const user = () => import('@/components/dict/vue/user')
export const userAppRouter = [
    {
        path: '/app/user',
        name: 'user',
        component: user,
    }
]