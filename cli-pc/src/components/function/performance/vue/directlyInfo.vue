// 直属领导评分
<template>
  <div>
    <span class="a-gt-own-span">评分员工：{{staffInfo.staffName}}</span>
    <el-table :data="directlyInfoListData" border show-summary style="width: 100%">
      <el-table-column type="index" label="评分项" width="180"></el-table-column>
      <el-table-column prop="performanceName" label="评级纬度"></el-table-column>
      <el-table-column prop="performanceContent" label="评价内容"></el-table-column>
      <el-table-column prop="performanceScore" label="标准分"></el-table-column>
      <el-table-column prop="ownScore" label="自评分"></el-table-column>
      <el-table-column prop="directlyScore" label="直属领导评分">
        <template slot-scope="scope">
          <span v-if="directlyModifyBoolean == false">{{scope.row.directlyScore == null || scope.row.directlyScore == '' ? "请点击下方按钮进行评分" : scope.row.directlyScore}}</span>
          <el-input v-else-if="directlyModifyBoolean == true" v-model="scope.row.directlyScore" type="number" auto-complete="off" placeholder="不能超出标准分"></el-input>
        </template>
      </el-table-column>
    </el-table>
    <el-button type="primary" @click="modifyDirectly()" v-show="directlyModifyBoolean == false" style="margin-top: 25px;">直属领导评分</el-button>
    <el-button type="success" @click="endDirectly()" v-show="directlyModifyBoolean == true" style="margin-top: 25px;">评分完成</el-button>
    <el-button type="success" @click="uploadOwn()" v-show="directlyModifyBoolean == false" style="margin-top: 25px;">保存并上传评分</el-button>
  </div>
</template>
<script>
import { requestListDirectlyInfo, requestAddDirectly } from '../api/api';
export default {
  data() {
    return {
      directlyModifyBoolean: false,
      staffInfo: {},
      listDirectlyInfoReq: {
        staffId: ''
      },
      directlyInfoListData: [],
      addDirectlyInfoReq: {
        staffId: '',
        addDirectlyReqList: []
      }
    };
  },
  methods: {
    listDirectlyInfo() {
      // 分页获取组织关系
      requestListDirectlyInfo(this.listDirectlyInfoReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.directlyInfoListData = data.data;
          console.log(this.directlyInfoListData);
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    addDirectly() {
      // 新增直属领导评分信息
      this.addDirectlyInfoReq.addDirectlyReqList = this.directlyInfoListData;
      console.log(this.addDirectlyInfoReq);
      requestAddDirectly(this.addDirectlyInfoReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.$message({
            message: '评分完成',
            type: 'success'
          });
          this.$router.push({
            path: '/app/performance/directly'
          });
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    modifyDirectly() {
      this.directlyModifyBoolean = true;
    },
    endDirectly() {
      this.directlyModifyBoolean = false;
    },
    uploadOwn() {
      var _checkData = this.directlyInfoListData;
      console.log(_checkData);
      for (var i = 0; i < _checkData.length; i++) {
        if (
          _checkData[i].directlyScore == '' ||
          _checkData[i].directlyScore == null
        ) {
          this.$message({
            message: '请先完成评分!',
            type: 'warning'
          });
          return;
        }
      }
      this.$confirm('上传评分后将不可修改，是否继续上传？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.addDirectly();
      });
    }
  },
  created() {
    this.staffInfo = this.$route.query;
    this.listDirectlyInfoReq.staffId = this.$route.query.staffId;
    this.addDirectlyInfoReq.staffId = this.$route.query.staffId;
    this.listDirectlyInfo();
  }
};
</script>
<style type="text/css" scoped>
.a-gt-own-span {
  font-size: 14px;
  color: #666;
  display: block;
  padding: 0 18px 25px;
}
</style>
