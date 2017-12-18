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
          上周内容
        </div>
        <!-- <el-table :data="tableData" style="width: 100%">
          <el-table-column type="index" width="50">
          </el-table-column>
          <el-table-column prop="name" label="内容" :show-overflow-tooltip="true">
          </el-table-column>
          <el-table-column prop="province" label="开始-完成时间">
            <template slot-scope="scope">
              <el-icon name="time"></el-icon>
              <span style="margin-left: 10px">{{ scope.row.date }}</span>
            </template>
          </el-table-column>

          <el-table-column label="操作" width="200">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row)" type="text" size="small">完成</el-button>
              <el-button @click="handleClick(scope.row)" type="text" size="small">本周继续</el-button>
              <el-button @click="handleClick(scope.row)" type="text" size="small">取消</el-button>
            </template>
          </el-table-column>
        </el-table> -->
      </div>
      <div style="    margin-top: 40px;">
        <div class="title">
          本周内容
          <i class="el-icon-plus add" @click="addPlanItem" title="新增本周内容"></i>
        </div>
        <el-dialog title="添加本周计划" :visible.sync="addDialogVisible">
          <el-form>

          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="addDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addDialogVisible = false">确 定</el-button>
          </div>
        </el-dialog>
        <el-form>
          <el-table :data="planList" style="width: 100%">
            <el-table-column type="index" width="50">
            </el-table-column>
            <el-table-column label="内容">
              <template slot-scope="scope">
                <el-form-item :prop="planList[scope.$index].info">
                  <el-input type="textarea" v-model="planList[scope.$index].info" autosize style="margin:5px;"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="开始-完成时间">
              <template slot-scope="scope">
                <el-date-picker v-model="planList[scope.$index].endTime" type="daterange" placeholder="选择开始-完成时间">
                </el-date-picker>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="200">
              <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-form>
      </div>
      <div style="padding-top:20px;">
        <el-button type="primary" @click="submitForm">保存</el-button>
        <el-button onclick="window.history.go(-1)">取消</el-button>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        planList: [{
          info: '',
          endTime: '',
          startTime: '',
        }],
        addDialogVisible: false,
        value6: ''
      }
    },
    methods: {
      addPlanItem() {
        const item = {
          info: '',
          endTime: '',
          startTime: '',
        }
        this.planList.push(item)
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
    }
  }

</script>
