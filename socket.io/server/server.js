var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
// 默认启动页
app.get('/', function(req, res) {
  res.sendFile(__dirname + '/index.html');
});

// 上线
io.on('connection', function(socket) {
  // 离线
  socket.on('disconnect', function() {});

  // 接到消息后发给所有人
  socket.on('message', function(message) {
    io.emit('message', message);
  });
});

http.listen(9101, function(){
  console.log("socker server start 9101 ...");
});
