import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
import {routers} from './../router/router'
const store = new Vuex.Store({
  state: {
    count: 0,
    tagsList: [
      {
        path: '/home',
        title: '首页'
      }
    ],
    selectTag:'/home',
    allRouters:routers
  },
  mutations: {
    increment(state, router) {
      var flag = true
      state.tagsList.forEach(item => {
        if (item.path == router.path) flag = false
      })
      if (flag) state.tagsList.push(router)

      console.log(state.allRouters,'allRouters')
    }
  }
})
export default store
