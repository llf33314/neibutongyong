webpackJsonp([4],{144:function(e,t,a){function n(e){a(199)}var r=a(58)(a(165),a(218),n,"data-v-78d14c41",null);e.exports=r.exports},148:function(e,t,a){"use strict";a.d(t,"o",function(){return s}),a.d(t,"r",function(){return o}),a.d(t,"s",function(){return i}),a.d(t,"t",function(){return l}),a.d(t,"u",function(){return u}),a.d(t,"p",function(){return c}),a.d(t,"v",function(){return f}),a.d(t,"q",function(){return d}),a.d(t,"w",function(){return p}),a.d(t,"x",function(){return g}),a.d(t,"k",function(){return m}),a.d(t,"l",function(){return h}),a.d(t,"m",function(){return b}),a.d(t,"n",function(){return v}),a.d(t,"g",function(){return A}),a.d(t,"h",function(){return R}),a.d(t,"i",function(){return S}),a.d(t,"j",function(){return C}),a.d(t,"a",function(){return _}),a.d(t,"b",function(){return x}),a.d(t,"c",function(){return w}),a.d(t,"d",function(){return y}),a.d(t,"e",function(){return L}),a.d(t,"f",function(){return B});var n=a(15),r=window.INSIDE_BASE_URL,s=function(e){return n.a.post(r+"/app/user/listByPage",e).then(function(e){return e.data})},o=function(e){return n.a.post(r+"/app/user/add",e).then(function(e){return e.data})},i=function(e){return n.a.post(r+"/app/user/restPwd",e).then(function(e){return e.data})},l=function(e){return n.a.post(r+"/app/user/disable",e).then(function(e){return e.data})},u=function(e){return n.a.post(r+"/app/user/del",e).then(function(e){return e.data})},c=function(e){return n.a.post(r+"/app/user/listStaffByPage",e).then(function(e){return e.data})},f=function(e){return n.a.post(r+"/app/user/relationStaff",e).then(function(e){return e.data})},d=function(e){return n.a.post(r+"/app/user/listRoleByPage",e).then(function(e){return e.data})},p=function(e){return n.a.post(r+"/app/user/relationRole",e).then(function(e){return e.data})},g=function(e){return n.a.post(r+"/app/user/cancelRelationRole",e).then(function(e){return e.data})},m=function(e){return n.a.post(r+"/app/menu/listByPage",e).then(function(e){return e.data})},h=function(e){return n.a.post(r+"/app/menu/add",e).then(function(e){return e.data})},b=function(e){return n.a.post(r+"/app/menu/modify",e).then(function(e){return e.data})},v=function(e){return n.a.post(r+"/app/menu/del",e).then(function(e){return e.data})},A=function(e){return n.a.post(r+"/app/menu/listSubByPage",e).then(function(e){return e.data})},R=function(e){return n.a.post(r+"/app/menu/addSub",e).then(function(e){return e.data})},S=function(e){return n.a.post(r+"/app/menu/modifySub",e).then(function(e){return e.data})},C=function(e){return n.a.post(r+"/app/menu/delSub",e).then(function(e){return e.data})},_=function(e){return n.a.post(r+"/app/role/listByPage",e).then(function(e){return e.data})},x=function(e){return n.a.post(r+"/app/role/add",e).then(function(e){return e.data})},w=function(e){return n.a.post(r+"/app/role/modify",e).then(function(e){return e.data})},y=function(e){return n.a.post(r+"/app/role/del",e).then(function(e){return e.data})},L=function(e){return n.a.post(r+"/app/role/listMenu",e).then(function(e){return e.data})},B=function(e){return n.a.post(r+"/app/role/relationMenu",e).then(function(e){return e.data})}},165:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=a(148);t.default={data:function(){return{userListReq:{userSearch:"",userStatus:0,current:1,size:10},page:{totalNums:1,totalPages:1},userListData:[],dialogFormVisible:!1,dialogVisible:!1,formLabelWidth:"120px",userAddReq:{loginName:"",userName:"",password:""},dialogOpe:{status:0},statusOptions:[{value:"",label:"全部"},{value:0,label:"正常"},{value:1,label:"停用"}],userOpe:{},dialogStaffVisible:!1,userStaffListReq:{current:1,size:10},pageStaff:{totalNums:1,totalPages:1},userStaffListData:[],relationStaffBean:{userId:"",staffId:""},dialogRoleVisible:!1,userRoleListReq:{current:1,size:10,userId:""},pageRole:{totalNums:1,totalPages:1},userRoleListData:[],userRules:{loginName:[{required:!0,message:"请输入登录账号",trigger:"blur"},{min:3,max:15,message:"长度3~15个字符",trigger:"blur"}],userName:[{required:!0,message:"请选输入真实姓名",trigger:"blur"},{min:1,max:15,message:"长度不超过15个字符",trigger:"blur"}],password:[{required:!0,message:"请选输入密码",trigger:"blur"},{min:4,max:15,message:"长度4~15个字符",trigger:"blur"}]}}},methods:{getUserList:function(){var e=this;a.i(n.o)(this.userListReq).then(function(t){console.log(t);var a=t.code;100==a?(e.userListData=t.data,e.page.totalNums=t.page.totalNums,e.page.totalPages=t.page.totalPages):e.$message.error(t.msg+"[错误码："+a+"]")})},getUserStaffList:function(){var e=this;a.i(n.p)(this.userStaffListReq).then(function(t){console.log(t);var a=t.code;100==a?(e.userStaffListData=t.data,e.pageStaff.totalNums=t.page.totalNums,e.pageStaff.totalPages=t.page.totalPages):e.$message.error(t.msg+"[错误码："+a+"]")})},getUserRoleList:function(){var e=this;a.i(n.q)(this.userRoleListReq).then(function(t){console.log(t);var a=t.code;100==a?(e.userRoleListData=t.data,e.pageRole.totalNums=t.page.totalNums,e.pageRole.totalPages=t.page.totalPages):e.$message.error(t.msg+"[错误码："+a+"]")})},addUser:function(){var e=this;a.i(n.r)(this.userAddReq).then(function(t){console.log(t);var a=t.code;100==a?(e.$message({type:"success",message:"新增用户成功！"}),e.getUserList()):e.$message.error(t.msg+"[错误码："+a+"]")})},restPwd:function(e){var t=this;this.$confirm("是否重置该用户密码？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.i(n.s)({userId:e}).then(function(e){var a=e.code;100==a?t.$message({type:"success",message:"密码重置成功！默认密码：gt123456"}):t.$message.error(e.msg+"[错误码："+a+"]")})})},disableUser:function(e){var t=this;this.$confirm("是否停用用户？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.i(n.t)({userId:e}).then(function(e){var a=e.code;100==a?(t.$message({type:"success",message:"操作成功！"}),t.getUserList()):t.$message.error(e.msg+"[错误码："+a+"]")})})},delUser:function(e){var t=this;this.$confirm("删除用户后数据不可恢复，是否继续？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.i(n.u)({userId:e}).then(function(e){var a=e.code;100==a?(t.$message({type:"success",message:"删除成功！"}),t.getUserList()):t.$message.error(e.msg+"[错误码："+a+"]")})})},relationStaff:function(){var e=this;console.log(this.relationStaffBean),a.i(n.v)(this.relationStaffBean).then(function(t){var a=t.code;100==a?(e.$message({type:"success",message:"关联员工成功！"}),e.getUserList()):203==a?e.$message.error("该员工已关联其他用户！"):e.$message.error(t.msg+"[错误码："+a+"]")})},relationRole:function(e){var t=this,r=this.userRoleListReq.userId;this.$confirm("确定关联角色到该用户？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.i(n.w)({userId:r,roleId:e}).then(function(e){var a=e.code;100==a?(t.$message({type:"success",message:"关联成功！"}),t.getUserRoleList(),t.getUserList()):t.$message.error(e.msg+"[错误码："+a+"]")})})},cancelRelationRole:function(e){var t=this,r=this.userRoleListReq.userId;this.$confirm("确定取消关联角色到该用户？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.i(n.x)({userId:r,roleId:e}).then(function(e){var a=e.code;100==a?(t.$message({type:"success",message:"取消关联成功！"}),t.getUserRoleList(),t.getUserList()):t.$message.error(e.msg+"[错误码："+a+"]")})})},searchClick:function(){this.getUserList()},changeStatus:function(){this.getUserList()},openAddUser:function(){this.dialogOpe.name="新增用户",this.userAddReq={},this.dialogFormVisible=!0,this.dialogOpe.status=1},dialogConfirm:function(e){var t=this;this.$refs.userRules.validate(function(a){if(!a)return!1;1==e?(t.dialogFormVisible=!1,t.addUser()):2==e&&(t.dialogFormVisible=!1)})},handleCurrentChange:function(e){console.log("handleCurrentChange"),this.getUserList()},handleSizeChange:function(e){this.userListReq.size=e,console.log(this.userListReq.size),console.log("handleSizeChange"),this.getUserList()},relation:function(e){this.dialogVisible=!0,this.userOpe=e,this.relationStaffBean.userId=e.userId,this.userRoleListReq.userId=e.userId},toRelationStaff:function(){this.getUserStaffList(),this.dialogStaffVisible=!0,this.dialogVisible=!1},saveStaff:function(){this.relationStaff(),this.dialogStaffVisible=!1,this.dialogVisible=!1},handleStaffCurrentChange:function(e){this.getUserStaffList()},handleStaffSizeChange:function(e){this.userStaffListReq.size=e,this.getUserStaffList()},handleStaffTableChange:function(e){console.log(e),null!=e&&(this.relationStaffBean.staffId=e.id,this.userOpe.staffName=e.staffName)},toRelationRole:function(){this.getUserRoleList(),this.dialogRoleVisible=!0,this.dialogVisible=!1},handleRoleCurrentChange:function(e){this.getUserRoleList()},handleRoleSizeChange:function(e){this.userRoleListReq.size=e,this.getUserRoleList()}},created:function(){this.getUserList()}}},183:function(e,t,a){t=e.exports=a(129)(!0),t.push([e.i,".a-gt-user[data-v-78d14c41]{padding:25px}.el-dialog[data-v-78d14c41]{position:absolute;left:56%;-webkit-transform:translateX(-50%);transform:translateX(-50%);background:#fff;border-radius:2px;-webkit-box-shadow:0 1px 3px rgba(0,0,0,.3);box-shadow:0 1px 3px rgba(0,0,0,.3);-webkit-box-sizing:border-box;box-sizing:border-box;margin-bottom:32px;margin-left:0;top:32%!important}.el-dialog--small[data-v-78d14c41]{width:55%}.el-pagination[data-v-78d14c41]{white-space:nowrap;padding:25px 5px;color:#48576a;text-align:right}.yong[data-v-78d14c41]{width:55%;left:30%;top:12%}","",{version:3,sources:["E:/workspaceIDEA/gt_inside_general/cli-pc/src/components/manage/vue/user.vue"],names:[],mappings:"AACA,4BACE,YAAc,CACf,AACD,4BACE,kBAAmB,AACnB,SAAU,AACV,mCAAoC,AACpC,2BAA4B,AAC5B,gBAAiB,AACjB,kBAAmB,AACnB,4CAAiD,AACjD,oCAAyC,AACzC,8BAA+B,AAC/B,sBAAuB,AACvB,mBAAoB,AACpB,cAAiB,AACjB,iBAAoB,CACrB,AACD,mCACE,SAAW,CACZ,AACD,gCACE,mBAAoB,AACpB,iBAAkB,AAClB,cAAe,AACf,gBAAkB,CACnB,AACD,uBACE,UAAW,AACX,SAAU,AACV,OAAS,CACV",file:"user.vue",sourcesContent:["\n.a-gt-user[data-v-78d14c41] {\r\n  padding: 25px;\n}\n.el-dialog[data-v-78d14c41] {\r\n  position: absolute;\r\n  left: 56%;\r\n  -webkit-transform: translateX(-50%);\r\n  transform: translateX(-50%);\r\n  background: #fff;\r\n  border-radius: 2px;\r\n  -webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);\r\n  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);\r\n  -webkit-box-sizing: border-box;\r\n  box-sizing: border-box;\r\n  margin-bottom: 32px;\r\n  margin-left: 0px;\r\n  top: 32% !important;\n}\n.el-dialog--small[data-v-78d14c41] {\r\n  width: 55%;\n}\n.el-pagination[data-v-78d14c41] {\r\n  white-space: nowrap;\r\n  padding: 25px 5px;\r\n  color: #48576a;\r\n  text-align: right;\n}\n.yong[data-v-78d14c41] {\r\n  width: 55%;\r\n  left: 30%;\r\n  top: 12%;\n}\r\n"],sourceRoot:""}])},199:function(e,t,a){var n=a(183);"string"==typeof n&&(n=[[e.i,n,""]]),n.locals&&(e.exports=n.locals);a(130)("16150290",n,!0)},218:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"a-gt-user"},[a("div",[a("div",{staticStyle:{"margin-bottom":"20px"}},[a("el-button",{staticStyle:{"margin-right":"15px"},attrs:{type:"primary"},on:{click:e.openAddUser}},[e._v("新增")]),e._v(" "),a("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"登录账号/真实姓名",icon:"search","on-icon-click":e.searchClick},model:{value:e.userListReq.userSearch,callback:function(t){e.$set(e.userListReq,"userSearch",t)},expression:"userListReq.userSearch"}}),e._v(" "),a("el-select",{staticStyle:{width:"80px!important"},on:{change:e.changeStatus},model:{value:e.userListReq.userStatus,callback:function(t){e.$set(e.userListReq,"userStatus",t)},expression:"userListReq.userStatus"}},e._l(e.statusOptions,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),e._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.userListData,border:"","highlight-current-row":""}},[a("el-table-column",{attrs:{type:"index",width:"50"}}),e._v(" "),a("el-table-column",{attrs:{prop:"loginName",label:"登录账号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"userName",label:"真实姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"staffName",label:"员工姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"userStatus",label:"状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n             "+e._s(0==t.row.userStatus?"正常":"停用")+"\n           ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-icon",{attrs:{name:"createTime"}}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e.$util.DateFormat(t.row.createTime,"yyyy-MM-dd hh:mm")))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"350"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(a){e.relation(t.row)}}},[e._v("关联")]),e._v(" "),a("el-button",{attrs:{size:"small"},on:{click:function(a){e.restPwd(t.row.userId)}}},[e._v("重置密码")]),e._v(" "),a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){e.disableUser(t.row.userId)}}},[e._v("停用")]),e._v(" "),a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){e.delUser(t.row.userId)}}},[e._v("删除")])]}}])})],1)],1),e._v(" "),a("el-pagination",{attrs:{"current-page":e.userListReq.current,"page-sizes":[10,20,50,100],"page-size":e.userListReq.size,layout:"total, sizes, prev, pager, next",total:e.page.totalNums},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.userListReq,"current",t)}}})],1),e._v(" "),a("div",[a("el-dialog",{attrs:{title:e.dialogOpe.name,visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"userRules",attrs:{model:e.userAddReq,rules:e.userRules}},[a("el-form-item",{attrs:{label:"登录账号：",prop:"loginName","label-width":e.formLabelWidth}},[a("el-input",{attrs:{"auto-complete":"off",placeholder:"请输入3到15字的登录账号"},model:{value:e.userAddReq.loginName,callback:function(t){e.$set(e.userAddReq,"loginName",t)},expression:"userAddReq.loginName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"真实姓名：",prop:"userName","label-width":e.formLabelWidth}},[a("el-input",{attrs:{"auto-complete":"off",placeholder:"请输入15字以内的真实姓名"},model:{value:e.userAddReq.userName,callback:function(t){e.$set(e.userAddReq,"userName",t)},expression:"userAddReq.userName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"密码：",prop:"password","label-width":e.formLabelWidth}},[a("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"请输入4到15字的密码"},model:{value:e.userAddReq.password,callback:function(t){e.$set(e.userAddReq,"password",t)},expression:"userAddReq.password"}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogConfirm(e.dialogOpe.status)}}},[e._v("确 定")])],1)],1)],1),e._v(" "),a("div",[a("el-dialog",{staticClass:"yong",attrs:{title:"关联信息",visible:e.dialogVisible},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-button",{attrs:{type:"primary"},on:{click:e.toRelationStaff}},[e._v("关联员工")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.toRelationRole}},[e._v("关联角色")]),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("确 定")])],1)],1)],1),e._v(" "),a("div",[a("el-dialog",{attrs:{title:"关联员工",visible:e.dialogStaffVisible},on:{"update:visible":function(t){e.dialogStaffVisible=t}}},[a("el-table",{attrs:{data:e.userStaffListData,"highlight-current-row":""},on:{"current-change":e.handleStaffTableChange}},[a("el-table-column",{attrs:{prop:"staffName",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"staffEnName",label:"英文名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"staffCode",label:"编号"}})],1),e._v(" "),a("el-pagination",{attrs:{"current-page":e.userStaffListReq.current,"page-sizes":[10,20,50,100],"page-size":e.userStaffListReq.size,layout:"total, sizes, prev, pager, next",total:e.pageStaff.totalNums},on:{"size-change":e.handleStaffSizeChange,"current-change":e.handleStaffCurrentChange,"update:currentPage":function(t){e.$set(e.userStaffListReq,"current",t)}}}),e._v(" "),a("span",{directives:[{name:"show",rawName:"v-show",value:null!=e.userOpe.staffName,expression:"userOpe.staffName != null"}]},[e._v("当前关联的员工："+e._s(e.userOpe.staffName))]),e._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:null!=e.userOpe.staffName,expression:"userOpe.staffName != null"}],staticStyle:{"margin-left":"15px","margin-top":"25px"},attrs:{type:"primary"},on:{click:e.saveStaff}},[e._v("保存选择")])],1)],1),e._v(" "),a("div",[a("el-dialog",{attrs:{title:"关联角色",visible:e.dialogRoleVisible},on:{"update:visible":function(t){e.dialogRoleVisible=t}}},[a("el-table",{attrs:{data:e.userRoleListData,"highlight-current-row":""},on:{"current-change":e.handleStaffTableChange}},[a("el-table-column",{attrs:{prop:"roleName",label:"角色名"}}),e._v(" "),a("el-table-column",{attrs:{label:"角色权限"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n             "+e._s(0==t.row.rolePower?"正常":"最高权限")+"\n           ")]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"roleRemark",label:"角色描述"}}),e._v(" "),a("el-table-column",{attrs:{label:"关联角色"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n             "+e._s(0==t.row.userHas?"已关联":"未关联")+"\n           ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[1==t.row.userHas?a("el-button",{attrs:{size:"small"},on:{click:function(a){e.relationRole(t.row.roleId)}}},[e._v("关联")]):e._e(),e._v(" "),0==t.row.userHas?a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){e.cancelRelationRole(t.row.roleId)}}},[e._v("取消关联")]):e._e()]}}])})],1),e._v(" "),a("el-pagination",{attrs:{"current-page":e.userRoleListReq.current,"page-sizes":[10,20,50,100],"page-size":e.userRoleListReq.size,layout:"total, sizes, prev, pager, next",total:e.pageRole.totalNums},on:{"size-change":e.handleRoleSizeChange,"current-change":e.handleRoleCurrentChange,"update:currentPage":function(t){e.$set(e.userRoleListReq,"current",t)}}})],1)],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=4.189d74d9609fe46a181a.js.map