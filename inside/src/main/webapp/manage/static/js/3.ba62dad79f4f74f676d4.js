webpackJsonp([3],{145:function(t,e,n){function a(t){n(198)}var s=n(58)(n(166),n(217),a,"data-v-78d14c41",null);t.exports=s.exports},148:function(t,e,n){"use strict";n.d(e,"o",function(){return r}),n.d(e,"r",function(){return o}),n.d(e,"s",function(){return i}),n.d(e,"t",function(){return l}),n.d(e,"u",function(){return u}),n.d(e,"p",function(){return c}),n.d(e,"v",function(){return f}),n.d(e,"q",function(){return d}),n.d(e,"w",function(){return p}),n.d(e,"x",function(){return g}),n.d(e,"k",function(){return h}),n.d(e,"l",function(){return m}),n.d(e,"m",function(){return b}),n.d(e,"n",function(){return v}),n.d(e,"g",function(){return A}),n.d(e,"h",function(){return R}),n.d(e,"i",function(){return S}),n.d(e,"j",function(){return C}),n.d(e,"a",function(){return _}),n.d(e,"b",function(){return x}),n.d(e,"c",function(){return y}),n.d(e,"d",function(){return L}),n.d(e,"e",function(){return w}),n.d(e,"f",function(){return B});var a=n(15),s=window.INSIDE_BASE_URL,r=function(t){return a.a.post(s+"/app/user/listByPage",t).then(function(t){return t.data})},o=function(t){return a.a.post(s+"/app/user/add",t).then(function(t){return t.data})},i=function(t){return a.a.post(s+"/app/user/restPwd",t).then(function(t){return t.data})},l=function(t){return a.a.post(s+"/app/user/disable",t).then(function(t){return t.data})},u=function(t){return a.a.post(s+"/app/user/del",t).then(function(t){return t.data})},c=function(t){return a.a.post(s+"/app/user/listStaffByPage",t).then(function(t){return t.data})},f=function(t){return a.a.post(s+"/app/user/relationStaff",t).then(function(t){return t.data})},d=function(t){return a.a.post(s+"/app/user/listRoleByPage",t).then(function(t){return t.data})},p=function(t){return a.a.post(s+"/app/user/relationRole",t).then(function(t){return t.data})},g=function(t){return a.a.post(s+"/app/user/cancelRelationRole",t).then(function(t){return t.data})},h=function(t){return a.a.post(s+"/app/menu/listByPage",t).then(function(t){return t.data})},m=function(t){return a.a.post(s+"/app/menu/add",t).then(function(t){return t.data})},b=function(t){return a.a.post(s+"/app/menu/modify",t).then(function(t){return t.data})},v=function(t){return a.a.post(s+"/app/menu/del",t).then(function(t){return t.data})},A=function(t){return a.a.post(s+"/app/menu/listSubByPage",t).then(function(t){return t.data})},R=function(t){return a.a.post(s+"/app/menu/addSub",t).then(function(t){return t.data})},S=function(t){return a.a.post(s+"/app/menu/modifySub",t).then(function(t){return t.data})},C=function(t){return a.a.post(s+"/app/menu/delSub",t).then(function(t){return t.data})},_=function(t){return a.a.post(s+"/app/role/listByPage",t).then(function(t){return t.data})},x=function(t){return a.a.post(s+"/app/role/add",t).then(function(t){return t.data})},y=function(t){return a.a.post(s+"/app/role/modify",t).then(function(t){return t.data})},L=function(t){return a.a.post(s+"/app/role/del",t).then(function(t){return t.data})},w=function(t){return a.a.post(s+"/app/role/listMenu",t).then(function(t){return t.data})},B=function(t){return a.a.post(s+"/app/role/relationMenu",t).then(function(t){return t.data})}},166:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n(148);e.default={data:function(){return{userListReq:{userSearch:"",userStatus:0,current:1,size:10},page:{totalNums:1,totalPages:1},userListData:[],dialogFormVisible:!1,dialogVisible:!1,formLabelWidth:"120px",userAddReq:{loginName:"",userName:"",password:""},dialogOpe:{status:0},statusOptions:[{value:"",label:"全部"},{value:0,label:"正常"},{value:1,label:"停用"}],userOpe:{},dialogStaffVisible:!1,userStaffListReq:{current:1,size:10},pageStaff:{totalNums:1,totalPages:1},userStaffListData:[],relationStaffBean:{userId:"",staffId:""},dialogRoleVisible:!1,userRoleListReq:{current:1,size:10,userId:""},pageRole:{totalNums:1,totalPages:1},userRoleListData:[]}},methods:{getUserList:function(){var t=this;n.i(a.o)(this.userListReq).then(function(e){console.log(e);var n=e.code;100==n?(t.userListData=e.data,t.page.totalNums=e.page.totalNums,t.page.totalPages=e.page.totalPages):t.$message.error(e.msg+"[错误码："+n+"]")})},getUserStaffList:function(){var t=this;n.i(a.p)(this.userStaffListReq).then(function(e){console.log(e);var n=e.code;100==n?(t.userStaffListData=e.data,t.pageStaff.totalNums=e.page.totalNums,t.pageStaff.totalPages=e.page.totalPages):t.$message.error(e.msg+"[错误码："+n+"]")})},getUserRoleList:function(){var t=this;n.i(a.q)(this.userRoleListReq).then(function(e){console.log(e);var n=e.code;100==n?(t.userRoleListData=e.data,t.pageRole.totalNums=e.page.totalNums,t.pageRole.totalPages=e.page.totalPages):t.$message.error(e.msg+"[错误码："+n+"]")})},addUser:function(){var t=this;n.i(a.r)(this.userAddReq).then(function(e){console.log(e);var n=e.code;100==n?(t.$message({type:"success",message:"新增用户成功！"}),t.getUserList()):t.$message.error(e.msg+"[错误码："+n+"]")})},restPwd:function(t){var e=this;this.$confirm("是否重置该用户密码？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.i(a.s)({userId:t}).then(function(t){var n=t.code;100==n?e.$message({type:"success",message:"密码重置成功！默认密码：gt123456"}):e.$message.error(t.msg+"[错误码："+n+"]")})})},disableUser:function(t){var e=this;this.$confirm("是否停用用户？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.i(a.t)({userId:t}).then(function(t){var n=t.code;100==n?(e.$message({type:"success",message:"操作成功！"}),e.getUserList()):e.$message.error(t.msg+"[错误码："+n+"]")})})},delUser:function(t){var e=this;this.$confirm("删除用户后数据不可恢复，是否继续？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.i(a.u)({userId:t}).then(function(t){var n=t.code;100==n?(e.$message({type:"success",message:"删除成功！"}),e.getUserList()):e.$message.error(t.msg+"[错误码："+n+"]")})})},relationStaff:function(){var t=this;console.log(this.relationStaffBean),n.i(a.v)(this.relationStaffBean).then(function(e){var n=e.code;100==n?(t.$message({type:"success",message:"关联员工成功！"}),t.getUserList()):203==n?t.$message.error("该员工已关联其他用户！"):t.$message.error(e.msg+"[错误码："+n+"]")})},relationRole:function(t){var e=this,s=this.userRoleListReq.userId;this.$confirm("确定关联角色到该用户？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.i(a.w)({userId:s,roleId:t}).then(function(t){var n=t.code;100==n?(e.$message({type:"success",message:"关联成功！"}),e.getUserRoleList()):e.$message.error(t.msg+"[错误码："+n+"]")})})},cancelRelationRole:function(t){var e=this,s=this.userRoleListReq.userId;this.$confirm("确定取消关联角色到该用户？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.i(a.x)({userId:s,roleId:t}).then(function(t){var n=t.code;100==n?(e.$message({type:"success",message:"取消关联成功！"}),e.getUserRoleList()):e.$message.error(t.msg+"[错误码："+n+"]")})})},searchClick:function(){this.getUserList()},changeStatus:function(){this.getUserList()},openAddUser:function(){this.dialogOpe.name="新增用户",this.userAddReq={},this.dialogFormVisible=!0,this.dialogOpe.status=1},dialogConfirm:function(t){1==t?(this.dialogFormVisible=!1,this.addUser()):2==t&&(this.dialogFormVisible=!1)},handleCurrentChange:function(t){console.log("handleCurrentChange"),this.getUserList()},handleSizeChange:function(t){this.userListReq.size=t,console.log(this.userListReq.size),console.log("handleSizeChange"),this.getUserList()},relation:function(t){this.dialogVisible=!0,this.userOpe=t,this.relationStaffBean.userId=t.userId,this.userRoleListReq.userId=t.userId},toRelationStaff:function(){this.getUserStaffList(),this.dialogStaffVisible=!0,this.dialogVisible=!1},saveStaff:function(){this.relationStaff(),this.dialogStaffVisible=!1,this.dialogVisible=!1},handleStaffCurrentChange:function(t){this.getUserStaffList()},handleStaffSizeChange:function(t){this.userStaffListReq.size=t,this.getUserStaffList()},handleStaffTableChange:function(t){console.log(t),null!=t&&(this.relationStaffBean.staffId=t.id,this.userOpe.staffName=t.staffName)},toRelationRole:function(){this.getUserRoleList(),this.dialogRoleVisible=!0,this.dialogVisible=!1},handleRoleCurrentChange:function(t){this.getUserRoleList()},handleRoleSizeChange:function(t){this.userRoleListReq.size=t,this.getUserRoleList()}},created:function(){this.getUserList()}}},182:function(t,e,n){e=t.exports=n(129)(!0),e.push([t.i,".a-gt-user[data-v-78d14c41]{padding:25px}.el-dialog[data-v-78d14c41]{position:absolute;left:56%;-webkit-transform:translateX(-50%);transform:translateX(-50%);background:#fff;border-radius:2px;-webkit-box-shadow:0 1px 3px rgba(0,0,0,.3);box-shadow:0 1px 3px rgba(0,0,0,.3);-webkit-box-sizing:border-box;box-sizing:border-box;margin-bottom:32px;margin-left:0;top:32%!important}.el-dialog--small[data-v-78d14c41]{width:55%}.el-pagination[data-v-78d14c41]{white-space:nowrap;padding:25px 5px;color:#48576a;text-align:right}.yong[data-v-78d14c41]{width:55%;left:30%;top:12%}","",{version:3,sources:["E:/workspaceIDEA/gt_inside_general/cli-pc/src/components/manage/vue/user.vue"],names:[],mappings:"AACA,4BACE,YAAc,CACf,AACD,4BACE,kBAAmB,AACnB,SAAU,AACV,mCAAoC,AACpC,2BAA4B,AAC5B,gBAAiB,AACjB,kBAAmB,AACnB,4CAA6C,AAC7C,oCAAqC,AACrC,8BAA+B,AAC/B,sBAAuB,AACvB,mBAAoB,AACpB,cAAiB,AACjB,iBAAoB,CACrB,AACD,mCACE,SAAW,CACZ,AACD,gCACE,mBAAoB,AACpB,iBAAkB,AAClB,cAAe,AACf,gBAAkB,CACnB,AACD,uBACE,UAAW,AACX,SAAU,AACV,OAAS,CACV",file:"user.vue",sourcesContent:["\n.a-gt-user[data-v-78d14c41] {\n  padding: 25px;\n}\n.el-dialog[data-v-78d14c41] {\n  position: absolute;\n  left: 56%;\n  -webkit-transform: translateX(-50%);\n  transform: translateX(-50%);\n  background: #fff;\n  border-radius: 2px;\n  -webkit-box-shadow: 0 1px 3px rgba(0,0,0,.3);\n  box-shadow: 0 1px 3px rgba(0,0,0,.3);\n  -webkit-box-sizing: border-box;\n  box-sizing: border-box;\n  margin-bottom: 32px;\n  margin-left: 0px;\n  top: 32% !important;\n}\n.el-dialog--small[data-v-78d14c41] {\n  width: 55%;\n}\n.el-pagination[data-v-78d14c41] {\n  white-space: nowrap;\n  padding: 25px 5px;\n  color: #48576a;\n  text-align: right;\n}\n.yong[data-v-78d14c41]{\n  width: 55%;\n  left: 30%;\n  top: 12%;\n}\n"],sourceRoot:""}])},198:function(t,e,n){var a=n(182);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);n(130)("16150290",a,!0)},217:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"a-gt-user"},[n("div",[n("div",{staticStyle:{"margin-bottom":"20px"}},[n("el-button",{staticStyle:{"margin-right":"15px"},attrs:{type:"primary"},on:{click:t.openAddUser}},[t._v("新增")]),t._v(" "),n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"登录名/真实姓名",icon:"search","on-icon-click":t.searchClick},model:{value:t.userListReq.userSearch,callback:function(e){t.$set(t.userListReq,"userSearch",e)},expression:"userListReq.userSearch"}}),t._v(" "),n("el-select",{staticStyle:{width:"80px!important"},on:{change:t.changeStatus},model:{value:t.userListReq.userStatus,callback:function(e){t.$set(t.userListReq,"userStatus",e)},expression:"userListReq.userStatus"}},t._l(t.statusOptions,function(t){return n("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}))],1),t._v(" "),n("div",[n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.userListData,border:"","highlight-current-row":""}},[n("el-table-column",{attrs:{type:"index",width:"50"}}),t._v(" "),n("el-table-column",{attrs:{prop:"loginName",label:"登录名"}}),t._v(" "),n("el-table-column",{attrs:{prop:"userName",label:"真实姓名"}}),t._v(" "),n("el-table-column",{attrs:{prop:"staffName",label:"员工姓名"}}),t._v(" "),n("el-table-column",{attrs:{prop:"userStatus",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n             "+t._s(0==e.row.userStatus?"正常":"停用")+"\n           ")]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"创建时间"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-icon",{attrs:{name:"createTime"}}),t._v(" "),n("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(t.$util.DateFormat(e.row.createTime,"yyyy-MM-dd hh:mm")))])]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",width:"350"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(n){t.relation(e.row)}}},[t._v("关联")]),t._v(" "),n("el-button",{attrs:{size:"small"},on:{click:function(n){t.restPwd(e.row.userId)}}},[t._v("重置密码")]),t._v(" "),n("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(n){t.disableUser(e.row.userId)}}},[t._v("停用")]),t._v(" "),n("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(n){t.delUser(e.row.userId)}}},[t._v("删除")])]}}])})],1)],1),t._v(" "),n("el-pagination",{attrs:{"current-page":t.userListReq.current,"page-sizes":[10,20,50,100],"page-size":t.userListReq.size,layout:"total, sizes, prev, pager, next",total:t.page.totalNums},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.userListReq,"current",e)}}})],1),t._v(" "),n("div",[n("el-dialog",{attrs:{title:t.dialogOpe.name,visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[n("el-form",{attrs:{model:t.userAddReq}},[n("el-form-item",{attrs:{label:"登录名：","label-width":t.formLabelWidth}},[n("el-input",{attrs:{"auto-complete":"off"},model:{value:t.userAddReq.loginName,callback:function(e){t.$set(t.userAddReq,"loginName",e)},expression:"userAddReq.loginName"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"真实姓名：","label-width":t.formLabelWidth}},[n("el-input",{attrs:{"auto-complete":"off"},model:{value:t.userAddReq.userName,callback:function(e){t.$set(t.userAddReq,"userName",e)},expression:"userAddReq.userName"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"密码：","label-width":t.formLabelWidth}},[n("el-input",{attrs:{type:"password","auto-complete":"off"},model:{value:t.userAddReq.password,callback:function(e){t.$set(t.userAddReq,"password",e)},expression:"userAddReq.password"}})],1)],1),t._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")]),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogConfirm(t.dialogOpe.status)}}},[t._v("确 定")])],1)],1)],1),t._v(" "),n("div",[n("el-dialog",{staticClass:"yong",attrs:{title:"关联信息",visible:t.dialogVisible},on:{"update:visible":function(e){t.dialogVisible=e}}},[n("el-button",{attrs:{type:"primary"},on:{click:t.toRelationStaff}},[t._v("关联员工")]),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:t.toRelationRole}},[t._v("关联角色")]),t._v(" "),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("确 定")])],1)],1)],1),t._v(" "),n("div",[n("el-dialog",{attrs:{title:"关联员工",visible:t.dialogStaffVisible},on:{"update:visible":function(e){t.dialogStaffVisible=e}}},[n("el-table",{attrs:{data:t.userStaffListData,"highlight-current-row":""},on:{"current-change":t.handleStaffTableChange}},[n("el-table-column",{attrs:{prop:"staffName",label:"姓名"}}),t._v(" "),n("el-table-column",{attrs:{prop:"staffEnName",label:"英文名"}}),t._v(" "),n("el-table-column",{attrs:{prop:"staffCode",label:"编号"}})],1),t._v(" "),n("el-pagination",{attrs:{"current-page":t.userStaffListReq.current,"page-sizes":[10,20,50,100],"page-size":t.userStaffListReq.size,layout:"total, sizes, prev, pager, next",total:t.pageStaff.totalNums},on:{"size-change":t.handleStaffSizeChange,"current-change":t.handleStaffCurrentChange,"update:currentPage":function(e){t.$set(t.userStaffListReq,"current",e)}}}),t._v(" "),n("span",[t._v("当前关联的员工："+t._s(t.userOpe.staffName))]),t._v(" "),n("el-button",{staticStyle:{"margin-left":"15px","margin-top":"25px"},attrs:{type:"primary"},on:{click:t.saveStaff}},[t._v("保存选择")])],1)],1),t._v(" "),n("div",[n("el-dialog",{attrs:{title:"关联角色",visible:t.dialogRoleVisible},on:{"update:visible":function(e){t.dialogRoleVisible=e}}},[n("el-table",{attrs:{data:t.userRoleListData,"highlight-current-row":""},on:{"current-change":t.handleStaffTableChange}},[n("el-table-column",{attrs:{prop:"roleName",label:"角色名"}}),t._v(" "),n("el-table-column",{attrs:{label:"角色权限"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n             "+t._s(0==e.row.rolePower?"正常":"最高权限")+"\n           ")]}}])}),t._v(" "),n("el-table-column",{attrs:{prop:"roleRemark",label:"角色描述"}}),t._v(" "),n("el-table-column",{attrs:{label:"关联角色"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n             "+t._s(0==e.row.userHas?"已关联":"未关联")+"\n           ")]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[1==e.row.userHas?n("el-button",{attrs:{size:"small"},on:{click:function(n){t.relationRole(e.row.roleId)}}},[t._v("关联")]):t._e(),t._v(" "),0==e.row.userHas?n("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(n){t.cancelRelationRole(e.row.roleId)}}},[t._v("取消关联")]):t._e()]}}])})],1),t._v(" "),n("el-pagination",{attrs:{"current-page":t.userRoleListReq.current,"page-sizes":[10,20,50,100],"page-size":t.userRoleListReq.size,layout:"total, sizes, prev, pager, next",total:t.pageRole.totalNums},on:{"size-change":t.handleRoleSizeChange,"current-change":t.handleRoleCurrentChange,"update:currentPage":function(e){t.$set(t.userRoleListReq,"current",e)}}})],1)],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=3.ba62dad79f4f74f676d4.js.map