<template>
  <div class="top-bar" v-cloak>
    <div class="logo-box">
      <img class="logo" src="./../../../assets/img/logo.png" alt="">
    </div>
    <p class="left-name">管理控制台</p>
    <div class="right">
      <el-button  @click="exit">退出登录</el-button>
    </div>
    <!--<div class="right">
      <div :class="arrowState ? 'head-msg hover':'head-msg'" @click="showHeadMsg()">
        <span class="head"></span>
        <span class="name">风华<i :class="arrowState ? 'icon-name el-icon-arrow-down':'icon-name el-icon-arrow-up'"></i></span>
        <div v-if="arrowState" class="hide-img">
          <ul class="hide-item">
            <li>基本资料</li>
            <li>基本资料</li>
            <li>基本资料</li>
          </ul>
        </div>
      </div>
      <div class="exit" >退出</div>
    </div>-->
    <!--<el-breadcrumb style="line-height: 45px; padding-left: 10px;border-bottom: 1px solid #ece9e9;">
      <el-breadcrumb-item :to="{ path: '/menu' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>系统设置</el-breadcrumb-item>
    </el-breadcrumb>-->
  </div>
</template>

<script>
  export default {
    data:function(){
      return {
        arrowState:false
      }
    },
    methods:{
      /*
      * 返回前台首页
      * */
      returnBack:function(type){
        this.$router.push({path:'/stageIndex'})
      },
      /*
       * 退出系统
       * */
      exit:function(){
        window.localStorage.removeItem('tocken')
        this.$router.push({path:"/"})
      },
    }
  }
</script>
<style scoped>
  [v-cloak] {
    display: none;
  }
  .right{
    float: right;
    margin-top: 10px;
  }
  .right .el-button--primary {
    padding: 7px 15px;
  }
  .right .el-button {
    padding: 7px 15px;
    font-size: 12px;
  }
  .top-bar {
    position: absolute;
    width: 100%;
    background-color: #293038;
    height: 50px;
    z-index: 9999;
  }

  .logo-box {
    width: 64px;
    text-align: center;
    float: left;
  }

  .logo {
    height: 26px;
    margin-top: 12px;
  }
  .left-name{
    float: left;
    color: #fff;
    font-size: 14px;
    line-height: 50px;
    width: 136px;
    text-align: center;
    border-left:1px solid #333;
  }
  .right{
    float: right;
    padding-right: 30px;
    font-size: 14px;
  }
  .head-msg{
    border-bottom: 4px solid rgba(0,0,0,0);
    width: 110px;
    float: left;
    height: 56px;
    padding: 0 10px;
    transition: all .3s;
    -webkit-transition: all .3s;
    opacity: .8;
    position: relative;
  }

  .head{
    width: 46px;
    height: 46px;
    border-radius: 50%;
    margin-top: 7px;
    background-origin: content-box;
    background-position: center;
    background-size: cover;
    display: inline-block;
    cursor: pointer;

  }
  .hide-img{
    position: absolute;
    top: 62px;
    left: 0;
    width: 130px;
    cursor: pointer;
    z-index: 999;
  }
  .hide-item{
    line-height: 36px;
    min-width: 130px;
    box-shadow: 0 2px 4px rgba(0,0,0,.12);
    border: 1px solid #d2d2d2;
    background-color: #fff;
    z-index: 100;
    border-radius: 2px;
    white-space: nowrap;
    list-style: none;
  }
  .hide-item li{
    padding: 0 10px;
    cursor: pointer;
  }
  .hide-item li:hover{
    background-color: #dadada;

  }
  .name{
    line-height: 60px;
    height: 60px;
    color: #fff;
    margin: 0 5px 0 8px;
    cursor: pointer;
    display: inline-block;
    float: right;
  }
  .icon-name{
    font-size: 10px;
    padding: 0 5px;
    transition: all .3s;
    -webkit-transition: all .3s;
  }
  .exit{
    line-height: 56px;
    height: 56px;
    color: #fff;
    margin: 0 20px;
    float: left;
    opacity: .8;
    padding: 0 20px;
    cursor: pointer;
    border-bottom: 4px solid rgba(0,0,0,0);
    transition: all .3s;
    -webkit-transition: all .3s;
  }
  .hover{
    border-color:#42b983;
    opacity: 1;
  }
</style>
