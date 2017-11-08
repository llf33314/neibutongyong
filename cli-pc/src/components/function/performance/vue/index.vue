<template>
  <div style="padding: 25px;">
    <el-tabs v-model="manage" type="card" @tab-click="handleClick" style="margin-bottom: 15px;">
      <el-tab-pane label="绩效总览" name="total"></el-tab-pane>
      <el-tab-pane label="组织关系设置" name="organize"></el-tab-pane>
      <el-tab-pane label="自评分" name="own"></el-tab-pane>
      <el-tab-pane label="直属领导评分" name="directly"></el-tab-pane>
      <el-tab-pane label="分管领导评级" name="branch"></el-tab-pane>
    </el-tabs>
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  data() {
    return {
      manage: 'total'
    };
  },
  methods: {
    getPower() {
      // 获取访问权限
    },
    handleClick(tab, event) {
      this.$router.push({ path: '/app/performance/' + tab.name });
    }
  },
  created() {
   this.manage = this.$route.name;
  }
};
</script>
