// 异步加载
const user = () => import('@/components/manage/vue/user');
const menu = () => import('@/components/manage/vue/menu');
const role = () => import('@/components/manage/vue/role');
export const manageAppRouter = [
    {
        path: '/app/user',
        name: 'user',
        component: user,
    },
    {
        path: '/app/menu',
        name: 'menu',
        component: menu,
    },
    {
        path: '/app/role',
        name: 'role',
        component: role,
    }
]
