<template>
  <div>
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
              <el-table-column label="操作">
                  <template slot-scope="scope">
                      <el-button size="small" @click="openModifyDepart(scope.row)">编辑</el-button>
                      <el-button size="small" type="danger" @click="delDepart(scope.row.id)">删除</el-button>
                  </template>
              </el-table-column>
            </el-table>
      </div>
      <el-pagination @current-change="handleCurrentChange"
        :current-page.sync="departmentListReq.current" :page-size="departmentListReq.size" layout="total, prev, pager, next" :total="page.totalNums">
      </el-pagination>
    </div>
    <div>
     <el-dialog :title="dialogOpe.name" :visible.sync="dialogFormVisible">
        <el-form :model="departmentAddReq">
          <el-form-item label="部门名称" :label-width="formLabelWidth">
            <el-input v-model="departmentAddReq.depName" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="部门地址" :label-width="formLabelWidth">
            <el-input v-model="departmentAddReq.depAdd" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="部门描述" :label-width="formLabelWidth">
            <el-input v-model="departmentAddReq.depRemark" type="textarea" placeholder="25字以内"></el-input>
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
import { requestListDepartInfo, requestAddDepartInfo, requestDelDepart ,requestModifyDepart} from "../api/api";
export default {
  data() {
    return {
       departmentListReq: {   //部门列表-对象
         departmentSearch :"",
         current: 1,
         size: 8
       },
       page:{   //分页
        totalNums: 1,
        totalPages: 1
      },

      departmentListData:[],  //部门数组对象

      dialogFormVisible: false,

      departmentAddReq :{  //新增对象
        depAdd : "",
        depName  : "",
        depRemark : ""
      },
      dialogOpe: {  //确定判断状态
        status: 0 // 0：无，1：新增，2：编辑
      },
     formLabelWidth: "120px"
    };
  },
  methods: {
    ListDepartpartment(){    //分页获取部门列表
      requestListDepartInfo(this.departmentListReq).then(data => {  
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.departmentListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
          console.log(this.departmentListData);
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    },
    AddDepartpartment(){  //新增部门列表
      console.log(this.departmentAddReq);
      requestAddDepartInfo(this.departmentAddReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.ListDepartpartment();
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    },
    ModifyDepartpartment(){  // 修改部门列表
      console.log(this.departmentAddReq);
      requestModifyDepart(this.departmentAddReq).then(data => {
        console.log(this.departmentAddReq);
        var _code = data.code;
         if (_code == 100) {
          this.departmentListData = data.data;
          this.ListDepartpartment();
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    },
    
    openAddDepart(){  //新增事件
      this.dialogOpe.name = "新增部门";
      this.departmentAddReq = {};
      this.dialogOpe.status = 1;  
      this.dialogFormVisible = true;
    },
    searchClick(){ //搜索事件
      this.ListDepartpartment();
    },
    handleCurrentChange(){  //分页
      this.ListDepartpartment();

    },
    dialogConfirm(status){
      console.log(status)
       console.log(this.depRemark)
      console.log(this.depRemark)
      if(status == 1){
        this.AddDepartpartment();
      }
      else if(status == 2){
        this.ModifyDepartpartment();
      }
      this.dialogFormVisible = false;
    },
    openModifyDepart(departmentAddReq){   //编辑事件
      this.dialogOpe.name = "编辑部门";
      console.log(55656)
      this.departmentAddReq = departmentAddReq;
      this.dialogOpe.status = 2;
      this.dialogFormVisible = true;

    },
    delDepart(id){   //删除事件
      console.log(555)
      this.$confirm('此操作将永久删除该部门, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          requestDelDepart({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: "success",
              message: "您已删除该部门及其详情数据！"
            });
            this.ListDepartpartment();
          } else {
            this.$message.error(data.msg + "[错误码：" + _code + "]");
          }
        });
      });
    }
  },
  created(){
    this.ListDepartpartment();
  }
};
</script>
<style>
.el-dialog__body {
    padding: 30px 25px 0 0;
    color: #48576a;
    font-size: 14px;
}
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
