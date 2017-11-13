<template>
  <div>
    <div>
      <div class="a-admin-head">
        <el-button type="primary" @click="openAddStaff" style="margin-right: 20px;">新增</el-button>
        <el-input placeholder="员工编号/姓名/手机号" icon="search" v-model="staffListReq.staffSearch" :on-icon-click="searchClick" style="width:250px!important;margin-right: 20px;"></el-input>
        <el-select v-model="staffListReq.staffStatus" style="width:80px!important;">
          <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
      </div>
      <div class="a-admin-table">
        <el-table :data="staffListData" border highlight-current-row style="width: 100%">
          <el-table-column type="index" width="50"></el-table-column>
          <el-table-column prop="staffName" label="姓名"></el-table-column>
          <el-table-column prop="staffEnName" label="英文名"></el-table-column>
          <el-table-column prop="staffCode" label="编号"></el-table-column>
          <el-table-column prop="staffPhone" label="电话"></el-table-column>
          <el-table-column label="入职时间">
              <template slot-scope="scope">
                  <el-icon name="time"></el-icon>
                  <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.staffJoinTime, "yyyy-MM-dd") }}</span>
              </template>
          </el-table-column>
          <el-table-column label="状态">
            <template slot-scope="scope">
              {{ scope.row.staffStatus == 0 ? '在职':'离职'}}
            </template>
          </el-table-column>
          <el-table-column label="操作">
              <template slot-scope="scope">
                  <el-button size="small" @click="openModifyStaff(scope.row)">编辑</el-button>                  
                  <el-button size="small" type="danger" @click="delStaff(scope.row.id)">删除</el-button>
                  <el-button v-show="scope.row.staffStatus == 0" :plain="true" size="small" type="danger" @click="quitStaff(scope.row.id)">离职</el-button>
              </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="staffListReq.current" 
        :page-sizes="[10, 20, 50, 100]" :page-size="staffListReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <!-- 弹窗 -->
    <div>
      <el-dialog :title="dialogOpe.name" :visible.sync="dialogStaffVisible">
        <el-form :model="staff" :rules="staffRules" ref="staffRules">
          <el-form-item label="名称" prop="staffName" :label-width="formLabelWidth">
            <el-input v-model="staff.staffName" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="英文名" prop="staffEnName" :label-width="formLabelWidth">
            <el-input v-model="staff.staffEnName" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="员工编号" prop="staffCode" :label-width="formLabelWidth">
            <el-input v-model="staff.staffCode" auto-complete="off" placeholder="7字以内"></el-input>
          </el-form-item>
          <el-form-item label="部门" prop="depId" :label-width="formLabelWidth">
            <el-select v-model="staff.depId" placeholder="请选择部门">
              <el-option v-for="item in departmentListData" :key="item.id" :label="item.depName" :value="item.id"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="入职时间" prop="staffJoinTime" :label-width="formLabelWidth">
            <el-date-picker type="date" v-model="staff.staffJoinTime" placeholder="选择日期"></el-date-picker>
          </el-form-item>
          <el-form-item label="电话" prop="staffPhone" :label-width="formLabelWidth">
            <el-input v-model="staff.staffPhone" auto-complete="off" placeholder="12字以内"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogCancel">取 消</el-button>
          <el-button type="primary" @click="dialogConfirm(dialogOpe.status)">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
import {
  requestListStaff,
  requestAddStaff,
  requestModifyStaff,
  requestDelStaff,
  requestQuitStaff,
  requestListDepartment
} from '../api/api';
export default {
  data() {
    return {
      staffListReq: {
        staffSearch: '',
        staffStatus: 0,
        current: 1,
        size: 10
      },
      page: {
        totalNums: 1,
        totalPages: 1
      },
      staffListData: [],
      staff: {
        id: 0,
        staffCode: 0,
        staffName: '',
        staffPhone: '',
        staffJoinTime: ''
      },
      dialogOpe: {
        name: '员工信息',
        status: 0 // 0：无，1：新增，2：编辑
      },
      dialogStaffVisible: false,
      formLabelWidth: '120px',
      statusOptions: [
        {
          value: '',
          label: '全部'
        },
        {
          value: 0,
          label: '在职'
        },
        {
          value: 1,
          label: '离职'
        }
      ],
      departmentListData: [],
      staffRules: {
        staffName: [
          { required: true, message: '请输入名称', trigger: 'blur' },
          { min: 1, max: 8, message: '长度不超过8个字符', trigger: 'blur' }
        ],
        staffEnName: [
          { required: false, message: '请输入英文名', trigger: 'blur' },
          { min: 1, max: 15, message: '长度不超过15个字符', trigger: 'blur' }
        ],
        staffCode: [
          { required: true, message: '请输入员工编号', trigger: 'blur' },
          { min: 1, max: 15, message: '长度不超过15个字符', trigger: 'blur' }
        ],
        //depId: [{ required: true, message: '请选择部门', trigger: 'blur' }],
        // staffJoinTime: [
        //   { required: true, message: '请选择入职时间', trigger: 'blur' }
        // ],
        staffPhone: [
          { required: true, message: '请选输入电话', trigger: 'blur' },
          { min: 1, max: 15, message: '长度不超过15个字符', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    getStaffList() {
      // console.log(this.staffListReq);
      requestListStaff(this.staffListReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.staffListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    addStaff() {
      console.log(this.staff);
      requestAddStaff(this.staff).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.staffListData = data.data;
          this.getStaffList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
        this.dialogCancel();
      });
    },
    modifyStaff() {
      // console.log(this.staff);
      requestModifyStaff(this.staff).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.staffListData = data.data;
          this.getStaffList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
        this.dialogCancel();
      });
    },
    delStaff(id) {
      this.$confirm('此操作将永久删除该员工数据，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestDelStaff({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '您已删除该员工！'
            });
            this.getStaffList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    quitStaff(id) {
      this.$confirm('离职员工？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestQuitStaff({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '操作成功！'
            });
            this.getStaffList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    getDepartmentList() {
      // console.log(this.staffListReq);
      requestListDepartment().then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.departmentListData = data.data;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    openAddStaff() {
      // 新增员工
      this.staff = {};
      this.dialogOpe.name = '新增员工';
      this.dialogOpe.status = 1;
      this.dialogStaffVisible = true;
      this.departmentListData = [];
      this.getDepartmentList();
    },
    openModifyStaff(staff) {
      // 编辑员工
      this.staff = staff;
      this.dialogOpe.name = '编辑员工';
      this.dialogOpe.status = 2;
      this.departmentListData = [];
      this.getDepartmentList();
      this.dialogStaffVisible = true;
    },
    searchClick() {
      // 搜索
      this.getStaffList();
    },
    dialogCancel() {
      // 取消弹出框
      this.dialogOpe.name = '员工信息';
      this.dialogOpe.status = 0;
      this.dialogStaffVisible = false;
    },
    dialogConfirm(status) {
      this.$refs['staffRules'].validate(valid => {
        // console.log(valid);
        if (valid) {
          // console.log(status);
          // 确定弹出框
          switch (status) {
            case 1:
              this.addStaff();
              break;
            case 2:
              this.modifyStaff();
              break;
            default:
              this.dialogCancel();
              break;
          }
        } else {
          return false;
        }
      });
    },
    handleCurrentChange(val) {
      this.getStaffList();
    },
    handleSizeChange(val) {
      this.staffListReq.size = val;
      console.log(this.staffListReq.size);
      this.getStaffList();
    }
  },
  created() {
    this.getStaffList();
  },
  watch: {
    'staffListReq.staffStatus': function(val) {
      //此处不要使用箭头函数
      this.getStaffList();
    }
  }
};
</script>
<style>
.a-admin-head {
  padding: 35px 0 35px 25px;
}
.a-admin-table {
  margin: 0 25px 25px;
}
.el-pagination {
  float: right;
  margin-right: 20px;
}
.el-dialog {
  position: absolute;
  left: 50%;
  -ms-transform: translateX(-50%);
  transform: translateX(-50%);
  background: #fff;
  border-radius: 2px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
  box-sizing: border-box;
  margin-bottom: 50px;
  margin-left: 80px;
  margin-top: 165px;
}
</style>