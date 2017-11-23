import Vue from 'vue'
import App from './App'
import axios from './http/index'
import router from './router'
import store from './store/index'
import qs from 'qs'
/*
 * 加载全局方法
 * */
import util from './assets/js/util'
import 'animate.css'
/*
* 挂载全局方法
* */
Vue.prototype.$util = util

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import { timeTransForm } from './assets/js/Lib'
const gt = require('gt-public-js/dist/gt.min')
Vue.prototype.gt = gt
Vue.prototype.qs = qs
Vue.use(ElementUI)
// 时间戳转化
Vue.prototype.timeTransForm = timeTransForm
Vue.prototype.axios = axios
Vue.prototype.store = store
Vue.config.productionTip = true

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
