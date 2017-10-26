<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ZH">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <%@ include file="common/taglib.jsp"%>
</head>
<script type="text/javascript">
    var redirectUrl = '${redirectUrl}';
    console.log("redirectUrl --> " + redirectUrl);
</script>
<body style="text-align: center;">
<div id="login" style="margin-top: 15%;margin-left: 34%;">
    <h1 style="width: 33%;">多粉INSIDE</h1>
    <el-row style="width: 33%;">
        <el-input @keyup.enter.native="login" placeholder="请输入账号" v-model="loginData.loginName">
            <template slot="prepend">账号</template>
        </el-input>
    </el-row>
    <br/>
    <el-row style="width: 33%;">
        <el-input @keyup.enter.native="login" type="password" placeholder="请输入密码" v-model="loginData.password">
            <template slot="prepend">密码</template>
        </el-input>
    </el-row>
    <br/>
    <el-row style="width: 33%;">
        <el-button @click="login" type="primary" style="width: 100%">登录</el-button>
    </el-row>
</div>
</body>
<script type="text/javascript" src="/js/login.js"></script>
</html>
