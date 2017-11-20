import Vue from 'vue'
import App from './App'
import axios from './http/index'
import router from './router'
/*
 * 加载全局方法
 * */
import util from './assets/js/util'
/*
* 挂载全局方法
* */
Vue.prototype.$util = util

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import { timeTransForm } from './assets/js/Lib'
const gt = require('gt-public-js/dist/gt.min')
Vue.prototype.gt = gt

Vue.use(ElementUI)
// 时间戳转化
Vue.prototype.timeTransForm = timeTransForm
Vue.prototype.axios = axios
Vue.config.productionTip = true

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  axios,
  template: '<App/>',
  components: { App }
})
