<template>
  <div>
    <div>
      <div class="a-admin-head">
        <el-button type="primary" @click="openAddMenu" style="margin-right:15px;">新增</el-button>
        <el-input placeholder="菜单名" icon="search" v-model="menuListReq.menuSearch" :on-icon-click="searchClick" style="width:250px;"></el-input>
      </div>
      <div class="a-admin-table">
          <el-table :data="menuListData" border highlight-current-row style="width: 100%">
            <el-table-column type="index" width="100"></el-table-column>
            <el-table-column prop="menuName" label="菜单名称"></el-table-column>
            <el-table-column prop="menuUrl" label="菜单路径"></el-table-column>
            <el-table-column prop="menuIcon" label="菜单图标"></el-table-column>
            <el-table-column label="子菜单">
                <template slot-scope="scope">
                    <span>{{ scope.row.menuSub == 0 ? "不拥有" : "拥有"}}</span>
                </template>
            </el-table-column>
            <el-table-column label="创建时间">
                <template slot-scope="scope">
                    <el-icon name="time"></el-icon>
                    <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="small" @click="openModifyMenu(scope.row)">编辑</el-button>
                    <el-button v-if="scope.row.menuSub == 1" size="small" type="primary" @click="openMenuInfo(scope.row)">子菜单详情</el-button>
                    <el-button size="small" type="danger" @click="delMenu(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
          </el-table>
      </div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="menuListReq.current"
        :page-sizes="[10, 20, 50, 100]" :page-size="menuListReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
      <el-dialog :title="dialogOpe.name" :visible.sync="dialogMenuVisible">
        <el-form :model="menu">
          <el-form-item label="菜单名称：" :label-width="formLabelWidth">
            <el-input v-model="menu.menuName" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="菜单链接地址：" :label-width="formLabelWidth">
            <el-input v-model="menu.menuUrl" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="菜单图标：" :label-width="formLabelWidth">
            <el-input v-model="menu.menuIcon" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="子菜单：" :label-width="formLabelWidth">
            <el-select v-model="menu.menuSub" placeholder="请选择是否拥有子菜单">
                <el-option v-for="item in menuSubOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
            </el-select>
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
  requestListMenu,
  requestAddMenu,
  requestModifyMenu,
  requestDelMenu
} from '../api/api';
export default {
  data() {
    return {
      menuListReq: {
        menuSearch: '',
        current: 1,
        size: 10
      },
      page: {
        totalNums: 1,
        totalPages: 1
      },
      menuListData: [],
      menu: {
        id: 0,
        menuName: 0,
        menuUrl: '',
        menuIcon: '',
        menuSub: 0
      },
      menuSubOptions: [
        {
          value: 0,
          label: '不拥有子菜单'
        },
        {
          value: 1,
          label: '拥有子菜单'
        }
      ],
      dialogOpe: {
        name: '菜单信息',
        status: 0 // 0：无，1：新增，2：编辑
      },
      dialogMenuVisible: false,
      formLabelWidth: '120px'
    };
  },
  methods: {
    getMenuList() {
      requestListMenu(this.menuListReq).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.menuListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    addMenu() {
      console.log(this.menu);
      requestAddMenu(this.menu).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.menuListData = data.data;
          this.getMenuList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
        this.dialogCancel();
      });
    },
    modifyMenu() {
      // console.log(this.menu);
      requestModifyMenu(this.menu).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.menuListData = data.data;
          this.getMenuList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
        this.dialogCancel();
      });
    },
    delMenu(id) {
      this.$confirm('此操作将永久删除该菜单以及相关数据，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestDelMenu({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '删除成功！'
            });
            this.getMenuList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    openMenuInfo(menu) {
      this.$router.push({
        path: '/app/menuInfo',
        query: { id: menu.id }
      });
    },
    openAddMenu() {
      // 新增字典
      this.menu = {};
      this.dialogOpe.name = '新增字典';
      this.dialogOpe.status = 1;
      this.dialogMenuVisible = true;
    },
    openModifyMenu(menu) {
      // 编辑字典
      this.menu = menu;
      this.dialogOpe.name = '编辑字典';
      this.dialogOpe.status = 2;
      this.dialogMenuVisible = true;
    },
    searchClick() {
      // 搜索
      this.getMenuList();
    },
    dialogCancel() {
      // 取消弹出框
      this.dialogOpe.name = '字典信息';
      this.dialogOpe.status = 0;
      this.dialogMenuVisible = false;
    },
    dialogConfirm(status) {
      console.log(status);
      // 确定弹出框
      switch (status) {
        case 1:
          this.addMenu();
          break;
        case 2:
          this.modifyMenu();
          break;
        default:
          this.dialogCancel();
          break;
      }
    },
    handleCurrentChange(val) {
      this.getMenuList();
    },
    handleSizeChange(val) {
      this.menuListReq.size = val;
      this.getMenuList();
    }
  },
  created() {
    this.getMenuList();
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
