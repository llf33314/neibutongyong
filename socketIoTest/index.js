var app = require('express')()
var http = require('http').Server(app)
var io = require('socket.io')(http)
app.get('/', function(req, res) {
  res.sendFile(__dirname + '/index.html')
})
var connectionNum = 0
var arrayUnique = function(array) {
  //数组去重
  var r = []
  for (var i = 0, l = array.length; i < l; i++) {
    for (var j = i + 1; j < l; j++) if (array[i] === array[j]) j = ++i
    r.push(array[i])
  }
  return r
}
var socketMsg = {
  //上线
  getOnLine: function(socket) {
    this.goToOnlineIds.push(socket.id)
    console.log('上线用户ids', this.goToOnlineIds)
  },
  //上线用户ids
  goToOnlineIds: [],
  //上线人数
  goToOnlineNum: function() {
    return this.goToOnlineIds.length
  },
  //离线用户ids
  offLineIds: [],
  //当前在线用户ids
  onLineIds: [],
  getOffLine: function(socket) {
    this.offLineIds.push(socket.id)
    console.log('离线用户ids', this.offLineIds)
  }
}


io.on('connection', function(socket) {
  //上线
  socketMsg.getOnLine(socket)
  socket.on('disconnect', function() {
    // 离线
    socketMsg.getOffLine(socket)
  })
  //socket.broadcast.emit('hi')

  socket.on('cha66', function(msg) {
    io.emit('cha66', msg)
    io.close(); 
    //socket.emit('with-binary', 1, '2', { 3: '4', 5: new Buffer(6) });
  })
})

io.emit('some event', { for: 'everyone' })
http.listen(3333, function() {
  console.log('listening on *3333')
})
// 当有人连接或断开连接时，将消息广播给连接的用户
// 添加对昵称的支持
// 不要将相同的消息发送给自己发送的用户。相反，只要他按下输入，就直接追加消息。
// 添加“{用户}正在键入”功能
// 显示谁在线
// 添加私人消息
// 分享你的改进！
