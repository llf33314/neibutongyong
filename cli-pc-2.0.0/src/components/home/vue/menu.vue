<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less">
  .home-menu {
    width: 100%;
    height: 100%;
    position: absolute;
    .menu-left {
      height: 100%;
      position: fixed;
      top: 0;
      left: 0;
      z-index: 21;
      -webkit-transition: width .5s;
      transition: width .5s;
    }
    .menu-left-c {
      height: 100%;
      width: 100%;
      background: #495060;
      .el-menu {
        background: #495060;
      }
      .iconfont {
        padding-right: 10px;
        font-size: 14px;
      }
      .el-submenu {
        span {
          font-size: 14px;
        }
        .el-submenu__icon-arrow {
          font-size: 10px;
        }
        .el-menu-item.is-active {
          color: #fff;
          background: #2d8cf0!important;
        }
      }
      .el-menu--horizontal.el-menu--dark .el-submenu .el-menu-item.is-active,
      .el-menu-item.is-active {
        color: #fff;
        background: #2d8cf0!important;
      }
      .menus-logo-box {
        height: 65px;
        text-align: center;
        img {
          margin-top: 11px;
        }
      }
    }

    .menu-top {
      box-sizing: border-box;
      position: fixed;
      display: block;
      width: 100%;
      height: 100px;
      z-index: 20;
      box-shadow: 0 2px 1px 1px hsla(0, 0%, 39%, .1);
      transition: padding .5s;
      .menu-top-head {
        height: 60px;
        background: #fff;
        box-shadow: 0 2px 1px 1px hsla(0, 0%, 39%, .1);
        position: relative;
        z-index: 11;
        align-items: center;
        .navicon-con {
          margin: 13px 6px 6px 8px;
          display: inline-block;
        }
        .ivu-btn {
          display: inline-block;
          font-weight: 400;
          text-align: center;
          vertical-align: middle;
          -ms-touch-action: manipulation;
          touch-action: manipulation;
          cursor: pointer;
          background-image: none;
          border: 1px solid rgba(0, 0, 0, 0);
          white-space: nowrap;
          line-height: 1.5;
          -webkit-user-select: none;
          -moz-user-select: none;
          -ms-user-select: none;
          user-select: none;
          padding: 6px 15px;
          font-size: 12px;
          border-radius: 4px;
          transition: color .2s linear, background-color .2s linear, border .2s linear;
          background-color: #fff;
          padding: 0;
          margin: 0;
        }
        .header-middle-con {
          position: absolute;
          left: 60px;
          top: 0;
          right: 340px;
          bottom: 0;
          padding: 10px;
          overflow: hidden;
        }
        .el-breadcrumb {
          font-size: 14px;
          line-height: 1;
          margin-top: 14px;
        }
        .header-avator-con {
          position: absolute;
          right: 0;
          top: 0;
          height: 100%;
          width: 170px;
        }
        .header-img {
          padding-top: 15px;
          img {
            height: 32px;
            width: 32px;
            border-radius: 32px;
            vertical-align: middle;
          }
        }
        .el-dropdown-link {
          cursor: pointer;
          color: #2d8cf0;
          font-size: 12px;
        }
        .el-icon-caret-bottom {
          font-size: 10px;
        }
      }
      .header-msg {
        display: inline-block;
        float: left;
        margin-top: 19px;
        margin-right: 30px;
      }
      .menu-top-tags {
        height: 40px;
        z-index: -1;
        overflow: hidden;
        background: #f0f0f0;
        .tags-box {
          position: absolute;
          padding: 2px 10px;
          overflow: visible;
          white-space: nowrap;
          transition: left .3s ease;
        }
        .tags {
          height: 30px;
          line-height: 30px;
          border: 1px solid #e9eaec!important;
          background: #fff!important;
          padding: 0 12px;
          display: inline-block;
          margin: 3px 0 2px 0;
          border: 1px solid #e9eaec;
          border-radius: 3px;
          background: #f7f7f7;
          font-size: 12px;
          vertical-align: middle;
          opacity: 1;
          overflow: hidden;
          cursor: pointer;
          margin-right: 5px;
          &:hover {
            opacity: .85;
          }
          .iconfont {
            color: #666;
            float: right;
            padding: 0 0px 0 5px;
            cursor: pointer;
            opacity: 0.66;
            &:hover {
              opacity: 1;
            }
          }
        }
        .ivu-tag-dot-inner {
          display: inline-block;
          width: 12px;
          height: 12px;
          margin-right: 8px;
          border-radius: 50%;
          background: #e9eaec;
          position: relative;
          top: 1px;
        }
      }
    }
    .menu-right {
      overflow: auto;
      background-color: #f0f0f0;
      z-index: 1;
      margin-top: 100px;
      height: 100%;
      margin-bottom: -100px;
      -webkit-transition: margin .5s;
      transition: margin .5s;
      .content {
        background-color: #ffffff;
        margin: 10px;
        padding: 10px;
        border: 1px solid #dddee1;
        border-color: #e9eaec;
        overflow: hidden;
        transition: all .2s ease-in-out;
        &:hover {
          box-shadow: 0 1px 6px rgba(0, 0, 0, .2);
          border-color: #eee;
        }
      }
    }
    .el-menu--dark .el-submenu .el-menu .el-menu-item:hover {
      background-color: #292e3b;
    }
  }

</style>

<template>
  <section class="home-menu">
    <div class="menu-left" :style="menuLeftStyle">
      <div class="menu-left-c">
        <div class="menus-logo-box">
          <img class="logo" src="../../../assets/logo.png" alt="">
        </div>
        <el-menu :default-active="activeIndex" class="el-menu-vertical-demo" theme="dark" @open="handleOpen" @close="handleClose"
          :collapse="isCollapse">
          <el-menu-item index="0" @click="gtToRouter({menuUrl:'/home',menuName:'首页'})">
            <i class="iconfont gt-shouye"></i>
            <span slot="title">首页</span>
          </el-menu-item>

          <el-menu-item v-for="(menus, index) in menusList" :key="menus.menuUrl" v-show="menus.menuSub == 0" :index="index+'m'" @click="gtToRouter(menus)">
            <i :class="'iconfont ' + menus.menuIcon"></i>
            <span slot="title">{{menus.menuName}}</span>
          </el-menu-item>

          <el-submenu v-for="(menus, index) in menusList" :key="menus.menuUrl" :index="index+'m'" v-show="menus.menuSub == 1">
            <template slot="title">
              <i :class="'iconfont ' + menus.menuIcon"></i>
              <span slot="title">{{menus.menuName}}</span>
            </template>
            <el-menu-item-group v-for="(subMenu, subIndex) in menus.subMenuList" :key="subMenu.menuUrl">
              <el-menu-item :index="index + '-' + subIndex" @click="gtToRouter(subMenu)">
                {{subMenu.menuName}}
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>

        </el-menu>
      </div>
    </div>
    <div class="menu-top" :style="menuTopStyle">
      <div class="menu-top-head">
        <div class="navicon-con">
          <div type="button" @click="setCollapse" class="ivu-btn ivu-btn-text" :style="naviconCon">
            <span>
              <i class="iconfont gt-caidan" style="font-size: 23px;"></i>
            </span>
          </div>
        </div>
        <div class="header-middle-con">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item v-for="item in breadCrumbList" :key="item.title" :to="{ path: item.path }">{{item.title}}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="header-avator-con">
          <div class="header-msg">
            <el-badge is-dot class="item">
              <i class="iconfont gt-lingdang" style="font-size: 19px;"></i>
            </el-badge>
          </div>
          <div class="header-img">
            <el-dropdown trigger="click">
              <span class="el-dropdown-link">
                下拉菜单
                <i class="el-icon-caret-bottom el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown" style="font-size:12px;">
                <el-dropdown-item>个人中心</el-dropdown-item>
                <el-dropdown-item divided>退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <img src="./../../../assets/head.jpg" alt="">
          </div>
        </div>
      </div>
      <div class="menu-top-tags">
        <div class="tags-box">
          <div class="tags" v-for="(item,index) in tagsList">
            <p @click="tagToRouter(item,index)" style="display:inline-block">
              <span class="ivu-tag-dot-inner" :style="selectTag==item.path?'background:#2d8cf0':'background:#e9eaec'"></span>
              <span v-text="item.title"></span>
            </p>
            <i @click="tagDelete(item,index)" class="iconfont gt-delete"></i>
          </div>
        </div>
      </div>
    </div>
    <div class="menu-right" :style="menuRightStyle">
      <div :class="transitionName">
        <router-view></router-view>
      </div>
    </div>
  </section>

</template>

<script>
  import {
    requestSSOLoginOut,
    requestUserMenu
  } from "../api/api";
  export default {
    name: "menu",
    data() {
      return {
        breadCrumbList: [{
            title: '首页',
            path: '/home'
          },
          {
            title: '首页2',
            path: '/home'
          },
        ],
        tagsList: [],
        selectTag: '',
        tagsIndex: '0',
        transitionName: 'content animated',
        isCollapse: false,
        menuLeftStyle: {
          width: '200px'
        },
        menuTopStyle: {
          paddingLeft: '200px'
        },
        menuRightStyle: {
          marginLeft: '200px'
        },
        naviconCon: {
          transform: 'rotateZ(0deg)'
        },
        activeIndex: "0",
        breadcrumb: {
          path: {},
          name: "",
          itemName: ""
        },
        menusList: [{
          menuUrl: "",
          menuName: "",
          menuIcon: ""
        }]
      };
    },
    mounted() {
      this.tagsList = this.store.state.tagsList
      this.selectTag = this.store.state.selectTag
    },
    watch: {
      '$route' (to, from) {
        this.store.commit('increment', {
          title: to.query.title,
          path: to.path
        })
        this.selectTag = to.path

        const toDepth = to.path.split('/').length
        const fromDepth = from.path.split('/').length
        this.transitionName = toDepth < fromDepth ? 'content animated ' : 'animated  content '

        setTimeout(() => {
          this.transitionName = 'content animated'
        }, 500)

      },
      'store.state.tagsList' () {
        this.tagsList = this.store.state.tagsList
      }
    },
    methods: {
      //选择标签路由
      tagToRouter(item, index) {
        this.$router.push({
          path: this.store.state.tagsList[index].path,
        });
        this.selectTag = this.store.state.tagsList[index].path
      },
      //删除标签路由
      tagDelete(item, index) {
        if (index == 0) return
        this.store.state.tagsList.splice(index, 1)
        if (this.selectTag == item.path) {
          this.$router.push({
            path: this.store.state.tagsList[index - 1].path,
          });
          this.selectTag = this.store.state.tagsList[index - 1].path
        }

      },
      setCollapse() {
        if (this.isCollapse) {
          this.menuLeftStyle.width = '200px'
          this.menuTopStyle.paddingLeft = '200px'
          this.menuRightStyle.marginLeft = '200px'
          this.naviconCon.transform = 'rotateZ(0deg)'
        } else {
          this.menuLeftStyle.width = '64px'
          this.menuTopStyle.paddingLeft = '64px'
          this.menuRightStyle.marginLeft = '64px'
          this.naviconCon.transform = 'rotateZ(-90deg)'
        }
        this.isCollapse = !this.isCollapse
      },
      gtToRouter(menuRouter) {
        this.$router.push({
          path: menuRouter.menuUrl,
        });
        this.store.commit('increment', {
          title: menuRouter.menuName,
          path: menuRouter.menuUrl
        })
        this.selectTag = menuRouter.menuUrl

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
              query: {
                redirect: this.$router.currentRoute.fullPath
              }
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
