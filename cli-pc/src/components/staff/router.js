// 异步加载
const staff = () => import('@/components/staff/vue/staffList')
export const staffAppRouter = [
    {
        path: '/app/staff',
        name: 'staff',
        component: staff,
    }
]