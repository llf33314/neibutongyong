var express = require('express')
var app = express()
app.use(express.static("./dist/")).listen(8080);
console.log('启动了...')
