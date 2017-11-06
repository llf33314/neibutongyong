// 自评分
<template>                 
  <div>
    <span>{{checkOwnInfoData.userName}}自评分，当前月份：{{checkOwnInfoData.monthDate}}</span>
    <el-table :data="listStaticInfoData" border show-summary style="width: 100%">
      <el-table-column type="index" label="评分项" width="180"></el-table-column>
      <el-table-column prop="performanceName" label="评级纬度"></el-table-column>
      <el-table-column prop="performanceContent" label="评价内容">
        <template slot-scope="scope">
          <el-input v-if="ownModifyBoolean == true && scope.row.status == 0" v-model="scope.row.performanceContent"type="textarea" 
           auto-complete="off" placeholder="主要工作项目或内容/完成标准（100字以内）"></el-input>
           <span v-else>{{scope.row.performanceContent == '' ? "无" : scope.row.performanceContent}}</span>
        </template>
      </el-table-column>
      <el-table-column prop="performanceScore" label="标准分"></el-table-column>
      <el-table-column prop="ownScore" label="自评分">
        <template slot-scope="scope">
          <span v-if="ownModifyBoolean == false">{{scope.row.ownScore == '' || scope.row.ownScore == null ? "请点击下方按钮进行评分" : scope.row.ownScore}}</span>
          <el-input v-else-if="ownModifyBoolean == true" v-model="scope.row.ownScore" type="number" auto-complete="off" placeholder="不能超出标准分"></el-input>
        </template>
      </el-table-column>
    </el-table>
    <div v-if="checkOwnInfoData.checkOwnInfoBoolean == false">
      <el-button type="primary" @click="modifyOwn()" v-if="ownModifyBoolean == false">自评分</el-button>
      <el-button type="success" @click="endOwn()" v-if="ownModifyBoolean == true">评分完成</el-button>
      <el-button type="success" @click="uploadOwn()" v-if="ownModifyBoolean == false">保存并上传评分</el-button>
    </div>
  </div>
</template>
<script>
import {
  requestListStaticInfo,
  requestCheckOwnInfo,
  requestListOwnInfo,
  requestAddOwn
} from '../api/api';
export default {
  data() {
    return {
      ownModifyBoolean: false,
      listStaticInfoData: [
        {
          status: 0,
          performanceName: '工作业绩（60分）',
          performanceContent: '',
          performanceScore: 60,
          ownScore: ''
        }
      ],
      checkOwnInfoData: {
        userName: '',
        checkOwnInfoBoolean: true, // true：已评，false：未评
        monthDate: ''
      },
      Boolean: false
    };
  },
  methods: {
    listStaticInfo() {
      // 获取必填信息（未评）
      requestListStaticInfo().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.listStaticInfoData = this.listStaticInfoData.concat(data.data);
          console.log(this.listStaticInfoData);
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    listOwnInfo() {
      // 获取信息（已评）
      requestListOwnInfo().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.listStaticInfoData = data.data;
          console.log(this.listStaticInfoData);
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    checkOwnInfo() {
      // 获取用户信息
      requestCheckOwnInfo().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.checkOwnInfoData = data.data;
          if (this.checkOwnInfoData.checkOwnInfoBoolean == true) {
            // 已评
            this.listOwnInfo();
          } else {
            // 未评
            this.listStaticInfo();
          }
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    addOwn() {
      // 新增自评分信息
      requestAddOwn(this.listStaticInfoData).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.$message({
            message: '操作成功',
            type: 'success'
          });
          this.checkOwnInfo();
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    modifyOwn() {
      this.ownModifyBoolean = true;
    },
    endOwn() {
      this.ownModifyBoolean = false;
    },
    uploadOwn() {
      this.$confirm('上传评分后将不可修改，是否继续上传？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.addOwn();
      });
    }
  },
  created() {
    this.checkOwnInfo();
  }
};
</script>