// 异步加载
const staff = () => import('@/components/organize/staff/vue/staffList')
export const staffAppRouter = [
    {
        path: '/app/staff',
        name: 'staff',
        component: staff,
    }
]