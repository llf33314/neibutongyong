<template>
  <section>
    首页
    <el-button size="small" @click="test()">测试</el-button>
    <el-button size="small" @click="myGetCookie()">获取cookie</el-button>
    <el-button size="small" @click="mySetCookie()">设置cookie</el-button>
  </section>
  
</template>
<script>
import { requestTest } from "../api/api";
export default {
  data(){
    return {
      token:""
    }
  },
  methods: {
    test() {
      requestTest().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.$message(data.msg);
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    }
  }
};
</script>
