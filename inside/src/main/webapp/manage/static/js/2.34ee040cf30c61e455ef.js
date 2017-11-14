webpackJsonp([2],{146:function(t,e,a){function s(t){a(194)}var i=a(58)(a(167),a(213),s,null,null);t.exports=i.exports},167:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=a(169);e.default={data:function(){return{staffListReq:{staffSearch:"",staffStatus:0,current:1,size:10},page:{totalNums:1,totalPages:1},staffListData:[],staff:{id:0,staffCode:0,staffName:"",staffPhone:"",staffJoinTime:""},dialogOpe:{name:"员工信息",status:0},dialogStaffVisible:!1,formLabelWidth:"120px",statusOptions:[{value:"",label:"全部"},{value:0,label:"在职"},{value:1,label:"离职"}],departmentListData:[],staffRules:{staffName:[{required:!0,message:"请输入名称",trigger:"blur"},{min:1,max:8,message:"长度不超过8个字符",trigger:"blur"}],staffEnName:[{required:!1,message:"请输入英文名",trigger:"blur"},{min:1,max:15,message:"长度不超过15个字符",trigger:"blur"}],staffCode:[{required:!0,message:"请输入员工编号",trigger:"blur"},{min:1,max:15,message:"长度不超过15个字符",trigger:"blur"}],staffPhone:[{required:!0,message:"请选输入电话",trigger:"blur"},{min:1,max:15,message:"长度不超过15个字符",trigger:"blur"}]}}},methods:{getStaffList:function(){var t=this;a.i(s.a)(this.staffListReq).then(function(e){console.log(e);var a=e.code;100==a?(t.staffListData=e.data,t.page.totalNums=e.page.totalNums,t.page.totalPages=e.page.totalPages):t.$message.error(e.msg+"[错误码："+a+"]")})},addStaff:function(){var t=this;console.log(this.staff),a.i(s.b)(this.staff).then(function(e){console.log(e);var a=e.code;100==a?(t.staffListData=e.data,t.getStaffList()):t.$message.error(e.msg+"[错误码："+a+"]"),t.dialogCancel()})},modifyStaff:function(){var t=this;a.i(s.c)(this.staff).then(function(e){var a=e.code;100==a?(t.staffListData=e.data,t.getStaffList()):t.$message.error(e.msg+"[错误码："+a+"]"),t.dialogCancel()})},delStaff:function(t){var e=this;this.$confirm("此操作将永久删除该员工数据，是否继续？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.i(s.d)({id:t}).then(function(t){var a=t.code;100==a?(e.$message({type:"success",message:"您已删除该员工！"}),e.getStaffList()):e.$message.error(t.msg+"[错误码："+a+"]")})})},quitStaff:function(t){var e=this;this.$confirm("离职员工？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.i(s.e)({id:t}).then(function(t){var a=t.code;100==a?(e.$message({type:"success",message:"操作成功！"}),e.getStaffList()):e.$message.error(t.msg+"[错误码："+a+"]")})})},getDepartmentList:function(){var t=this;a.i(s.f)().then(function(e){var a=e.code;100==a?t.departmentListData=e.data:t.$message.error(e.msg+"[错误码："+a+"]")})},openAddStaff:function(){this.staff={},this.dialogOpe.name="新增员工",this.dialogOpe.status=1,this.dialogStaffVisible=!0,this.departmentListData=[],this.getDepartmentList()},openModifyStaff:function(t){this.staff=t,this.dialogOpe.name="编辑员工",this.dialogOpe.status=2,this.departmentListData=[],this.getDepartmentList(),this.dialogStaffVisible=!0},searchClick:function(){this.getStaffList()},dialogCancel:function(){this.dialogOpe.name="员工信息",this.dialogOpe.status=0,this.dialogStaffVisible=!1},dialogConfirm:function(t){var e=this;this.$refs.staffRules.validate(function(a){if(!a)return!1;switch(t){case 1:e.addStaff();break;case 2:e.modifyStaff();break;default:e.dialogCancel()}})},handleCurrentChange:function(t){this.getStaffList()},handleSizeChange:function(t){this.staffListReq.size=t,console.log(this.staffListReq.size),this.getStaffList()}},created:function(){this.getStaffList()},watch:{"staffListReq.staffStatus":function(t){this.getStaffList()}}}},169:function(t,e,a){"use strict";a.d(e,"a",function(){return n}),a.d(e,"b",function(){return f}),a.d(e,"c",function(){return o}),a.d(e,"d",function(){return r}),a.d(e,"e",function(){return l}),a.d(e,"f",function(){return u});var s=a(15),i=window.INSIDE_BASE_URL,n=function(t){return s.a.post(i+"/app/staff/listByPage",t).then(function(t){return t.data})},f=function(t){return s.a.post(i+"/app/staff/add",t).then(function(t){return t.data})},o=function(t){return s.a.post(i+"/app/staff/modify",t).then(function(t){return t.data})},r=function(t){return s.a.post(i+"/app/staff/del",t).then(function(t){return t.data})},l=function(t){return s.a.post(i+"/app/staff/quit",t).then(function(t){return t.data})},u=function(t){return s.a.post(i+"/app/department/listAll",t).then(function(t){return t.data})}},178:function(t,e,a){e=t.exports=a(129)(!0),e.push([t.i,".a-admin-head{padding:35px 0 35px 25px}.a-admin-table{margin:0 25px 25px}.el-pagination{float:right;margin-right:20px}.el-dialog{position:absolute;left:50%;-webkit-transform:translateX(-50%);transform:translateX(-50%);background:#fff;border-radius:2px;-webkit-box-shadow:0 1px 3px rgba(0,0,0,.3);box-shadow:0 1px 3px rgba(0,0,0,.3);-webkit-box-sizing:border-box;box-sizing:border-box;margin-bottom:50px;margin-left:80px;margin-top:165px}","",{version:3,sources:["E:/workspaceIDEA/gt_inside_general/cli-pc/src/components/organize/staff/vue/staffList.vue"],names:[],mappings:"AACA,cACE,wBAA0B,CAC3B,AACD,eACE,kBAAoB,CACrB,AACD,eACE,YAAa,AACb,iBAAmB,CACpB,AACD,WACE,kBAAmB,AACnB,SAAU,AACV,mCAAoC,AAC5B,2BAA4B,AACpC,gBAAiB,AACjB,kBAAmB,AACnB,4CAAiD,AACzC,oCAAyC,AACjD,8BAA+B,AACvB,sBAAuB,AAC/B,mBAAoB,AACpB,iBAAkB,AAClB,gBAAkB,CACnB",file:"staffList.vue",sourcesContent:["\n.a-admin-head {\r\n  padding: 35px 0 35px 25px;\n}\n.a-admin-table {\r\n  margin: 0 25px 25px;\n}\n.el-pagination {\r\n  float: right;\r\n  margin-right: 20px;\n}\n.el-dialog {\r\n  position: absolute;\r\n  left: 50%;\r\n  -webkit-transform: translateX(-50%);\r\n          transform: translateX(-50%);\r\n  background: #fff;\r\n  border-radius: 2px;\r\n  -webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);\r\n          box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);\r\n  -webkit-box-sizing: border-box;\r\n          box-sizing: border-box;\r\n  margin-bottom: 50px;\r\n  margin-left: 80px;\r\n  margin-top: 165px;\n}\r\n"],sourceRoot:""}])},194:function(t,e,a){var s=a(178);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);a(130)("033e6c96",s,!0)},213:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",[a("div",{staticClass:"a-admin-head"},[a("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary"},on:{click:t.openAddStaff}},[t._v("新增")]),t._v(" "),a("el-input",{staticStyle:{width:"250px!important","margin-right":"20px"},attrs:{placeholder:"员工编号/姓名/手机号",icon:"search","on-icon-click":t.searchClick},model:{value:t.staffListReq.staffSearch,callback:function(e){t.$set(t.staffListReq,"staffSearch",e)},expression:"staffListReq.staffSearch"}}),t._v(" "),a("el-select",{staticStyle:{width:"80px!important"},model:{value:t.staffListReq.staffStatus,callback:function(e){t.$set(t.staffListReq,"staffStatus",e)},expression:"staffListReq.staffStatus"}},t._l(t.statusOptions,function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}))],1),t._v(" "),a("div",{staticClass:"a-admin-table"},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.staffListData,border:"","highlight-current-row":""}},[a("el-table-column",{attrs:{type:"index",width:"50"}}),t._v(" "),a("el-table-column",{attrs:{prop:"staffName",label:"姓名"}}),t._v(" "),a("el-table-column",{attrs:{prop:"staffEnName",label:"英文名"}}),t._v(" "),a("el-table-column",{attrs:{prop:"staffCode",label:"编号"}}),t._v(" "),a("el-table-column",{attrs:{prop:"staffPhone",label:"电话"}}),t._v(" "),a("el-table-column",{attrs:{label:"入职时间"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-icon",{attrs:{name:"time"}}),t._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(t.$util.DateFormat(e.row.staffJoinTime,"yyyy-MM-dd")))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n            "+t._s(0==e.row.staffStatus?"在职":"离职")+"\n          ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"small"},on:{click:function(a){t.openModifyStaff(e.row)}}},[t._v("编辑")]),t._v(" "),a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){t.delStaff(e.row.id)}}},[t._v("删除")]),t._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:0==e.row.staffStatus,expression:"scope.row.staffStatus == 0"}],attrs:{plain:!0,size:"small",type:"danger"},on:{click:function(a){t.quitStaff(e.row.id)}}},[t._v("离职")])]}}])})],1)],1),t._v(" "),a("el-pagination",{attrs:{"current-page":t.staffListReq.current,"page-sizes":[10,20,50,100],"page-size":t.staffListReq.size,layout:"total, sizes, prev, pager, next",total:t.page.totalNums},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.staffListReq,"current",e)}}})],1),t._v(" "),a("div",[a("el-dialog",{attrs:{title:t.dialogOpe.name,visible:t.dialogStaffVisible},on:{"update:visible":function(e){t.dialogStaffVisible=e}}},[a("el-form",{ref:"staffRules",attrs:{model:t.staff,rules:t.staffRules}},[a("el-form-item",{attrs:{label:"名称",prop:"staffName","label-width":t.formLabelWidth}},[a("el-input",{attrs:{"auto-complete":"off",placeholder:"10字以内"},model:{value:t.staff.staffName,callback:function(e){t.$set(t.staff,"staffName",e)},expression:"staff.staffName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"英文名",prop:"staffEnName","label-width":t.formLabelWidth}},[a("el-input",{attrs:{"auto-complete":"off",placeholder:"10字以内"},model:{value:t.staff.staffEnName,callback:function(e){t.$set(t.staff,"staffEnName",e)},expression:"staff.staffEnName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"员工编号",prop:"staffCode","label-width":t.formLabelWidth}},[a("el-input",{attrs:{"auto-complete":"off",placeholder:"7字以内"},model:{value:t.staff.staffCode,callback:function(e){t.$set(t.staff,"staffCode",e)},expression:"staff.staffCode"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"部门",prop:"depId","label-width":t.formLabelWidth}},[a("el-select",{attrs:{placeholder:"请选择部门"},model:{value:t.staff.depId,callback:function(e){t.$set(t.staff,"depId",e)},expression:"staff.depId"}},t._l(t.departmentListData,function(t){return a("el-option",{key:t.id,attrs:{label:t.depName,value:t.id}})}))],1),t._v(" "),a("el-form-item",{attrs:{label:"入职时间",prop:"staffJoinTime","label-width":t.formLabelWidth}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期"},model:{value:t.staff.staffJoinTime,callback:function(e){t.$set(t.staff,"staffJoinTime",e)},expression:"staff.staffJoinTime"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"电话",prop:"staffPhone","label-width":t.formLabelWidth}},[a("el-input",{attrs:{"auto-complete":"off",placeholder:"12字以内"},model:{value:t.staff.staffPhone,callback:function(e){t.$set(t.staff,"staffPhone",e)},expression:"staff.staffPhone"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:t.dialogCancel}},[t._v("取 消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogConfirm(t.dialogOpe.status)}}},[t._v("确 定")])],1)],1)],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=2.34ee040cf30c61e455ef.js.map