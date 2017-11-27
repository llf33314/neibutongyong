// 异步加载
const dict = () => import('@/components/dict/vue/dictList')
const dictInfo = () => import('@/components/dict/vue/dictInfo')
export const dictAppRouter = [
    {
        path: '/app/dict',
        name: 'dict',
        component: dict,
    },
    {
        path: '/app/dictInfo',
        name: 'dictInfo',
        component: dictInfo,
    }
]