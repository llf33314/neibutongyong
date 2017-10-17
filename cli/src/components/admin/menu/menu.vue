<template>
  <section class="container">
    <el-menu theme="dark" :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item v-for="(item,index) in menus" :index="item.num" >{{item.name}}</el-menu-item>
      <!-- <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
      </el-submenu> -->
    </el-menu>
  </section>
</template>

<script>
  import {requestGetAllMenu} from './api/api'
  export default {
    name: 'menu',
    data() {
      return {
        activeIndex: '0',
        menus:[]
      }
    },
    mounted() {
      this.getAllMenu()
    },
    methods: {
      toString(n){
        return window.toString(n)
      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      getAllMenu(){
        requestGetAllMenu().then(data=>{
          console.log(data)
          if(data.code == 100){
            this.$message.success(data.msg)
            data.data.forEach((item,index)=>{

              item.num = window.String(index)
            })
            console.log(data.data)
            this.menus = data.data
            this.activeIndex = data.data[0].num
          }else{
            this.$message.error(data.msg || '请求异常')
          }
        })
      }
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
