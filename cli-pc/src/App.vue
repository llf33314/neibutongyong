<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  name: 'app'
}
</script>

<style>
*{padding: 0;margin: 0}
.el-submenu__icon-arrow {
  margin-top: -4px;
}
.el-message{
  top:70px;
}
body{
  overflow-x: hidden;
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB",-apple-system, BlinkMacSystemFont, "PingFang SC","Helvetica Neue",STHeiti,"Microsoft Yahei","微软雅黑",Tahoma,Simsun,sans-serif;
}
/*定义滚动条宽高及背景，宽高分别对应横竖滚动条的尺寸*/
.content::-webkit-scrollbar{
  width: 5px;
  background-color: #fff;
}
/*定义滚动条的轨道，内阴影及圆角*/
.content::-webkit-scrollbar-track{
  background-color: #fff;
}
/*定义滑块，内阴影及圆角*/
.content::-webkit-scrollbar-thumb{
  /*width: 10px;*/
  height: 10px;
  border-radius: 3px;
  background-color: #ccc;
}
</style>
