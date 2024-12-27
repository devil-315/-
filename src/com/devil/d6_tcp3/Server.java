package com.devil.d6_tcp3;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName：Server
 *
 * @author: Devil
 * @Date: 2024/11/18
 * @Description:
 * @version: 1.0
 */
public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("--服务端启动成功---");

        //1.创建serverSocket对象，同时为服务端注册端口
        ServerSocket serverSocket = new ServerSocket(8888);


        while (true) {
            //2.使用serverSocket对象，调用一个accept方法，等待客户端连接请求
            Socket socket = serverSocket.accept();

            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());

            //3.把这个客户端对应的socket对象，交给一个独立的线程
            ServerReadrThread thread = new ServerReadrThread(socket);
            thread.start();
        }
    }
}
