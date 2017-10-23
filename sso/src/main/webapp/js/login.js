var login = new Vue({
    el: '#login',
    data: {
        loginData: {}
    },
    methods: {
        login: function () {
            console.log(this.loginData);
            var _this = this;
            // 登录
            axios.post('/m/login', _this.loginData).then(function (response) {
                var _data = response.data;
                console.log(_data);
                if (_data.code != 100){
                    _this.$alert(_data.msg, '登录失败');
                }else {
                    console.log(_data.data.token);
                    window.location.href = redirectUrl + "?token=" + _data.data.token;
                }
            });
        }
    }
});