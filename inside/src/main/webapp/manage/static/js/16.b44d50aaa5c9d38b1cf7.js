webpackJsonp([16],{137:function(e,t,a){var n=a(58)(a(157),a(207),null,null,null);e.exports=n.exports},157:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{manage:"total"}},methods:{getPower:function(){},handleClick:function(e,t){this.$router.push({path:"/app/performance/"+e.name})}},created:function(){this.manage=this.$route.name}}},207:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{padding:"25px"}},[a("el-tabs",{staticStyle:{"margin-bottom":"15px"},attrs:{type:"card"},on:{"tab-click":e.handleClick},model:{value:e.manage,callback:function(t){e.manage=t},expression:"manage"}},[a("el-tab-pane",{attrs:{label:"绩效总览",name:"total"}}),e._v(" "),a("el-tab-pane",{attrs:{label:"组织关系设置",name:"organize"}}),e._v(" "),a("el-tab-pane",{attrs:{label:"自评分",name:"own"}}),e._v(" "),a("el-tab-pane",{attrs:{label:"直属领导评分",name:"directly"}}),e._v(" "),a("el-tab-pane",{attrs:{label:"分管领导评级",name:"branch"}})],1),e._v(" "),a("router-view")],1)},staticRenderFns:[]}}});
//# sourceMappingURL=16.b44d50aaa5c9d38b1cf7.js.map