package com.devil.d5_tcp2;

import java.io.DataInputStream;
import java.io.InputStream;
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

        //2.使用serverSocket对象，调用一个accept方法，等待客户端连接请求
        Socket socket = serverSocket.accept();

        //3.从socket通信管道中得到一个字节输入流
        InputStream is = socket.getInputStream();

        //4.把原始的字节输入流包装成数据输入类
        DataInputStream dis = new DataInputStream(is);

        while (true) {
            try {
                //5.读取
                String s = dis.readUTF();
                System.out.println(s);
            } catch (Exception e) {
                System.out.println(socket.getRemoteSocketAddress() + "离线了！");
                dis.close();
                socket.close();
                break;
            }
        }
    }
}
