<style lang="less">
  .manage-role {
   

  }

</style>
<template>
  <div class="manage-role">
    <div>
      <div class="a-admin-head">
        <el-button type="primary" @click="openAddRole">新增</el-button>
        <el-input placeholder="角色名" icon="search" v-model="roleListReq.roleSearch" :on-icon-click="searchClick" style="width:250px;"></el-input>
      </div>
      <div class="a-admin-table">
        <el-table :data="roleListData" border highlight-current-row style="width: 100%">
          <el-table-column type="index" width="100"></el-table-column>
          <el-table-column prop="roleName" label="角色名称"></el-table-column>
          <el-table-column prop="roleRemark" label="角色描述"></el-table-column>
          <el-table-column label="角色权限">
            <template slot-scope="scope">
              <span>{{ scope.row.rolePower == 0 ? "普通" : "最高权限"}}</span>
            </template>
          </el-table-column>
          <el-table-column label="创建时间">
            <template slot-scope="scope">
              <el-icon name="time"></el-icon>
              <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="250">
            <template slot-scope="scope">
              <el-button size="small" @click="openModifyRole(scope.row)">编辑</el-button>
              <el-button size="small" type="primary" @click="openRoleMenu(scope.row)">关联菜单</el-button>
              <el-button size="small" type="danger" @click="delRole(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="roleListReq.current"
        :page-sizes="[10, 20, 50, 100]" :page-size="roleListReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
      <el-dialog :title="dialogOpe.name" :visible.sync="dialogRoleVisible" :modal-append-to-body="false">
        <el-form :model="role" :rules="roleRules" ref="roleRules">
          <el-form-item label="角色名称：" prop="roleName" :label-width="formLabelWidth">
            <el-input v-model="role.roleName" auto-complete="off" placeholder="请输入10字以内的角色名称"></el-input>
          </el-form-item>
          <el-form-item label="角色描述：" prop="roleRemark" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="role.roleRemark" auto-complete="off" placeholder="请输入25字以内的角色描述"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogCancel">取 消</el-button>
          <el-button type="primary" @click="dialogConfirm(dialogOpe.status)">确 定</el-button>
        </div>
      </el-dialog>
    </div>
    <div>
      <el-dialog title="关联菜单" :visible.sync="dialogMenuVisible" :modal-append-to-body="false">
        <el-tree :data="menuListData" show-checkbox :props="roleMenuProps" default-expand-all node-key="id" :default-checked-keys="menuCheckData"
          ref="menuTree">
        </el-tree>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogMenuCancel">取 消</el-button>
          <el-button type="primary" @click="dialogMenuConfirm">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  import {
    requestListRole,
    requestAddRole,
    requestModifyRole,
    requestDelRole,
    requestListAllMenu,
    requestRelationRoleMenu
  } from '../api/api';
  export default {
    data() {
      return {
        roleListReq: {
          roleSearch: '',
          current: 1,
          size: 10
        },
        page: {
          totalNums: 1,
          totalPages: 1
        },
        roleListData: [],
        role: {
          id: 0,
          roleName: '',
          roleRemark: ''
        },
        dialogOpe: {
          name: '角色信息',
          status: 0 // 0：无，1：新增，2：编辑
        },
        dialogRoleVisible: false,
        formLabelWidth: '120px',
        menuListReq: {
          roleId: 0
        },
        dialogMenuVisible: false,
        menuListData: [],
        menuCheckData: [],
        roleMenuProps: {
          children: 'menuSubDTOList',
          label: 'menuName'
        },
        relationMenuReq: {
          roleId: 0,
          menuIdList: []
        },
        roleRules: {
          roleName: [{
              required: true,
              message: '请输入角色名称',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 10,
              message: '长度不超过10个字符',
              trigger: 'blur'
            }
          ],
          roleRemark: [{
              required: false,
              message: '请选输入角色描述',
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
      getRoleList() {
        requestListRole(this.roleListReq).then(data => {
          // console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.roleListData = data.data;
            this.page.totalNums = data.page.totalNums;
            this.page.totalPages = data.page.totalPages;
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      addRole() {
        console.log(this.role);
        requestAddRole(this.role).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '新增成功！'
            });
            this.getRoleList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
          this.dialogCancel();
        });
      },
      modifyRole() {
        // console.log(this.role);
        requestModifyRole(this.role).then(data => {
          // console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '修改成功！'
            });
            this.getRoleList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
          this.dialogCancel();
        });
      },
      delRole(id) {
        this.$confirm('此操作将永久删除该角色及其关联数据，是否继续？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          requestDelRole({
            id: id
          }).then(data => {
            var _code = data.code;
            if (_code == 100) {
              this.$message({
                type: 'success',
                message: '删除成功！'
              });
              this.getRoleList();
            } else {
              this.$message.error(data.msg + '[错误码：' + _code + ']');
            }
          });
        });
      },
      getMenuList() {
        requestListAllMenu(this.menuListReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.menuListData = data.data.menuMainDTOList;
            this.menuCheckData = data.data.idList;
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      relationMenu() {
        // 关联角色菜单
        requestRelationRoleMenu(this.relationMenuReq).then(data => {
          // console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '关联成功！'
            });
            this.dialogMenuCancel();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
          this.dialogCancel();
        });
      },
      openAddRole() {
        // 新增字典
        this.role = {};
        this.dialogOpe.name = '新增字典';
        this.dialogOpe.status = 1;
        this.dialogRoleVisible = true;
      },
      openModifyRole(role) {
        // 编辑字典
        this.role = role;
        this.dialogOpe.name = '编辑字典';
        this.dialogOpe.status = 2;
        this.dialogRoleVisible = true;
      },
      searchClick() {
        // 搜索
        this.getRoleList();
      },
      dialogCancel() {
        // 取消弹出框
        this.dialogOpe.name = '字典信息';
        this.dialogOpe.status = 0;
        this.dialogRoleVisible = false;
      },
      dialogConfirm(status) {
        this.$refs['roleRules'].validate(valid => {
          // console.log(valid);
          if (valid) {
            // console.log(status);
            // 确定弹出框
            switch (status) {
              case 1:
                this.addRole();
                break;
              case 2:
                this.modifyRole();
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
        this.getRoleList();
      },
      handleSizeChange(val) {
        this.roleListReq.size = val;
        this.getRoleList();
      },
      openRoleMenu(role) {
        // 打开关联菜单
        this.menuListReq.roleId = role.id;
        this.relationMenuReq.roleId = role.id;
        this.getMenuList();
        this.dialogMenuVisible = true;
      },
      dialogMenuConfirm() {
        // 保存选择的菜单
        this.relationMenuReq.menuIdList = this.$refs.menuTree.getCheckedKeys();
        console.log(this.relationMenuReq.menuIdList);
        this.relationMenu();
      },
      dialogMenuCancel() {
        this.dialogMenuVisible = false;
      }
    },
    created() {
      this.getRoleList();
    }
  };

</script>
