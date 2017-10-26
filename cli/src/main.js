import Vue from 'vue'
import App from './App'
import axios from './http/index'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
/*
 * 加载全局方法
 * */
//import  util  from './assets/js/util'
/*
* 加载全局组件
* */
Vue.use(ElementUI)
/*
* 加载全局样式
* */
//require('./assets/css/public.css')
/*
* 挂载全局axsio方法
* */
Vue.prototype.axios = axios
/*
* 在启动时生成生产提示
* */
Vue.config.productionTip = true
/*
* 挂载全局方法
* */
//Vue.prototype.$util = util  
/*
* 注册全局组件
* */

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  axios,
  template: '<App/>',
  components: { App }
})
