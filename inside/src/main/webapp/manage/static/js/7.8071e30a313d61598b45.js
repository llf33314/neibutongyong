webpackJsonp([7],{215:function(t,e,n){"use strict";function a(t){n(275)}Object.defineProperty(e,"__esModule",{value:!0});var u=n(277),i=n(278),r=n(78),o=a,l=r(u.a,i.a,!1,o,null,null);e.default=l.exports},220:function(t,e,n){"use strict";n.d(e,"p",function(){return i}),n.d(e,"d",function(){return r}),n.d(e,"x",function(){return o}),n.d(e,"j",function(){return l}),n.d(e,"i",function(){return s}),n.d(e,"q",function(){return c}),n.d(e,"w",function(){return d}),n.d(e,"o",function(){return f}),n.d(e,"u",function(){return p}),n.d(e,"e",function(){return m}),n.d(e,"l",function(){return h}),n.d(e,"a",function(){return g}),n.d(e,"r",function(){return b}),n.d(e,"f",function(){return v}),n.d(e,"m",function(){return y}),n.d(e,"b",function(){return _}),n.d(e,"s",function(){return M}),n.d(e,"g",function(){return S}),n.d(e,"n",function(){return L}),n.d(e,"c",function(){return x}),n.d(e,"t",function(){return k}),n.d(e,"h",function(){return w}),n.d(e,"k",function(){return C}),n.d(e,"v",function(){return O});var a=n(46),u=window.INSIDE_BASE_URL,i=function(t){return a.a.post(u+"/app/user/listByPage",t).then(function(t){return t.data})},r=function(t){return a.a.post(u+"/app/user/add",t).then(function(t){return t.data})},o=function(t){return a.a.post(u+"/app/user/restPwd",t).then(function(t){return t.data})},l=function(t){return a.a.post(u+"/app/user/disable",t).then(function(t){return t.data})},s=function(t){return a.a.post(u+"/app/user/del",t).then(function(t){return t.data})},c=function(t){return a.a.post(u+"/app/user/listStaffByPage",t).then(function(t){return t.data})},d=function(t){return a.a.post(u+"/app/user/relationStaff",t).then(function(t){return t.data})},f=function(t){return a.a.post(u+"/app/user/listRoleByPage",t).then(function(t){return t.data})},p=function(t){return a.a.post(u+"/app/user/relationRole",t).then(function(t){return t.data})},m=function(t){return a.a.post(u+"/app/user/cancelRelationRole",t).then(function(t){return t.data})},h=function(t){return a.a.post(u+"/app/menu/listByPage",t).then(function(t){return t.data})},g=function(t){return a.a.post(u+"/app/menu/add",t).then(function(t){return t.data})},b=function(t){return a.a.post(u+"/app/menu/modify",t).then(function(t){return t.data})},v=function(t){return a.a.post(u+"/app/menu/del",t).then(function(t){return t.data})},y=function(t){return a.a.post(u+"/app/menu/listSubByPage",t).then(function(t){return t.data})},_=function(t){return a.a.post(u+"/app/menu/addSub",t).then(function(t){return t.data})},M=function(t){return a.a.post(u+"/app/menu/modifySub",t).then(function(t){return t.data})},S=function(t){return a.a.post(u+"/app/menu/delSub",t).then(function(t){return t.data})},L=function(t){return a.a.post(u+"/app/role/listByPage",t).then(function(t){return t.data})},x=function(t){return a.a.post(u+"/app/role/add",t).then(function(t){return t.data})},k=function(t){return a.a.post(u+"/app/role/modify",t).then(function(t){return t.data})},w=function(t){return a.a.post(u+"/app/role/del",t).then(function(t){return t.data})},C=function(t){return a.a.post(u+"/app/role/listMenu",t).then(function(t){return t.data})},O=function(t){return a.a.post(u+"/app/role/relationMenu",t).then(function(t){return t.data})}},275:function(t,e,n){var a=n(276);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);n(202)("57f7083d",a,!0)},276:function(t,e,n){e=t.exports=n(201)(!1),e.push([t.i,".manage-menu .a-admin-head{padding:35px 0 35px 25px}.manage-menu .a-admin-table{margin:0 20px 20px}.manage-menu .el-pagination{float:right;margin-right:20px}",""])},277:function(t,e,n){"use strict";var a=n(220);e.a={data:function(){return{menuListReq:{menuSearch:"",current:1,size:10},page:{totalNums:1,totalPages:1},menuListData:[],menu:{id:0,menuName:0,menuUrl:"",menuIcon:"",menuSub:0},menuSubOptions:[{value:0,label:"不拥有子菜单"},{value:1,label:"拥有子菜单"}],dialogOpe:{name:"菜单信息",status:0},dialogMenuVisible:!1,formLabelWidth:"120px"}},methods:{getMenuList:function(){var t=this;Object(a.l)(this.menuListReq).then(function(e){var n=e.code;100==n?(t.menuListData=e.data,t.page.totalNums=e.page.totalNums,t.page.totalPages=e.page.totalPages):t.$message.error(e.msg+"[错误码："+n+"]")})},addMenu:function(){var t=this;console.log(this.menu),Object(a.a)(this.menu).then(function(e){console.log(e);var n=e.code;100==n?(t.menuListData=e.data,t.getMenuList()):t.$message.error(e.msg+"[错误码："+n+"]"),t.dialogCancel()})},modifyMenu:function(){var t=this;Object(a.r)(this.menu).then(function(e){var n=e.code;100==n?(t.menuListData=e.data,t.getMenuList()):t.$message.error(e.msg+"[错误码："+n+"]"),t.dialogCancel()})},delMenu:function(t){var e=this;this.$confirm("此操作将永久删除该菜单以及相关数据，是否继续？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(a.f)({id:t}).then(function(t){var n=t.code;100==n?(e.$message({type:"success",message:"删除成功！"}),e.getMenuList()):e.$message.error(t.msg+"[错误码："+n+"]")})})},openMenuInfo:function(t){this.$router.push({path:"/app/menuInfo",query:{id:t.id}})},openAddMenu:function(){this.menu={},this.dialogOpe.name="新增字典",this.dialogOpe.status=1,this.dialogMenuVisible=!0},openModifyMenu:function(t){this.menu=t,this.dialogOpe.name="编辑字典",this.dialogOpe.status=2,this.dialogMenuVisible=!0},searchClick:function(){this.getMenuList()},dialogCancel:function(){this.dialogOpe.name="字典信息",this.dialogOpe.status=0,this.dialogMenuVisible=!1},dialogConfirm:function(t){switch(console.log(t),t){case 1:this.addMenu();break;case 2:this.modifyMenu();break;default:this.dialogCancel()}},handleCurrentChange:function(t){this.getMenuList()},handleSizeChange:function(t){this.menuListReq.size=t,this.getMenuList()}},created:function(){this.getMenuList()}}},278:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"manage-menu"},[n("div",[n("div",{staticClass:"a-admin-head"},[n("el-button",{staticStyle:{"margin-right":"15px"},attrs:{type:"primary"},on:{click:t.openAddMenu}},[t._v("新增")]),t._v(" "),n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"菜单名",icon:"search","on-icon-click":t.searchClick},model:{value:t.menuListReq.menuSearch,callback:function(e){t.$set(t.menuListReq,"menuSearch",e)},expression:"menuListReq.menuSearch"}})],1),t._v(" "),n("div",{staticClass:"a-admin-table"},[n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.menuListData,border:"","highlight-current-row":""}},[n("el-table-column",{attrs:{type:"index",width:"100"}}),t._v(" "),n("el-table-column",{attrs:{prop:"menuName",label:"菜单名称"}}),t._v(" "),n("el-table-column",{attrs:{prop:"menuUrl",label:"菜单路径"}}),t._v(" "),n("el-table-column",{attrs:{prop:"menuIcon",label:"菜单图标"}}),t._v(" "),n("el-table-column",{attrs:{label:"子菜单"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(0==e.row.menuSub?"不拥有":"拥有"))])]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"创建时间"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-icon",{attrs:{name:"time"}}),t._v(" "),n("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(t.$util.DateFormat(e.row.createTime,"yyyy-MM-dd hh:mm")))])]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",width:"250"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{size:"small"},on:{click:function(n){t.openModifyMenu(e.row)}}},[t._v("编辑")]),t._v(" "),1==e.row.menuSub?n("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(n){t.openMenuInfo(e.row)}}},[t._v("子菜单详情")]):t._e(),t._v(" "),n("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(n){t.delMenu(e.row.id)}}},[t._v("删除")])]}}])})],1)],1),t._v(" "),n("el-pagination",{attrs:{"current-page":t.menuListReq.current,"page-sizes":[10,20,50,100],"page-size":t.menuListReq.size,layout:"total, sizes, prev, pager, next",total:t.page.totalNums},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.menuListReq,"current",e)}}})],1),t._v(" "),n("div",[n("el-dialog",{attrs:{title:t.dialogOpe.name,visible:t.dialogMenuVisible},on:{"update:visible":function(e){t.dialogMenuVisible=e}}},[n("el-form",{attrs:{model:t.menu}},[n("el-form-item",{attrs:{label:"菜单名称：","label-width":t.formLabelWidth}},[n("el-input",{attrs:{"auto-complete":"off",placeholder:"10字以内"},model:{value:t.menu.menuName,callback:function(e){t.$set(t.menu,"menuName",e)},expression:"menu.menuName"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"菜单链接地址：","label-width":t.formLabelWidth}},[n("el-input",{attrs:{"auto-complete":"off",placeholder:"10字以内"},model:{value:t.menu.menuUrl,callback:function(e){t.$set(t.menu,"menuUrl",e)},expression:"menu.menuUrl"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"菜单图标：","label-width":t.formLabelWidth}},[n("el-input",{attrs:{"auto-complete":"off",placeholder:"10字以内"},model:{value:t.menu.menuIcon,callback:function(e){t.$set(t.menu,"menuIcon",e)},expression:"menu.menuIcon"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"子菜单：","label-width":t.formLabelWidth}},[n("el-select",{attrs:{placeholder:"请选择是否拥有子菜单"},model:{value:t.menu.menuSub,callback:function(e){t.$set(t.menu,"menuSub",e)},expression:"menu.menuSub"}},t._l(t.menuSubOptions,function(t){return n("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}))],1)],1),t._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:t.dialogCancel}},[t._v("取 消")]),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogConfirm(t.dialogOpe.status)}}},[t._v("确 定")])],1)],1)],1)])},u=[],i={render:a,staticRenderFns:u};e.a=i}});