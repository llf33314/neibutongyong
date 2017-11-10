// 异步加载
const user = () => import('@/components/manage/vue/user');
const menu = () => import('@/components/manage/vue/menu');
const menuInfo = () => import('@/components/manage/vue/menuInfo');
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
        path: '/app/menuInfo',
        name: 'menuInfo',
        component: menuInfo,
    },
    {
        path: '/app/role',
        name: 'role',
        component: role,
    }
]
