webpackJsonp([2],{12:function(e,t,n){"use strict";var r=n(4),a=n(49),o=n(50);r.a.use(a.a);var u=[];u=u.concat(o.a);var i=new a.a({routes:u});t.a=i},14:function(e,t,n){"use strict";var r=n(23),a=n.n(r),o=n(41),u=n.n(o),i=(n(12),a.a.create({timeout:3e3}));i.interceptors.request.use(function(e){return e},function(e){return u.a.reject(e)}),i.interceptors.response.use(function(e){return 301!=e.data.code&&300!=e.data.code||alert(e.data.msg),e},function(e){if(void 0!=e.response&&"undefined"!=e.response)return u.a.reject(e.response.data)}),t.a=i},15:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n(4),a=n(18),o=n(14),u=n(12);n(51),r.a.prototype.axios=o.a,r.a.config.productionTip=!0,new r.a({el:"#app",router:u.a,axios:o.a,template:"<App/>",components:{App:a.a}})},18:function(e,t,n){"use strict";function r(e){n(19)}var a=n(21),o=n(22),u=n(13),i=r,c=u(a.a,o.a,!1,i,null,null);t.a=c.exports},19:function(e,t){},21:function(e,t,n){"use strict";t.a={name:"app"}},22:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},a=[],o={render:r,staticRenderFns:a};t.a=o},50:function(e,t,n){"use strict";n.d(t,"a",function(){return a});var r=function(){return n.e(0).then(n.bind(null,54))},a=[{path:"/tvShow/index",name:"index",component:r}]},51:function(e,t){}},[15]);