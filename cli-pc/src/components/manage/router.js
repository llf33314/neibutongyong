// 异步加载
const user = () => import('@/components/manage/vue/user')
export const manageAppRouter = [
    {
        path: '/app/user',
        name: 'user',
        component: user,
    }
]
