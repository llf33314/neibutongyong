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
        title:'用户'
    },
    {
        path: '/app/menu',
        name: 'menu',
        component: menu,
        title:'菜单'
    },
    {
        path: '/app/menuInfo',
        name: 'menuInfo',
        component: menuInfo,
        title:'子菜单详情'
    },
    {
        path: '/app/role',
        name: 'role',
        component: role,
        title:'角色'
    }
]
