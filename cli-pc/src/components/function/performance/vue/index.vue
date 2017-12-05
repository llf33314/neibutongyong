<template>
  <div style="padding: 20px;">
    <el-tabs v-model="manage" type="card" @tab-click="handleClick" style="margin-bottom: 15px;">
      <el-tab-pane label="绩效总览" name="total"></el-tab-pane>
      <el-tab-pane v-if="powerData.organizeSetFlag" label="组织关系设置" name="organize"></el-tab-pane>
      <el-tab-pane v-if="powerData.ownFlag" label="自评分" name="own"></el-tab-pane>
      <el-tab-pane v-if="powerData.directlyFlag" label="直属领导评分" name="directly"></el-tab-pane>
      <el-tab-pane v-if="powerData.branchFlag" label="分管领导评级" name="branch"></el-tab-pane>
    </el-tabs>
    <router-view></router-view>
  </div>
</template>
<script>
import { requestGetPower } from '../api/api';
export default {
  data() {
    return {
      manage: 'total',
      powerData: {}
    };
  },
  methods: {
    getPower() {
      // 获取访问权限
      requestGetPower().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.powerData = data.data;
          console.log(this.powerData);
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    handleClick(tab, event) {
      this.$router.push({ path: '/app/performance/' + tab.name });
    }
  },
  created() {
    this.manage = this.$route.name;
    this.getPower();
  }
};
</script>
