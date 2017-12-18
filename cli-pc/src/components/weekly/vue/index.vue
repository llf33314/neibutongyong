<style lang="less">

</style>
<template>
  <div style="padding:20px;">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="我的" name="my"></el-tab-pane>
      <el-tab-pane label="全部" name="all"></el-tab-pane>
    </el-tabs>
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  data() {
    return {
      activeName: "my"
    };
  },
  watch: {
    activeName() {
      this.$router.push({
        path: "/weekly/" + this.activeName
      });
    }
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
};
</script>
