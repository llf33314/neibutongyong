var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

//在线用户
var onlineUsers = {};
//当前在线人数
var onlineCount = 0;

io.on('connection', function(socket) {
  //上线
  console.log('用户链接');

  socket.on('login', function(obj) {
    // 将新加入用户的唯一标识当作socket的名称，后面退出的时候会用到
    socket.name = obj.userid;
    // 检查在线列表，如果不在里面就加入
    if (!onlineUsers.hasOwnProperty(obj.userid)) {
      onlineUsers[obj.userid] = obj.username;
      //在线人数+1
      onlineCount++;
    }

    //向所有客户端广播用户加入
    console.log(obj.username + '加入了socket-' + socket.name);
  });

  socket.on('disconnect', function() {
    // 离线
    //将退出的用户从在线列表中删除
    if (onlineUsers.hasOwnProperty(socket.name)) {
      //退出用户的信息
      var obj = { userid: socket.name, username: onlineUsers[socket.name] };

      //删除
      delete onlineUsers[socket.name];
      //在线人数-1
      onlineCount--;

      //向所有客户端广播用户退出
      io.emit('logout', {
        onlineUsers: onlineUsers,
        onlineCount: onlineCount,
        user: obj
      });
      console.log(obj.username + '退出了socket');
    }
  });

  socket.on('msg', function(msg) {
    console.log('msg', msg);
    io.emit('msg', msg);
  });

  //监听用户发布聊天内容
  socket.on('message', function(obj) {
    //向所有客户端广播发布的消息
    io.emit('message', socket.name + '-说：' + obj);
  });
});

http.listen(9101, function() {
  console.log('listening on 9101');
});
