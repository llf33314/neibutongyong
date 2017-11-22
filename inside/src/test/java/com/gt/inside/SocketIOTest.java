package com.gt.inside;


import com.gt.inside.api.util.SocketUtil;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by psr on 2017/11/21 0021.
 */
public class SocketIOTest {

    /*public static void main(final String[] args) {
        Socket socket;
        try {

            socket = IO.socket("http://192.168.3.97:9111");

            socket.on("connect", new Emitter.Listener() {
                @Override
                public void call(Object... objects) {
                    System.out.println("连接成功");
                }
            }).on("message", new Emitter.Listener() {
                @Override
                public void call(Object... objects) {
                    System.out.println(objects[0]);
                }
            });

            socket.connect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        SocketUtil.connect("http://192.168.3.97:9111");
        SocketUtil.sendMessage("2222");
    }

}
