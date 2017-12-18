export const weeklyRouter = [{
    path: '/weekly/index',
    name: 'weekly',
    component: resolve => {
      require(['@/components/weekly/vue/index'], resolve)
    },
    redirect: '/weekly/my',
    children: [{
        path: '/weekly/my',
        name: 'weekly-my',
        component: resolve => {
          require(['@/components/weekly/vue/my/index'], resolve)
        }
      },
      {
        path: '/weekly/all',
        name: 'weekly-all',
        component: resolve => {
          require(['@/components/weekly/vue/all/index'], resolve)
        }
      }

    ]
  },
  {
    path: '/weekly/add',
    name: 'weekly-add',
    component: resolve => {
      require(['@/components/weekly/vue/my/add'], resolve)
    }
  }
]
