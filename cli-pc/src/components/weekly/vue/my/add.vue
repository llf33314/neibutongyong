<style lang="less">
.weekly-add {
  .title {
    line-height: 40px;
    border-bottom: 1px solid #ccc;
    margin: 20px 0;
    color: #666;
  }
  .add {
    font-size: 14px;
    color: #20a0ff;
    cursor: pointer;
    padding: 0 4px;
  }
}
</style>
<template>
  <div class="weekly-add">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item onclick="window.history.go(-1)">周报</el-breadcrumb-item>
      <el-breadcrumb-item>新增周报</el-breadcrumb-item>
    </el-breadcrumb>
    <div style="padding:20px;">
      <div>
        <div class="title">
          上周计划
        </div>
        <el-table :data="listLast" style="width: 100%">
          <el-table-column type="index" width="50">
          </el-table-column>
          <el-table-column prop="info" label="内容" :show-overflow-tooltip="true">
          </el-table-column>
          <el-table-column prop="startTime" label="开始时间">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ timeTransForm(scope.row.startTime, "yyyy-MM-dd")}}</span>
            </template>
          </el-table-column>
          <el-table-column prop="endTime" label="完成时间">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ timeTransForm(scope.row.endTime, "yyyy-MM-dd")}}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="200">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row)" type="text" size="small">完成</el-button>
              <el-button @click="goContinue(scope.row)" type="text" size="small">本周继续</el-button>
              <el-button @click="cencal(scope.row.id)" type="text" size="small">取消</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div style="    margin-top: 40px;">
        <div class="title">
          本周计划
          <i class="el-icon-plus add" @click="addPlanItem" title="新增本周计划"></i>
        </div>
        <el-dialog title="添加本周计划" :visible.sync="addDialogVisible">
          <el-form>

          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="addDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addDialogVisible = false">确 定</el-button>
          </div>
        </el-dialog>
        <el-form :model="data" ref="data">
          <el-table :data="data.planList" style="width: 100%">
            <el-table-column type="index" width="50">
            </el-table-column>
            <el-table-column label="内容">
              <template slot-scope="scope">
                <el-form-item  :prop="'planList.' + scope.$index + '.info'"
                :rules="{required: true, message: '计划内容不能为空', trigger: 'blur'}" style="margin-bottom:0">
                  <el-input type="textarea" v-model="data.planList[scope.$index].info" autosize placeholder="请输入计划内容" style="margin:5px"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="开始-完成时间">
              <template slot-scope="scope">
                <el-form-item  :prop="'planList.' + scope.$index + '.endTime'"
                :rules="{required: true, message: '开始-完成时间不能为空'}" style="margin-bottom:0">
                   <el-date-picker :clearable="false" v-model="data.planList[scope.$index].endTime" type="daterange"  style="margin:5px" placeholder="选择开始-完成时间">
                  </el-date-picker>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="200">
              <template slot-scope="scope">
                <el-button v-if="!scope.row.id" @click="handleClick(scope.row)" type="text" size="small">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-form>
      </div>
      <div style="padding-top:20px;">
        <el-button type="primary" @click="submitForm('data')">保存</el-button>
        <el-button onclick="window.history.go(-1)">取消</el-button>
      </div>
    </div>
  </div>
</template>
<script>
import { add, listLast, listThis } from "./../../api/index";
export default {
  data() {
    return {
      data: {
        planList: [
          {
            id: 361,
            info: "ceshi测试48",
            startTime: 1513587469983,
            endTime: 1532599879983
          }
        ]
      },
      listLast: [
        {
          id: 362,
          info: "ceshi测试48",
          startTime: 1513587469983,
          endTime: 1513587469983
        }
      ],
      listThis: [
        {
          id: 363,
          info: "ceshi测试48",
          startTime: 1513587469983,
          endTime: 1513587469983
        }
      ],
      addDialogVisible: false,
      value6: ""
    };
  },
  mounted() {
    this.data.planList.forEach(item => {
      item.endTime = [item.startTime, item.endTime];
    });
    return;
    listLast().then(res => {
      console.log(res, "获取上周周报信息");
    });
    listThis().then(res => {
      console.log(res, "获取上周周报信息");
    });
  },
  methods: {
    //取消周报
    cencal(id) {
      this.$prompt("请输入备注", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputErrorMessage: "请输入备注5-50",
        inputValidator: function(e) {
          if (e.length < 5 || e.length > 50) {
            return false;
          } else {
            return true;
          }
        }
      })
        .then(({ value }) => {
          
        })
        .catch(() => {});
    },
    //本周继续
    goContinue(item) {
      console.log(item);
      var flag = true;
      this.data.planList.forEach(it => {
        if (it.id == item.id) {
          flag = false;
        }
      });
      if (flag) {
        const t = window.JSON.parse(window.JSON.stringify(item));
        t.endTime = [t.startTime, t.endTime];
        this.data.planList.push(t);
      }
    },
    //新增一列
    addPlanItem() {
      const item = {
        info: "",
        endTime: "",
        startTime: ""
      };
      this.data.planList.push(item);
    },
    //保存
    submitForm(formName) {
      const allData = window.JSON.parse(
        window.JSON.stringify(this.data.planList)
      );
      allData.forEach(item => {
        const time = item.endTime;
        item.startTime = this.timeTransForm(time[0], "yyyy-MM-dd");
        item.endTime = this.timeTransForm(time[1], "yyyy-MM-dd");
      });
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(allData, "allData");
          add(allData).then(res => {
            console.log(res, "新增周报");
            if (res.code == 100) {
              this.$message({
                type: "success",
                message: res.msg,
                onClose: () => {
                  window.history.go(-1);
                }
              });
            } else {
              this.$message.error(res.msg);
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    }
  }
};
</script>
