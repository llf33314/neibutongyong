// 异步加载
const dict = () => import('@/components/dict/vue/dictList')
const dictInfo = () => import('@/components/dict/vue/dictInfo')
export const dictAppRouter = [
    {
        path: '/app/dict',
        name: 'dict',
        component: dict,
        title:'字典列表'
    },
    {
        path: '/app/dictInfo',
        name: 'dictInfo',
        component: dictInfo,
        title:'新增'
    }
]