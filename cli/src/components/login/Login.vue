<template>
  <section class="login">
    <section class="content">
      <div class="logo-row">
        <div class="logo-cont">
          <img src="./../../assets/img/logo.png">
        </div>
      </div>
      <h1 class="login-title">多粉天眼系统</h1>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm">
        <el-form-item prop="name">
          <el-input placeholder="请输入登录账号" v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="请输入登录密码" v-model="ruleForm.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" v-text="editState"></el-button>
        </el-form-item>
      </el-form>

    </section>
  </section>
</template>

<script type="application/ecmascript">
  import {
    requestLogin
  } from './api/api'
  export default {
    name: 'Login',
    data() {
      return {
        editState: '登录',
        ruleForm: {
          name: 'admin',
          password: 'gt123456',
        },
        rules: {
          name: [{
            required: true,
            message: '请输入登录账号',
            trigger: 'blur'
          }, ],
          password: [{
            required: true,
            message: '请输入登录密码',
            trigger: 'blur'
          }],
        }
      };
    },
    mounted() {
      document.addEventListener('keyup', this.keyUpSubmit)
    },
    methods: {
      /*
       * 登录成功
       * */
      successCallBack: function (tocken) {
        var self = this
        self.$message({
          message: '登录成功',
          type: 'success',
          duration: 1500,
          onClose: function () {
            self.editState = '登录'
            window.localStorage.setItem('tocken', tocken)
            self.$router.push({
              path: '/stageIndex'
            })
          }
        });
      },
      /*
       * 回车登录
       * */
      keyUpSubmit(event) {
        if (event.keyCode == 13) this.submitForm('ruleForm')
      },
      /*
       * 发送登录请求
       * */
      sendLoagin(data) {
        var self = this
        requestLogin({
          "loginName": this.ruleForm.name,
          "password": this.ruleForm.password
        }).then(data => {
          console.log(data)
          if (data.code == 100) {
            console.log(999)
            this.successCallBack()
          } else {
            this.$message.error(data.msg || '请求异常');
          }
        })
      },
      /*
       * 提交信息
       * */
      submitForm(formName) {
        let self = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let data = window.JSON.parse(window.JSON.stringify(self.ruleForm))
            self.sendLoagin(data)
          } else {
            return false;
          }
        });
      }
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .login {
    background-color: #f5f5f5;
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
  }

  .content {
    position: absolute;
    width: 860px;
    height: 640px;
    top: 50%;
    left: 50%;
    margin-top: -320px;
    margin-left: -430px;
    background-color: #fff;
    border-radius: 3px;
  }

  .logo-cont {
    background-color: #ff5f5f;
    width: 80px;
    height: 80px;
    border-radius: 100%;
    margin: 70px auto 0;
    line-height: 80px;
    text-align: center;
  }

  .logo-cont img {
    vertical-align: middle;
  }

  .login-title {
    text-align: center;
    color: #333;
    font-size: 24px;
    margin: 0;
    padding: 30px 0 55px 0;
    font-weight: normal;
  }

  .demo-ruleForm {
    width: 362px;
    margin: 0 auto;
  }

  .el-form-item {
    margin-bottom: 30px;
  }

  .el-button--primary {
    color: #fff;
    background-color: #ff5f5f;
    border-color: #ff5f5f;
    width: 100%;
  }

</style>
