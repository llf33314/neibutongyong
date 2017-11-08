<template>
  <div>
    <div>
      <div class="a-admin-head">
        <el-button type="primary" @click="openAddUser" style="margin-right:15px;">新增</el-button>
        <el-input placeholder="登录名/真实姓名" icon="search" v-model="userListReq.userSearch" :on-icon-click="searchClick" style="width:250px;"></el-input>
        <el-select v-model="userListReq.userStatus" @change="changeStatus" style="width:80px!important;">
          <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
      </div>
      <div class="a-admin-table">
        <el-table :data="userListData" border highlight-current-row style="width: 100%">
          <el-table-column type="index" width="50"></el-table-column>
          <el-table-column prop="loginName" label="登录名"></el-table-column>
          <el-table-column prop="userName" label="真实姓名"></el-table-column>
          <el-table-column prop="staffName" label="员工姓名"></el-table-column>
          <el-table-column prop="userStatus" label="状态">
             <template slot-scope="scope">
               {{scope.row.userStatus == 0 ? '正常' : '停用'}} 
             </template>
          </el-table-column>
          <el-table-column label="创建时间">
            <template slot-scope="scope">
              <el-icon name="createTime"></el-icon>
              <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作">
              <template  slot-scope="scope">
              <el-button size="small" type="primary" @click="relation(scope.row)">关联</el-button>
              <el-button size="small" @click="restPwd(scope.row.userId)">重置密码</el-button>
              <el-button size="small" type="danger" @click="disableUser(scope.row.userId)">停用</el-button>
              <el-button size="small" type="danger" @click="delUser(scope.row.userId)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="userListReq.current"
          :page-sizes="[10, 20, 50, 100]" :page-size="userListReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
        <el-dialog :title="dialogOpe.name" :visible.sync="dialogFormVisible">
          <el-form :model="userAddReq">
            <el-form-item label="登录名：" :label-width="formLabelWidth">
              <el-input v-model="userAddReq.loginName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="真实姓名：" :label-width="formLabelWidth">
              <el-input v-model="userAddReq.userName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码：" :label-width="formLabelWidth">
              <el-input v-model="userAddReq.password" type="password" auto-complete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogConfirm(dialogOpe.status)">确 定</el-button>
          </div>
        </el-dialog>
    </div>
    <div>
      <el-dialog title="关联信息" :visible.sync="dialogVisible">
          <el-button type="primary" @click="toRelationStaff">关联员工</el-button>
          <el-button type="primary" @click="toRelationRole">关联角色</el-button>
          <span slot="footer" class="dialog-footer">
             <el-button @click="dialogVisible = false">取 消</el-button>
             <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
      </el-dialog>
    </div>
    <div>
      <el-dialog title="关联员工" :visible.sync="dialogStaffVisible">
        <el-table :data="userStaffListData" highlight-current-row @current-change="handleStaffTableChange">
          <el-table-column prop="staffName" label="姓名"></el-table-column>
          <el-table-column prop="staffEnName" label="英文名"></el-table-column>
          <el-table-column prop="staffCode" label="编号"></el-table-column>
        </el-table>
        <el-pagination @size-change="handleStaffSizeChange" @current-change="handleStaffCurrentChange" :current-page.sync="userStaffListReq.current" 
          :page-sizes="[10, 20, 50, 100]" :page-size="userStaffListReq.size" layout="total, sizes, prev, pager, next" :total="pageStaff.totalNums">
        </el-pagination>
        <span>当前关联的员工：{{userOpe.staffName}}</span>
        <el-button type="primary" @click="saveStaff">保存选择</el-button>
      </el-dialog>
    </div>
    <div>
      <el-dialog title="关联角色" :visible.sync="dialogRoleVisible">
        <el-table :data="userRoleListData" highlight-current-row @current-change="handleStaffTableChange">
          <el-table-column prop="roleName" label="角色名"></el-table-column>
          <el-table-column label="角色权限">
            <template slot-scope="scope">
               {{scope.row.rolePower == 0 ? '正常' : '最高权限'}} 
             </template>
          </el-table-column>
          <el-table-column prop="roleRemark" label="角色描述"></el-table-column>
          <el-table-column label="关联角色">
            <template slot-scope="scope">
               {{scope.row.userHas == 0 ? '已关联' : '未关联'}} 
             </template>
          </el-table-column>
          <el-table-column label="操作">
              <template slot-scope="scope">
              <el-button v-if="scope.row.userHas == 1" size="small" @click="relationRole(scope.row.roleId)">关联</el-button>
              <el-button v-if="scope.row.userHas == 0" size="small" type="danger" @click="cancelRelationRole(scope.row.roleId)">取消关联</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination @size-change="handleRoleSizeChange" @current-change="handleRoleCurrentChange" :current-page.sync="userRoleListReq.current" 
          :page-sizes="[10, 20, 50, 100]" :page-size="userRoleListReq.size" layout="total, sizes, prev, pager, next" :total="pageRole.totalNums">
        </el-pagination>
      </el-dialog>
    </div>
  </div>
</template>
<script>
import {
  requestListUser,
  requestAddUser,
  requestRestPwdUser,
  requestDisableUser,
  requestDelUser,
  requestListUserStaff,
  requestRelationStaff,
  requestListRoleByPage,
  requestRelationRole,
  requestCancelRelationRole
} from '../api/api';
export default {
  data() {
    return {
      userListReq: {
        //用户列表
        userSearch: '',
        userStatus: 0,
        current: 1,
        size: 10
      },
      page: {
        totalNums: 1,
        totalPages: 1
      },
      userListData: [],
      dialogFormVisible: false,
      dialogVisible: false,
      formLabelWidth: '120px',
      userAddReq: {
        //新增对象
        loginName: '',
        userName: '',
        password: ''
      },
      dialogOpe: {
        //确定判断状态
        status: 0 // 0：无，1：新增，2：编辑
      },
      statusOptions: [
        {
          value: '',
          label: '全部'
        },
        {
          value: 0,
          label: '正常'
        },
        {
          value: 1,
          label: '停用'
        }
      ],
      userOpe: {},
      dialogStaffVisible: false, // 关联员工
      userStaffListReq: {
        current: 1,
        size: 10
      },
      pageStaff: {
        totalNums: 1,
        totalPages: 1
      },
      userStaffListData: [],
      relationStaffBean: {
        userId: '',
        staffId: ''
      },
      dialogRoleVisible: false, // 关联角色
      userRoleListReq: {
        current: 1,
        size: 10,
        userId:''
      },
      pageRole: {
        totalNums: 1,
        totalPages: 1
      },
      userRoleListData:[]
    };
  },
  methods: {
    //调用列表的数据
    getUserList() {
      requestListUser(this.userListReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.userListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    getUserStaffList() {
      // 获取关系员工列表
      requestListUserStaff(this.userStaffListReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.userStaffListData = data.data;
          this.pageStaff.totalNums = data.page.totalNums;
          this.pageStaff.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    getUserRoleList() {
      // 获取关系角色列表
      requestListRoleByPage(this.userRoleListReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.userRoleListData = data.data;
          this.pageRole.totalNums = data.page.totalNums;
          this.pageRole.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    addUser() {
      requestAddUser(this.userAddReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.$message({
            type: 'success',
            message: '新增用户成功！'
          });
          this.getUserList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    restPwd(userId) {
      //停用
      this.$confirm('是否重置该用户密码？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestRestPwdUser({ userId: userId }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '密码重置成功！默认密码：gt123456'
            });
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    disableUser(userId) {
      //停用
      this.$confirm('是否停用用户？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestDisableUser({ userId: userId }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '操作成功！'
            });
            this.getUserList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    delUser(userId) {
      //删除
      this.$confirm('删除用户后数据不可恢复，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestDelUser({ userId: userId }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '删除成功！'
            });
            this.getUserList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    relationStaff() {
      console.log(this.relationStaffBean);
      requestRelationStaff(this.relationStaffBean).then(data => {
        var _code = data.code;
        if (_code == 100) {
          this.$message({
            type: 'success',
            message: '关联员工成功！'
          });
          this.getUserList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    relationRole(roleId){
      // 关联角色
      var userId = this.userRoleListReq.userId;
      this.$confirm('确定关联角色到该用户？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestRelationRole({ userId: userId, roleId: roleId }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '关联成功！'
            });
            this.getUserRoleList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    cancelRelationRole(roleId){
      // 取消关联
      var userId = this.userRoleListReq.userId;
      this.$confirm('确定取消关联角色到该用户？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestCancelRelationRole({ userId: userId, roleId: roleId }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '取消关联成功！'
            });
            this.getUserRoleList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    searchClick() {
      // 搜索
      this.getUserList();
    },
    changeStatus() {
      // 改变选择框
      this.getUserList();
    },
    openAddUser() {
      //新增
      this.dialogOpe.name = '新增用户';
      this.userAddReq = {};
      this.dialogFormVisible = true;
      this.dialogOpe.status = 1;
    },
    dialogConfirm(status) {
      //新增确定事件
      if (status == 1) {
        // 新增
        this.dialogFormVisible = false;
        this.addUser();
      } else if (status == 2) {
        // 编辑（无用）
        this.dialogFormVisible = false;
      }
    },
    handleCurrentChange(val) {
      //分页
      console.log('handleCurrentChange');
      this.getUserList();
    },
    handleSizeChange(val) {
      this.userListReq.size = val;
      console.log(this.userListReq.size);
      console.log('handleSizeChange');
      this.getUserList();
    },
    relation(user) {
      //关联
      this.dialogVisible = true;
      this.userOpe = user;
      this.relationStaffBean.userId = user.userId; // 员工
      this.userRoleListReq.userId = user.userId; // 角色
    },
    toRelationStaff() {
      // 关联员工
      this.getUserStaffList();
      this.dialogStaffVisible = true;
    },
    saveStaff() {
      // 保存关联员工
      this.relationStaff();
      this.dialogStaffVisible = false;
      this.dialogVisible = false;
    },
    handleStaffCurrentChange(val) {
      // 弹框员工里面的分页选择
      this.getUserStaffList();
    },
    handleStaffSizeChange(val) {
      // 弹框员工里面的分页选择
      this.userStaffListReq.size = val;
      // console.log(this.staffListReq.size);
      this.getUserStaffList();
    },
    handleStaffTableChange(val) {
      // 表格选择
      console.log(val);
      if (val == null) {
        return;
      }
      this.relationStaffBean.staffId = val.id;
      this.userOpe.staffName = val.staffName;
    },
    toRelationRole(){
      // 关联角色
      this.getUserRoleList();
      this.dialogRoleVisible = true;
    },
    handleRoleCurrentChange(val) {
      // 弹框角色里面的分页选择
      this.getUserRoleList();
    },
    handleRoleSizeChange(val) {
      // 弹框橘色里面的分页选择
      this.userRoleListReq.size = val;
      // console.log(this.userRoleListReq.size);
      this.getUserRoleList();
    },
  },
  created() {
    this.getUserList();
  }
};
</script>

