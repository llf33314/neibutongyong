<style lang="less">
  .organize-department-depart {
 
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
 
  }

</style>

<template>
  <div class="organize-department-depart">
    <div>
      <div class="a-admin-head">
        <el-button type="primary" @click="openAddDepart" style="margin-right:15px;">新增</el-button>
        <el-input placeholder="部门名称" icon="search" v-model="departmentListReq.departmentSearch" :on-icon-click="searchClick" style="width:250px;"></el-input>
      </div>
      <div class="a-admin-table">
        <el-table :data="departmentListData" border highlight-current-row style="width: 100%">
          <el-table-column type="index" width="50"></el-table-column>
          <el-table-column prop="depName" label="名称"></el-table-column>
          <el-table-column prop="depAdd" label="地址"></el-table-column>
          <el-table-column prop="depRemark" label="描述"></el-table-column>
          <el-table-column label="创建时间">
            <template slot-scope="scope">
              <el-icon name="time"></el-icon>
              <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="170">
            <template slot-scope="scope">
              <el-button size="small" @click="openModifyDepart(scope.row)">编辑</el-button>
              <el-button size="small" type="danger" @click="delDepart(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination @current-change="handleCurrentChange" :current-page.sync="departmentListReq.current" :page-size="departmentListReq.size"
        layout="total, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
      <el-dialog :title="dialogOpe.name" :visible.sync="dialogFormVisible">
        <el-form :model="departmentAddReq" :rules="departmentRules" ref="departmentRules">
          <el-form-item label="部门名称：" prop="depName" :label-width="formLabelWidth">
            <el-input v-model="departmentAddReq.depName" auto-complete="off" placeholder="请输入20字以内的部门名称"></el-input>
          </el-form-item>
          <el-form-item label="部门地址：" prop="depAdd" :label-width="formLabelWidth">
            <el-input v-model="departmentAddReq.depAdd" auto-complete="off" placeholder="请输入25字以内的部门地址"></el-input>
          </el-form-item>
          <el-form-item label="部门描述：" prop="depRemark" :label-width="formLabelWidth">
            <el-input v-model="departmentAddReq.depRemark" type="textarea" placeholder="请输入25字以内的部门描述"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogConfirm(dialogOpe.status)">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  import {
    requestListDepartInfo,
    requestAddDepartInfo,
    requestDelDepart,
    requestModifyDepart
  } from '../api/api';
  export default {
    data() {
      return {
        departmentListReq: {
          //部门列表-对象
          departmentSearch: '',
          current: 1,
          size: 8
        },
        page: {
          //分页
          totalNums: 1,
          totalPages: 1
        },

        departmentListData: [], //部门数组对象

        dialogFormVisible: false,

        departmentAddReq: {
          //新增对象
          depAdd: '',
          depName: '',
          depRemark: ''
        },
        dialogOpe: {
          //确定判断状态
          status: 0 // 0：无，1：新增，2：编辑
        },
        formLabelWidth: '120px',
        departmentRules: {
          depName: [{
              required: true,
              message: '请输入部门名称',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 20,
              message: '长度不超过20个字符',
              trigger: 'blur'
            }
          ],
          depAdd: [{
              required: true,
              message: '请选输入部门地址',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 25,
              message: '长度不超过25个字符',
              trigger: 'blur'
            }
          ],
          depRemark: [{
              required: false,
              message: '请选部门描述',
              trigger: 'blur'
            },
            {
              max: 25,
              message: '长度不超过25个字符',
              trigger: 'blur'
            }
          ]
        }
      };
    },
    methods: {
      ListDepartpartment() {
        //分页获取部门列表
        requestListDepartInfo(this.departmentListReq).then(result => {
          console.log(result);
          var _code = result.code;
          if (_code == 100) {
            this.departmentListData = result.data;
            this.page.totalNums = result.page.totalNums;
            this.page.totalPages = result.page.totalPages;
            console.log(this.departmentListData);
          } else {
            this.$message.error(result.msg + '[错误码：' + _code + ']');
          }
        });
      },
      AddDepartpartment() {
        //新增部门列表
        console.log(this.departmentAddReq);
        requestAddDepartInfo(this.departmentAddReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.ListDepartpartment();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      ModifyDepartpartment() {
        // 修改部门列表
        console.log(this.departmentAddReq);
        requestModifyDepart(this.departmentAddReq).then(data => {
          console.log(this.departmentAddReq);
          var _code = data.code;
          if (_code == 100) {
            this.departmentListData = data.data;
            this.ListDepartpartment();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      openAddDepart() {
        //新增事件
        this.dialogOpe.name = '新增部门';
        this.departmentAddReq = {};
        this.dialogOpe.status = 1;
        this.dialogFormVisible = true;
      },
      searchClick() {
        //搜索事件
        this.ListDepartpartment();
      },
      handleCurrentChange() {
        //分页
        this.ListDepartpartment();
      },
      dialogConfirm(status) {
        this.$refs['departmentRules'].validate(valid => {
          // console.log(valid);
          if (valid) {
            // console.log(status);
            // console.log(this.depRemark);
            if (status == 1) {
              this.AddDepartpartment();
            } else if (status == 2) {
              this.ModifyDepartpartment();
            }
            this.dialogFormVisible = false;
          } else {
            return false;
          }
        });
      },
      openModifyDepart(departmentAddReq) {
        //编辑事件
        this.dialogOpe.name = '编辑部门';
        console.log(55656);
        this.departmentAddReq = departmentAddReq;
        this.dialogOpe.status = 2;
        this.dialogFormVisible = true;
      },
      delDepart(id) {
        //删除事件
        console.log(555);
        this.$confirm('此操作将永久删除该部门, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          requestDelDepart({
            id: id
          }).then(data => {
            var _code = data.code;
            if (_code == 100) {
              this.$message({
                type: 'success',
                message: '您已删除该部门及其详情数据！'
              });
              this.ListDepartpartment();
            } else {
              this.$message.error(data.msg + '[错误码：' + _code + ']');
            }
          });
        });
      }
    },
    created() {
      this.ListDepartpartment();
    }
  };

</script>
