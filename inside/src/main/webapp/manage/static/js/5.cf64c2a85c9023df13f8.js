webpackJsonp([5],{217:function(e,t,n){"use strict";function a(e){n(283)}Object.defineProperty(t,"__esModule",{value:!0});var o=n(285),r=n(286),i=n(78),l=a,u=i(o.a,r.a,!1,l,null,null);t.default=u.exports},220:function(e,t,n){"use strict";n.d(t,"p",function(){return r}),n.d(t,"d",function(){return i}),n.d(t,"x",function(){return l}),n.d(t,"j",function(){return u}),n.d(t,"i",function(){return s}),n.d(t,"q",function(){return c}),n.d(t,"w",function(){return d}),n.d(t,"o",function(){return f}),n.d(t,"u",function(){return p}),n.d(t,"e",function(){return m}),n.d(t,"l",function(){return g}),n.d(t,"a",function(){return h}),n.d(t,"r",function(){return b}),n.d(t,"f",function(){return v}),n.d(t,"m",function(){return R}),n.d(t,"b",function(){return y}),n.d(t,"s",function(){return _}),n.d(t,"g",function(){return L}),n.d(t,"n",function(){return k}),n.d(t,"c",function(){return M}),n.d(t,"t",function(){return C}),n.d(t,"h",function(){return x}),n.d(t,"k",function(){return S}),n.d(t,"v",function(){return w});var a=n(46),o=window.INSIDE_BASE_URL,r=function(e){return a.a.post(o+"/app/user/listByPage",e).then(function(e){return e.data})},i=function(e){return a.a.post(o+"/app/user/add",e).then(function(e){return e.data})},l=function(e){return a.a.post(o+"/app/user/restPwd",e).then(function(e){return e.data})},u=function(e){return a.a.post(o+"/app/user/disable",e).then(function(e){return e.data})},s=function(e){return a.a.post(o+"/app/user/del",e).then(function(e){return e.data})},c=function(e){return a.a.post(o+"/app/user/listStaffByPage",e).then(function(e){return e.data})},d=function(e){return a.a.post(o+"/app/user/relationStaff",e).then(function(e){return e.data})},f=function(e){return a.a.post(o+"/app/user/listRoleByPage",e).then(function(e){return e.data})},p=function(e){return a.a.post(o+"/app/user/relationRole",e).then(function(e){return e.data})},m=function(e){return a.a.post(o+"/app/user/cancelRelationRole",e).then(function(e){return e.data})},g=function(e){return a.a.post(o+"/app/menu/listByPage",e).then(function(e){return e.data})},h=function(e){return a.a.post(o+"/app/menu/add",e).then(function(e){return e.data})},b=function(e){return a.a.post(o+"/app/menu/modify",e).then(function(e){return e.data})},v=function(e){return a.a.post(o+"/app/menu/del",e).then(function(e){return e.data})},R=function(e){return a.a.post(o+"/app/menu/listSubByPage",e).then(function(e){return e.data})},y=function(e){return a.a.post(o+"/app/menu/addSub",e).then(function(e){return e.data})},_=function(e){return a.a.post(o+"/app/menu/modifySub",e).then(function(e){return e.data})},L=function(e){return a.a.post(o+"/app/menu/delSub",e).then(function(e){return e.data})},k=function(e){return a.a.post(o+"/app/role/listByPage",e).then(function(e){return e.data})},M=function(e){return a.a.post(o+"/app/role/add",e).then(function(e){return e.data})},C=function(e){return a.a.post(o+"/app/role/modify",e).then(function(e){return e.data})},x=function(e){return a.a.post(o+"/app/role/del",e).then(function(e){return e.data})},S=function(e){return a.a.post(o+"/app/role/listMenu",e).then(function(e){return e.data})},w=function(e){return a.a.post(o+"/app/role/relationMenu",e).then(function(e){return e.data})}},283:function(e,t,n){var a=n(284);"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);n(202)("09f98810",a,!0)},284:function(e,t,n){t=e.exports=n(201)(!1),t.push([e.i,".manage-role .a-admin-head{padding:35px 0 35px 25px}.manage-role .a-admin-table{margin:0 20px 20px}.manage-role .el-pagination{float:right;margin-right:20px}",""])},285:function(e,t,n){"use strict";var a=n(220);t.a={data:function(){return{roleListReq:{roleSearch:"",current:1,size:10},page:{totalNums:1,totalPages:1},roleListData:[],role:{id:0,roleName:"",roleRemark:""},dialogOpe:{name:"角色信息",status:0},dialogRoleVisible:!1,formLabelWidth:"120px",menuListReq:{roleId:0},dialogMenuVisible:!1,menuListData:[],menuCheckData:[],roleMenuProps:{children:"menuSubDTOList",label:"menuName"},relationMenuReq:{roleId:0,menuIdList:[]},roleRules:{roleName:[{required:!0,message:"请输入角色名称",trigger:"blur"},{min:1,max:10,message:"长度不超过10个字符",trigger:"blur"}],roleRemark:[{required:!1,message:"请选输入角色描述",trigger:"blur"},{max:25,message:"长度不超过25个字符",trigger:"blur"}]}}},methods:{getRoleList:function(){var e=this;Object(a.n)(this.roleListReq).then(function(t){var n=t.code;100==n?(e.roleListData=t.data,e.page.totalNums=t.page.totalNums,e.page.totalPages=t.page.totalPages):e.$message.error(t.msg+"[错误码："+n+"]")})},addRole:function(){var e=this;console.log(this.role),Object(a.c)(this.role).then(function(t){console.log(t);var n=t.code;100==n?(e.$message({type:"success",message:"新增成功！"}),e.getRoleList()):e.$message.error(t.msg+"[错误码："+n+"]"),e.dialogCancel()})},modifyRole:function(){var e=this;Object(a.t)(this.role).then(function(t){var n=t.code;100==n?(e.$message({type:"success",message:"修改成功！"}),e.getRoleList()):e.$message.error(t.msg+"[错误码："+n+"]"),e.dialogCancel()})},delRole:function(e){var t=this;this.$confirm("此操作将永久删除该角色及其关联数据，是否继续？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(a.h)({id:e}).then(function(e){var n=e.code;100==n?(t.$message({type:"success",message:"删除成功！"}),t.getRoleList()):t.$message.error(e.msg+"[错误码："+n+"]")})})},getMenuList:function(){var e=this;Object(a.k)(this.menuListReq).then(function(t){console.log(t);var n=t.code;100==n?(e.menuListData=t.data.menuMainDTOList,e.menuCheckData=t.data.idList):e.$message.error(t.msg+"[错误码："+n+"]")})},relationMenu:function(){var e=this;Object(a.v)(this.relationMenuReq).then(function(t){var n=t.code;100==n?(e.$message({type:"success",message:"关联成功！"}),e.dialogMenuCancel()):e.$message.error(t.msg+"[错误码："+n+"]"),e.dialogCancel()})},openAddRole:function(){this.role={},this.dialogOpe.name="新增字典",this.dialogOpe.status=1,this.dialogRoleVisible=!0},openModifyRole:function(e){this.role=e,this.dialogOpe.name="编辑字典",this.dialogOpe.status=2,this.dialogRoleVisible=!0},searchClick:function(){this.getRoleList()},dialogCancel:function(){this.dialogOpe.name="字典信息",this.dialogOpe.status=0,this.dialogRoleVisible=!1},dialogConfirm:function(e){var t=this;this.$refs.roleRules.validate(function(n){if(!n)return!1;switch(e){case 1:t.addRole();break;case 2:t.modifyRole();break;default:t.dialogCancel()}})},handleCurrentChange:function(e){this.getRoleList()},handleSizeChange:function(e){this.roleListReq.size=e,this.getRoleList()},openRoleMenu:function(e){this.menuListReq.roleId=e.id,this.relationMenuReq.roleId=e.id,this.getMenuList(),this.dialogMenuVisible=!0},dialogMenuConfirm:function(){this.relationMenuReq.menuIdList=this.$refs.menuTree.getCheckedKeys(),console.log(this.relationMenuReq.menuIdList),this.relationMenu()},dialogMenuCancel:function(){this.dialogMenuVisible=!1}},created:function(){this.getRoleList()}}},286:function(e,t,n){"use strict";var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"manage-role"},[n("div",[n("div",{staticClass:"a-admin-head"},[n("el-button",{staticStyle:{"margin-right":"15px"},attrs:{type:"primary"},on:{click:e.openAddRole}},[e._v("新增")]),e._v(" "),n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"角色名",icon:"search","on-icon-click":e.searchClick},model:{value:e.roleListReq.roleSearch,callback:function(t){e.$set(e.roleListReq,"roleSearch",t)},expression:"roleListReq.roleSearch"}})],1),e._v(" "),n("div",{staticClass:"a-admin-table"},[n("el-table",{staticStyle:{width:"100%"},attrs:{data:e.roleListData,border:"","highlight-current-row":""}},[n("el-table-column",{attrs:{type:"index",width:"100"}}),e._v(" "),n("el-table-column",{attrs:{prop:"roleName",label:"角色名称"}}),e._v(" "),n("el-table-column",{attrs:{prop:"roleRemark",label:"角色描述"}}),e._v(" "),n("el-table-column",{attrs:{label:"角色权限"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(0==t.row.rolePower?"普通":"最高权限"))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"创建时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-icon",{attrs:{name:"time"}}),e._v(" "),n("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e.$util.DateFormat(t.row.createTime,"yyyy-MM-dd hh:mm")))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"操作",width:"250"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{size:"small"},on:{click:function(n){e.openModifyRole(t.row)}}},[e._v("编辑")]),e._v(" "),n("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(n){e.openRoleMenu(t.row)}}},[e._v("关联菜单")]),e._v(" "),n("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(n){e.delRole(t.row.id)}}},[e._v("删除")])]}}])})],1)],1),e._v(" "),n("el-pagination",{attrs:{"current-page":e.roleListReq.current,"page-sizes":[10,20,50,100],"page-size":e.roleListReq.size,layout:"total, sizes, prev, pager, next",total:e.page.totalNums},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.roleListReq,"current",t)}}})],1),e._v(" "),n("div",[n("el-dialog",{attrs:{title:e.dialogOpe.name,visible:e.dialogRoleVisible},on:{"update:visible":function(t){e.dialogRoleVisible=t}}},[n("el-form",{ref:"roleRules",attrs:{model:e.role,rules:e.roleRules}},[n("el-form-item",{attrs:{label:"角色名称：",prop:"roleName","label-width":e.formLabelWidth}},[n("el-input",{attrs:{"auto-complete":"off",placeholder:"请输入10字以内的角色名称"},model:{value:e.role.roleName,callback:function(t){e.$set(e.role,"roleName",t)},expression:"role.roleName"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"角色描述：",prop:"roleRemark","label-width":e.formLabelWidth}},[n("el-input",{attrs:{type:"textarea","auto-complete":"off",placeholder:"请输入25字以内的角色描述"},model:{value:e.role.roleRemark,callback:function(t){e.$set(e.role,"roleRemark",t)},expression:"role.roleRemark"}})],1)],1),e._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:e.dialogCancel}},[e._v("取 消")]),e._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogConfirm(e.dialogOpe.status)}}},[e._v("确 定")])],1)],1)],1),e._v(" "),n("div",[n("el-dialog",{attrs:{title:"关联菜单",visible:e.dialogMenuVisible},on:{"update:visible":function(t){e.dialogMenuVisible=t}}},[n("el-tree",{ref:"menuTree",attrs:{data:e.menuListData,"show-checkbox":"",props:e.roleMenuProps,"default-expand-all":"","node-key":"id","default-checked-keys":e.menuCheckData}}),e._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:e.dialogMenuCancel}},[e._v("取 消")]),e._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:e.dialogMenuConfirm}},[e._v("确 定")])],1)],1)],1)])},o=[],r={render:a,staticRenderFns:o};t.a=r}});