// 组织关系设置

<style lang="less">
  .function-performance-organize {
    .el-pagination {
      white-space: nowrap;
      padding: 15px 5px;
      color: #48576a;
      text-align: right;
    }

    .el-pagination button,
    .el-pagination span {
      vertical-align: 0;
    }

    .el-pager,
    .el-pager li {
      vertical-align: 0;
    }

  }

</style>
<template>
  <div class="function-performance-organize">
    <el-select v-model="listOrganizeReq.departmentId" clearable placeholder="请选择部门" style="margin: 0px 0 29px;">
      <el-option v-for="item in departmentListData" :key="item.id" :label="item.depName" :value="item.id"></el-option>
    </el-select>
    <el-table :data="organizeListData" border highlight-current-row v-loading="loading" style="width: 100%">
      <el-table-column type="index" width="50"></el-table-column>
      <el-table-column prop="staffName" label="姓名"></el-table-column>
      <el-table-column prop="departmentName" label="部门"></el-table-column>
      <el-table-column prop="directlyName" label="直属领导"></el-table-column>
      <el-table-column prop="branchName" label="分管领导"></el-table-column>
      <el-table-column label="操作" width="250">
        <template slot-scope="scope">
          <el-button size="small" type="primary" @click="relationDirectly(scope.row)">关联直属领导</el-button>
          <el-button size="small" type="primary" @click="relationBranch(scope.row)">关联分管领导</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="listOrganizeReq.current"
      :page-sizes="[10, 20, 50, 100]" :page-size="listOrganizeReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
    </el-pagination>
    <div>
      <el-dialog :title="organizeOpe.name" :visible.sync="dialogTableVisible">
        <el-table :data="staffListData" highlight-current-row @current-change="handleStaffTableChange">
          <el-table-column prop="staffName" label="姓名"></el-table-column>
          <el-table-column prop="staffEnName" label="英文名"></el-table-column>
          <el-table-column prop="staffCode" label="编号"></el-table-column>
        </el-table>
        <el-pagination @size-change="handleStaffSizeChange" @current-change="handleStaffCurrentChange" :current-page.sync="staffListReq.current"
          :page-sizes="[10, 20, 50, 100]" :page-size="staffListReq.size" layout="total, sizes, prev, pager, next" :total="pageStaff.totalNums">
        </el-pagination>
        <span v-show="organize.staffOrgId != ''">当前选择的{{organizeOpe.name}}：{{organize.staffOrgName}}</span>
        <el-button v-show="organize.staffOrgId != ''" type="primary" @click="saveSelect()" style="margin-left: 15px;">保存选择</el-button>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  import {
    requestListOrganize,
    requestListDepartment,
    requestListStaff,
    requestAddOrModifyDirectly,
    requestAddOrModifyBranch
  } from "../api/api";
  export default {
    data() {
      return {
        listOrganizeReq: {
          departmentId: "",
          current: 1,
          size: 10
        },
        page: {
          totalNums: 1,
          totalPages: 1
        },
        dialogTableVisible: false,
        organizeListData: [],
        departmentListData: [],
        organize: {
          staffId: '',
          staffOrgId: '',
          staffOrgName: ""
        },
        organizeOpe: {
          status: 0,
          name: ''
        }, // 0：无，1：保存直属领导，2：保存分管领导
        staffListReq: {
          staffStatus: 0,
          current: 1,
          size: 10
        },
        pageStaff: {
          totalNums: 1,
          totalPages: 1
        },
        staffListData: [],
        loading: false
      };
    },
    methods: {
      listOrganize() {
        // 分页获取组织关系
        this.loading = true;
        requestListOrganize(this.listOrganizeReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.organizeListData = data.data;
            this.page.totalNums = data.page.totalNums;
            this.page.totalPages = data.page.totalPages;
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
          this.loading = false;
        });
      },
      getDepartmentList() {
        // 获取部门列表
        // console.log(this.staffListReq);
        requestListDepartment().then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.departmentListData = data.data;
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
        });
      },
      getStaffList() {
        // 分页获取员工列表
        // console.log(this.staffListReq);
        requestListStaff(this.staffListReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.staffListData = data.data;
            this.pageStaff.totalNums = data.page.totalNums;
            this.pageStaff.totalPages = data.page.totalPages;
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
        });
      },
      addOrModifyDirectly() {
        // 新增或修改直属领导
        console.log(this.organize);
        requestAddOrModifyDirectly(this.organize).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: "操作成功",
              type: "success"
            });
            this.listOrganize();
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
        });
      },
      addOrModifyBranch() {
        // 新增或修改分管领导
        console.log(this.organize);
        requestAddOrModifyBranch(this.organize).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: "操作成功",
              type: "success"
            });
            this.listOrganize();
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
        });
      },
      handleCurrentChange(val) {
        this.listOrganize();
      },
      handleSizeChange(val) {
        this.listOrganizeReq.size = val;
        // console.log(this.listOrganizeReq.size);
        this.listOrganize();
      },
      handleStaffCurrentChange(val) {
        // 弹框里面的分页选择
        this.getStaffList();
      },
      handleStaffSizeChange(val) {
        // 弹框里面的分页选择
        this.staffListReq.size = val;
        // console.log(this.staffListReq.size);
        this.getStaffList();
      },
      handleStaffTableChange(val) {
        // 员工表格选择
        console.log(val);
        if (val == null) {
          return;
        }
        this.organize.staffOrgId = val.id;
        this.organize.staffOrgName = val.staffName;
      },
      relationDirectly(organizeBean) {
        // 打开关联直属领导
        this.organizeOpe.status = 0;
        this.organizeOpe.name = '';
        this.organize.staffId = '';
        this.organize.staffOrgId = '';
        console.log(organizeBean);
        this.organize.staffId = organizeBean.staffId;
        this.dialogTableVisible = true;
        this.organizeOpe.status = 1;
        this.organizeOpe.name = '直属领导';
        this.getStaffList();
      },
      relationBranch(organizeBean) {
        // 打开关联分管领导
        this.organizeOpe.status = 0;
        this.organizeOpe.name = '';
        this.organize.staffId = '';
        this.organize.staffOrgId = '';
        console.log(organizeBean);
        this.organize.staffId = organizeBean.staffId;
        this.dialogTableVisible = true;
        this.organizeOpe.status = 2;
        this.organizeOpe.name = '分管领导';
        this.getStaffList();
      },
      saveSelect() { // 保存选择
        if (this.organizeOpe.status == 1) {
          this.addOrModifyDirectly();
        } else if (this.organizeOpe.status == 2) {
          this.addOrModifyBranch();
        }
        this.dialogTableVisible = false;
        this.organizeOpe.status = 0;
      }
    },
    created() {
      this.listOrganize();
      this.getDepartmentList();
    },
    watch: {
      "listOrganizeReq.departmentId": function (val) {
        //此处不要使用箭头函数
        this.listOrganize();
      }
    }
  };

</script>
