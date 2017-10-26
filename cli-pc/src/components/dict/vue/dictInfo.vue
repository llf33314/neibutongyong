<template>
  <div>
    <div>
        <div class="a-list-top">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/app/dict' }">字典列表</el-breadcrumb-item>
                <el-breadcrumb-item>字典详情</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="a-list-head">
            <el-button type="primary" @click="openAddDictInfo" style="margin-right: 20px;">新增</el-button>
            <el-input placeholder="字典详情编号/字典详情内容" icon="search" v-model="dictInfoListReq.dictSearch" :on-icon-click="searchClick" style="width:250px!important;"></el-input>
        </div>
    <div class="a-admin-table">
      <el-table :data="dictInfoListData" border highlight-current-row style="width: 100%">
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
                <el-button size="small" @click="openModifyDictInfo(scope.row)">编辑</el-button>
                <el-button size="small" type="danger" @click="delDictInfo(scope.row.id)">删除</el-button>
            </template>
        </el-table-column>
      </el-table>
    </div>
      <el-pagination @current-change="handleCurrentChange"
        :current-page.sync="dictInfoListReq.current" :page-size="dictInfoListReq.size" layout="total, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
      <el-dialog :title="dialogOpe.name" :visible.sync="dialogDictInfoVisible">
        <el-form :model="dictInfo">
          <el-form-item label="字典详情编号" :label-width="formLabelWidth">
            <el-input v-model="dictInfo.infoCode" auto-complete="off" placeholder="4位数字"></el-input>
          </el-form-item>
          <el-form-item label="字典详情内容" :label-width="formLabelWidth">
            <el-input v-model="dictInfo.infoContent" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="字典详情描述" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="dictInfo.infoRemark" placeholder="25字以内"></el-input>
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
import { requestListDictInfo, requestAddDictInfo, requestModifyDictInfo, requestDelDictInfo } from "../api/api";
export default {
  data() {
    return {
      dictInfoListReq: {
        dictId: 0,
        dictSearch: "",
        current: 1,
        size: 10
      },
      page: {
        totalNums: 1,
        totalPages: 1
      },
      dictInfoListData: [],
      dictInfo: {
        id: 0,
        dictId: 0,
        infoCode: 0,
        infoContent: "",
        infoRemark: ""
      },
      dialogOpe: {
        name: "字典信息",
        status: 0 // 0：无，1：新增，2：编辑
      },
      dialogDictInfoVisible: false,
      formLabelWidth: "120px"
    };
  },
  methods: {
    getDictInfoList() {
      requestListDictInfo(this.dictInfoListReq).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.dictInfoListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    },
    addDictInfo() {
      // console.log(this.dictInfo);
      this.dictInfo.dictId = this.dictInfoListReq.dictId;
      requestAddDictInfo(this.dictInfo).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.dictInfoListData = data.data;
          this.getDictInfoList();
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
        this.dialogCancel();
      });
    },
    modifyDictInfo() {
      // console.log(this.dictInfo);
      requestModifyDictInfo(this.dictInfo).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.dictInfoListData = data.data;
          this.getDictInfoList();
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
        this.dialogCancel();
      });
    },
    delDictInfo(id) {
      this.$confirm("此操作将永久删除该条数据，是否继续？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        requestDelDictInfo({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: "success",
              message: "您已删除数据！"
            });
            this.getDictInfoList();
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
        });
      });
    },
    openAddDictInfo() {
      // 新增字典详情
      this.dictInfo = {};
      this.dialogOpe.name = "新增字典";
      this.dialogOpe.status = 1;
      this.dialogDictInfoVisible = true;
    },
    openModifyDictInfo(dictInfo) {
      // 编辑字典详情
      this.dictInfo = dictInfo;
      this.dialogOpe.name = "编辑字典";
      this.dialogOpe.status = 2;
      this.dialogDictInfoVisible = true;
    },
    searchClick() {
      // 搜索
      this.getDictInfoList();
    },
    dialogCancel() {
      // 取消弹出框
      this.dialogOpe.name = "字典信息";
      this.dialogOpe.status = 0;
      this.dialogDictInfoVisible = false;
    },
    dialogConfirm(status) {
      console.log(status);
      // 确定弹出框
      switch (status) {
        case 1:
          this.addDictInfo();
          break;
        case 2:
          this.modifyDictInfo();
          break;
        default:
          this.dialogCancel();
          break;
      }
    },
    handleCurrentChange(val) {
      this.getDictInfoList();
    }
  },
  created() {
    this.dictInfoListReq.dictId = this.$route.query.id;
    this.getDictInfoList();
  }
};
</script>


<style>
.a-list-top{
    padding:25px;
}
.a-list-head{
    padding: 0 0 35px 25px;
}
.a-admin-table{
  margin:0 25px 25px;;
}
</style>
