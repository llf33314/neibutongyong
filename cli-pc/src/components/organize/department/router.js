// 异步加载
const department = () => import('@/components/organize/department/vue/depart')
export const departRouter = [
    {
        path: '/app/department',
        name: 'department',
        component: department,
    }
]
