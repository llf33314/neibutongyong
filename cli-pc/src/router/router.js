import Main from '@/views/Main.vue';

// 不作为Main组件的子页面展示的页面单独写，如下
export const loginRouter = {
    path: '/login',
    name: 'login',
    meta: {
        title: 'Login - 登录'
    },
    component: resolve => { require(['@/views/login.vue'], resolve); }
};

export const page404 = {
    path: '/*',
    name: 'error-404',
    meta: {
        title: '404-页面不存在'
    },
    component: resolve => { require(['@/views/error-page/404.vue'], resolve); }
};

export const page403 = {
    path: '/403',
    meta: {
        title: '403-权限不足'
    },
    name: 'error-403',
    component: resolve => { require(['@//views/error-page/403.vue'], resolve); }
};

export const page500 = {
    path: '/500',
    meta: {
        title: '500-服务端错误'
    },
    name: 'error-500',
    component: resolve => { require(['@/views/error-page/500.vue'], resolve); }
};

export const preview = {
    path: '/preview',
    name: 'preview',
    component: resolve => { require(['@/views/form/article-publish/preview.vue'], resolve); }
};

export const locking = {
    path: '/locking',
    name: 'locking',
    component: resolve => { require(['@/views/main-components/lockscreen/components/locking-page.vue'], resolve); }
};

// 作为Main组件的子页面展示但是不在左侧菜单显示的路由写在otherRouter里
export const otherRouter = {
    path: '/',
    name: 'otherRouter',
    redirect: '/home',
    component: Main,
    children: [
        { path: 'home', title: {i18n: 'home'}, name: 'home_index', component: resolve => { require(['@/views/home/vue/home.vue'], resolve); } },
        { path: '/app/dictInfo', title: '字典详情', name: 'dict_dictInfo', component: resolve => { require(['@/views/dict/vue/dictInfo.vue'], resolve); } },
        { path: 'app/menuInfo', title: '子菜单详情', name: 'manage_menuInfo', component: resolve => { require(['@/views/manage/vue/menuInfo'], resolve); } }
    ]
};

// 作为Main组件的子页面展示并且在左侧菜单显示的路由写在appRouter里
export const appRouter = [
    {
        path: '/index',
        icon: 'gt-shouye',
        name: 'home',
        title: '首页',
        component: Main,
        redirect: 'index',
        children: [
            { path: '/index', title: '首页', name: 'home_index', component: resolve => { require(['@/views/home/vue/home.vue'], resolve); } }
        ]
    },
    {
        path: '/',
        icon: 'gt-zidian',
        name: 'dict',
        title: '字典管理',
        component: Main,
        children: [
            { path: 'dict/dict', title: '字典管理', name: 'dict_index', component: resolve => { require(['@/views/dict/vue/dictList.vue'], resolve); } }
        ]
    },
    {
        path: '/',
        icon: 'gt-xitongguanli',
        name: 'dict',
        title: '后台管理',
        component: Main,
        children: [
            { path: 'app/user', title: '用户', name: 'manage_user', component: resolve => { require(['@/views/manage/vue/user'], resolve); } },
            { path: 'app/menu', title: '菜单', name: 'manage_menu', component: resolve => { require(['@/views/manage/vue/menu'], resolve); } },
            { path: '/app/role', title: '角色', name: 'manage_role', component: resolve => { require(['@/views/manage/vue/role'], resolve); } }
        ]
    },
    {
        path: '/',
        icon: 'gt-zuzhi',
        name: 'organize',
        title: '组织管理',
        component: Main,
        children: [
            { path: 'app/department', title: '部门管理', name: 'organize_department', component: resolve => { require(['@/views/organize/department/vue/depart'], resolve); } },
            { path: '/app/staff', title: '员工管理', name: 'organize_staff', component: resolve => { require(['@/views/organize/staff/vue/staffList'], resolve); } }
        ]
    },
    {
        path: '/',
        icon: 'gt-xiangmu',
        name: 'function',
        title: '功能管理',
        component: Main,
        redirect: 'app/performance/total',
        children: [
            { path: 'app/performance/total', title: '绩效评分', name: 'function_performance', component: resolve => { require(['@/views/function/performance/vue/total'], resolve); } }
        ]
    }
];
// 所有上面定义的路由都要写在下面的routers里
export const routers = [
    loginRouter,
    otherRouter,
    preview,
    locking,
    ...appRouter,
    page500,
    page403,
    page404
];
