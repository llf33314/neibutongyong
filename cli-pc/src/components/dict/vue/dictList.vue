<template>
  <div>
    <div>
      <div class="a-admin-head">
        <el-button type="primary" @click="openAddDict" style="margin-right:15px;">新增</el-button>
        <el-input placeholder="字典编号/字典名" icon="search" v-model="dictListReq.dictSearch" :on-icon-click="searchClick" style="width:250px;"></el-input>
      </div>
      <div class="a-admin-table">
          <el-table :data="dictListData" border highlight-current-row style="width: 100%">
            <el-table-column type="index" width="50"></el-table-column>
            <el-table-column prop="dictName" label="名称"></el-table-column>
            <el-table-column prop="dictRemark" label="描述"></el-table-column>
            <el-table-column label="创建时间">
                <template slot-scope="scope">
                    <el-icon name="time"></el-icon>
                    <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="small" @click="openModifyDict(scope.row)">编辑</el-button>
                    <el-button size="small" type="primary" @click="openDictInfo(scope.row)">字典详情</el-button>
                    <el-button size="small" type="danger" @click="delDict(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
          </el-table>
      </div>
      <el-pagination @current-change="handleCurrentChange"
        :current-page.sync="dictListReq.current" :page-size="dictListReq.size" layout="total, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
      <el-dialog :title="dialogOpe.name" :visible.sync="dialogDictVisible">
        <el-form :model="dict">
          <el-form-item label="字典编号" :label-width="formLabelWidth">
            <el-input v-model="dict.dictCode" auto-complete="off" placeholder="4位数字"></el-input>
          </el-form-item>
          <el-form-item label="字典名称" :label-width="formLabelWidth">
            <el-input v-model="dict.dictName" auto-complete="off" placeholder="10字以内"></el-input>
          </el-form-item>
          <el-form-item label="字典描述" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="dict.dictRemark" placeholder="25字以内"></el-input>
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
import { requestListDict, requestAddDict, requestModifyDict, requestDelDict } from "../api/api";
export default {
  data() {
    return {
      dictListReq: {
        dictSearch: "",
        current: 1,
        size: 10
      },
      page:{
        totalNums: 1,
        totalPages: 1
      },
      dictListData: [],
      dict: {
        id: 0,
        dictCode: 0,
        dictName: "",
        dictRemark: ""
      },
      dialogOpe: {
        name: "字典信息",
        status: 0 // 0：无，1：新增，2：编辑
      },
      dialogDictVisible: false,
      formLabelWidth: "120px"
    };
  },
  methods: {
    getDictList() {
      requestListDict(this.dictListReq).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.dictListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    },
    addDict() {
      // console.log(this.dict);
      requestAddDict(this.dict).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.dictListData = data.data;
          this.getDictList();
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
        this.dialogCancel();
      });
    },
    modifyDict() {
      // console.log(this.dict);
      requestModifyDict(this.dict).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.dictListData = data.data;
          this.getDictList();
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
        this.dialogCancel();
      });
    },
    delDict(id){
      this.$confirm("此操作将永久删除该字典以及详情数据，是否继续？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        requestDelDict({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: "success",
              message: "您已删除该字典及其详情数据！"
            });
            this.getDictList();
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
        });
      });
    },
    openDictInfo(dict){
      this.$router.push({
        path: "/app/dictInfo",
        query: {id: dict.id}
      });
    },
    openAddDict() {
      // 新增字典
      this.dict = {};
      this.dialogOpe.name = "新增字典";
      this.dialogOpe.status = 1;
      this.dialogDictVisible = true;
    },
    openModifyDict(dict) {
      // 编辑字典
      this.dict = dict;
      this.dialogOpe.name = "编辑字典";
      this.dialogOpe.status = 2;
      this.dialogDictVisible = true;
    },
    searchClick() {
      // 搜索
      this.getDictList();
    },
    dialogCancel() {
      // 取消弹出框
      this.dialogOpe.name = "字典信息";
      this.dialogOpe.status = 0;
      this.dialogDictVisible = false;
    },
    dialogConfirm(status) {
      console.log(status);
      // 确定弹出框
      switch (status) {
        case 1:
          this.addDict();
          break;
        case 2:
          this.modifyDict();
          break;
        default:
          this.dialogCancel();
          break;
      }
    },
    handleCurrentChange(val) {
      this.getDictList();
    }
  },
  created() {
    this.getDictList();
  }
};
</script>
<style>
.a-admin-head{
    padding: 35px 0 35px 25px;
}
.a-admin-table{
  margin:0 25px 25px;;
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
    box-shadow: 0 1px 3px rgba(0,0,0,.3);
    box-sizing: border-box;
    margin-bottom: 50px;
    margin-left: 80px;
    margin-top: 165px;
}
</style>
