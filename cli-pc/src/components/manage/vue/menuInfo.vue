<template>
  <div>
    <div>
        <div class="a-list-top">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/app/menu' }">子菜单列表</el-breadcrumb-item>
                <el-breadcrumb-item>子菜单详情</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="a-list-head">
            <el-button type="primary" @click="openAddMenuSub" style="margin-right: 20px;">新增</el-button>
            <el-input placeholder="子菜单详情编号/子菜单详情内容" icon="search" v-model="menuSubListReq.menuSearch" :on-icon-click="searchClick" style="width:250px!important;"></el-input>
        </div>
    <div class="a-admin-table">
      <el-table :data="menuSubListData" border highlight-current-row style="width: 100%">
        <el-table-column type="index" width="50"></el-table-column>
        <el-table-column prop="infoContent" label="详情内容"></el-table-column>
        <el-table-column prop="infoCode" label="详情编号"></el-table-column>
        <el-table-column prop="infoRemark" label="详情描述"></el-table-column>
        <el-table-column label="创建时间">
          <template slot-scope="scope">
            <el-icon name="time"></el-icon>
            <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="small" @click="openModifyMenuSub(scope.row)">编辑</el-button>
            <el-button size="small" type="danger" @click="delMenuSub(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="menuSubListReq.current" 
        :page-sizes="[10, 20, 50, 100]" :page-size="menuSubListReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
      <el-dialog :title="dialogOpe.name" :visible.sync="dialogMenuSubVisible">
        <el-form :model="menuSub">
          <el-form-item label="子菜单详情编号" :label-width="formLabelWidth">
            <el-input v-model="menuSub.infoCode" auto-complete="off" placeholder="4位数字"></el-input>
          </el-form-item>
          <el-form-item label="子菜单详情内容" :label-width="formLabelWidth">
            <el-input v-model="menuSub.infoContent" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="子菜单详情描述" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="menuSub.infoRemark" placeholder="25字以内"></el-input>
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
  requestListMenuSub,
  requestAddMenuSub,
  requestModifyMenuSub,
  requestDelMenuSub
} from '../api/api';
export default {
  data() {
    return {
      menuSubListReq: {
        menuId: 0,
        menuSearch: '',
        current: 1,
        size: 2
      },
      page: {
        totalNums: 1,
        totalPages: 1
      },
      menuSubListData: [],
      menuSub: {
        id: 0,
        menuId: 0,
        infoCode: 0,
        infoContent: '',
        infoRemark: ''
      },
      dialogOpe: {
        name: '子菜单信息',
        status: 0 // 0：无，1：新增，2：编辑
      },
      dialogMenuSubVisible: false,
      formLabelWidth: '120px'
    };
  },
  methods: {
    getMenuSubList() {
      requestListMenuSub(this.menuSubListReq).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.menuSubListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    addMenuSub() {
      // console.log(this.menuSub);
      this.menuSub.menuId = this.menuSubListReq.menuId;
      requestAddMenuSub(this.menuSub).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.menuSubListData = data.data;
          this.getMenuSubList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
        this.dialogCancel();
      });
    },
    modifyMenuSub() {
      // console.log(this.menuSub);
      requestModifyMenuSub(this.menuSub).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.menuSubListData = data.data;
          this.getMenuSubList();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
        this.dialogCancel();
      });
    },
    delMenuSub(id) {
      this.$confirm('此操作将永久删除该条数据，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestDelMenuSub({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '您已删除数据！'
            });
            this.getMenuSubList();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    openAddMenuSub() {
      // 新增子菜单详情
      this.menuSub = {};
      this.dialogOpe.name = '新增子菜单';
      this.dialogOpe.status = 1;
      this.dialogMenuSubVisible = true;
    },
    openModifyMenuSub(menuSub) {
      // 编辑子菜单详情
      this.menuSub = menuSub;
      this.dialogOpe.name = '编辑子菜单';
      this.dialogOpe.status = 2;
      this.dialogMenuSubVisible = true;
    },
    searchClick() {
      // 搜索
      this.getMenuSubList();
    },
    dialogCancel() {
      // 取消弹出框
      this.dialogOpe.name = '子菜单信息';
      this.dialogOpe.status = 0;
      this.dialogMenuSubVisible = false;
    },
    dialogConfirm(status) {
      console.log(status);
      // 确定弹出框
      switch (status) {
        case 1:
          this.addMenuSub();
          break;
        case 2:
          this.modifyMenuSub();
          break;
        default:
          this.dialogCancel();
          break;
      }
    },
    handleCurrentChange(val) {
      this.getMenuSubList();
    }
  },
  created() {
    this.menuSubListReq.menuId = this.$route.query.id;
    this.getMenuSubList();
  }
};
</script>


<style>
.a-list-top {
  padding: 25px;
}
.a-list-head {
  padding: 0 0 35px 25px;
}
.a-admin-table {
  margin: 0 25px 25px;
}
</style>
