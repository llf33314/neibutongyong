<template>
  <section class="container">
    <div class="top-bar" v-cloak>
      <div class="logo-box">
        <img class="logo" src="../../../assets/logo.png" alt="">
      </div>
      <p class="left-name">多粉管理控制台</p>
      <div class="right">
        <el-button @click="loginOut()">退出登录</el-button>
      </div>
    </div>
    <div class="menus">
      <div class="open-menu" @click="isCollapse = !isCollapse">
        <i class="iconfont gt-caidan"></i>
      </div>
      <el-menu :default-active="activeIndex" class="el-menu-vertical-demo" theme="dark" @open="handleOpen" @close="handleClose"
        :collapse="isCollapse">
        <el-menu-item index="0" @click="gtToRouter('/index')">
          <i class="iconfont gt-shouye"></i>
          <span slot="title">首页</span>
        </el-menu-item>

        <el-menu-item v-for="(menus, index) in menusList" :key="menus.menuUrl" v-show="menus.menuSub == 0" :index="index+'m'" 
          @click="gtToRouter(menus.menuUrl)">
          <i :class="'iconfont ' + menus.menuIcon"></i>
          <span slot="title">{{menus.menuName}}</span>
        </el-menu-item>

        <el-submenu v-for="(menus, index) in menusList" :key="menus.menuUrl" :index="index+'m'" v-show="menus.menuSub == 1">
            <template slot="title">
              <i :class="'iconfont ' + menus.menuIcon"></i>
              <span slot="title">{{menus.menuName}}</span>
            </template>
            <el-menu-item-group v-for="(subMenu, subIndex) in menus.subMenuList" :key="subMenu.menuUrl">
              <el-menu-item :index="index + '-' + subIndex" @click="gtToRouter(subMenu.menuUrl)">
                {{subMenu.menuName}}
              </el-menu-item>
            </el-menu-item-group>
        </el-submenu>
                
      </el-menu>
    </div>
    <div class="content">
      <section style="padding:50px 0;">
        <router-view></router-view>
      </section>
    </div>
  </section>
</template>

<script>
import { requestSSOLoginOut, requestUserMenu } from "../api/api";
export default {
  name: "menu",
  data() {
    return {
      isCollapse: false,
      activeIndex: "0",
      breadcrumb: {
        path: {},
        name: "",
        itemName: ""
      },
      menusList: [
        {
          menuUrl: "",
          menuName: "",
          menuIcon: ""
        }
      ]
    };
  },
  methods: {
    gtToRouter(menuRouter) {
      console.log(menuRouter);
      this.$router.push({ path: menuRouter });
    },
    handleOpen() {},
    handleClose() {},
    loginOut() {
      requestSSOLoginOut().then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          localStorage.removeItem("token");
          this.$router.replace({
            path: "/index",
            query: { redirect: this.$router.currentRoute.fullPath }
          });
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    },
    getUserMenus() {
      requestUserMenu().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.menusList = data.data;
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    }
  },
  created() {
    this.getUserMenus();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.right {
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

.left-name {
  float: left;
  color: #fff;
  font-size: 14px;
  line-height: 50px;
  width: 136px;
  text-align: center;
  border-left: 1px solid #333;
}

.right {
  float: right;
  padding-right: 30px;
  font-size: 14px;
}

.head-msg {
  border-bottom: 4px solid rgba(0, 0, 0, 0);
  width: 110px;
  float: left;
  height: 56px;
  padding: 0 10px;
  transition: all 0.3s;
  -webkit-transition: all 0.3s;
  opacity: 0.8;
  position: relative;
}

.head {
  width: 46px;
  height: 46px;
  border-radius: 50%;
  margin-top: 7px;
  background-image: url("../../../assets/head.jpg");
  background-origin: content-box;
  background-position: center;
  background-size: cover;
  display: inline-block;
  cursor: pointer;
}

.hide-img {
  position: absolute;
  top: 62px;
  left: 0;
  width: 130px;
  cursor: pointer;
  z-index: 999;
}

.hide-item {
  line-height: 36px;
  min-width: 130px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12);
  border: 1px solid #d2d2d2;
  background-color: #fff;
  z-index: 100;
  border-radius: 2px;
  white-space: nowrap;
  list-style: none;
}

.hide-item li {
  padding: 0 10px;
  cursor: pointer;
}

.hide-item li:hover {
  background-color: #dadada;
}

.name {
  line-height: 60px;
  height: 60px;
  color: #fff;
  margin: 0 5px 0 8px;
  cursor: pointer;
  display: inline-block;
  float: right;
}

.icon-name {
  font-size: 10px;
  padding: 0 5px;
  transition: all 0.3s;
  -webkit-transition: all 0.3s;
}

.exit {
  line-height: 56px;
  height: 56px;
  color: #fff;
  margin: 0 20px;
  float: left;
  opacity: 0.8;
  padding: 0 20px;
  cursor: pointer;
  border-bottom: 4px solid rgba(0, 0, 0, 0);
  transition: all 0.3s;
  -webkit-transition: all 0.3s;
}

.hover {
  border-color: #42b983;
  opacity: 1;
}

.open-menu {
  height: 30px;
  width: 100%;
  background: #4a5064;
  color: #aeb9c2;
  text-align: center;
  line-height: 30px !important;
  font-size: 12px;
  user-select: none;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.container {
  background-color: #293038;
  position: absolute;
  width: 100%;
  height: 100%;
  overflow: hidden;
  top: 0;
  left: 0;
}

.menus {
  float: left;
  padding-top: 60px;
}

.el-menu-vertical-demo {
  background-color: #293038;
}

.iconfont {
  vertical-align: baseline;
  margin-right: 10px;
}

.content {
  overflow: hidden;
  background-color: #fff;
  overflow-x: hidden;
  background-color: #fff;
  overflow-y: auto;
  height: 100%;
}

.el-breadcrumb {
  line-height: 45px;
  border-bottom: 1px solid rgb(236, 233, 233);
  padding: 0px 10px;
  position: absolute;
  width: 100%;
  z-index: 999;
  background-color: #fff;
}
</style>
