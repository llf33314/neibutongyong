<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>
  export default {
    name: 'app',
    data() {
      return {

      }
    },
    watch: {
      '$route' (to, from) {
        const toDepth = to.path.split('/').length
        const fromDepth = from.path.split('/').length
        this.transitionName = toDepth < fromDepth ? 'slide-right' : 'slide-left'
      }
    },

  }

</script>

<style>
  * {
    padding: 0;
    margin: 0
  }

  #app {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
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
    margin-bottom: 20px;
  }

  .a-admin-head {
    padding: 10px 0 20px;
  }

</style>
