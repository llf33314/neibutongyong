<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>
  export default {
    name: 'app',
    
  }

</script>

<style>
  * {
    padding: 0;
    margin: 0
  }

  html,
  body {
    min-width: 1100px;
    overflow-x: auto;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", -apple-system, BlinkMacSystemFont, "PingFang SC", "Helvetica Neue", STHeiti, "Microsoft Yahei", "微软雅黑", Tahoma, Simsun, sans-serif;
  }

  .el-pagination {
    float: right;
    margin-top: 20px;
  }

  .a-admin-head {
    padding: 10px 0 20px;
  }

</style>
