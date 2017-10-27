// 异步加载
const user = () => import('@/components/user/vue/user')
export const userRouter = [
    {
        path: '/app/user',
        name: 'user',
        component: user,
    }
]
