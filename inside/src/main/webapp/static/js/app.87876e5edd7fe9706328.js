webpackJsonp([4],{103:function(e,n){},113:function(e,n){e.exports={render:function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]}},19:function(e,n,t){"use strict";var r=t(2),a=t(114),o=t(83),u=t(82);r.default.use(a.a);var s=[];s=s.concat(o.a),s=s.concat(u.a);var i=new a.a({routes:s});n.a=i},20:function(e,n,t){"use strict";var r=t(62),a=t.n(r),o=t(104),u=t.n(o),s=t(19),i=t(9),c=(t.n(i),a.a.create({timeout:3e3}));c.interceptors.request.use(function(e){return e},function(e){return t.i(i.Message)({showClose:!0,message:e,type:"error.data.error.message"}),u.a.reject(e)}),c.interceptors.response.use(function(e){return 301!=e.data.code&&300!=e.data.code||t.i(i.Message)({showClose:!0,message:e.data.msg,type:"error",onClose:function(){s.a.push({path:"/error/index"})}}),e},function(e){if(void 0!=e.response&&"undefined"!=e.response)return u.a.reject(e.response.data)}),n.a=c},37:function(e,n){},38:function(e,n,t){function r(e){t(103)}var a=t(39)(t(81),t(113),r,null,null);e.exports=a.exports},81:function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0}),n.default={name:"app"}},82:function(e,n,t){"use strict";var r=function(){return t.e(1).then(t.bind(null,118))},a=function(){return t.e(2).then(t.bind(null,119))},o=[{path:"/login",name:"login",component:r},{path:"/menu",name:"menu",component:a}];n.a=o},83:function(e,n,t){"use strict";t.d(n,"a",function(){return a});var r=function(){return t.e(0).then(t.bind(null,120))},a=[{path:"/app/index",name:"index",component:r}]},84:function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var r=t(2),a=t(38),o=t.n(a),u=t(20),s=t(19),i=t(9),c=t.n(i),p=t(37);t.n(p);r.default.use(c.a),r.default.prototype.axios=u.a,r.default.config.productionTip=!0,new r.default({el:"#app",router:s.a,axios:u.a,template:"<App/>",components:{App:o.a}})}},[84]);
//# sourceMappingURL=app.87876e5edd7fe9706328.js.map