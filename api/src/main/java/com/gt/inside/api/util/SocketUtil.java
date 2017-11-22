package com.gt.inside.api.util;

import io.socket.client.IO;
import io.socket.client.Socket;
import org.apache.log4j.Logger;

/**
 * Socket工具类
 * @author psr
 * Created by psr on 2017/11/22 0022.
 */
public class SocketUtil {

    private static Logger logger = Logger.getLogger(SocketUtil.class);

    // 静态参数
    public static final String CONNECT = "connect";
    public static final String MESSAGE = "message";
    public static final String DISCONNECT = "disconnect";

    // socket
    private static Socket socket;

    /**
     * 链接socket
     * @param socketUrl
     */
    public static void connect(String socketUrl) {
       try {
           socket = IO.socket(socketUrl);
       }catch (Exception e){
           e.printStackTrace();
       }
       socket.connect();
    }

    /**
     * 发送默认消息 message
     * @param message
     */
    public static void sendMessage(String message){
        socket.emit(MESSAGE, message);
    }

}
