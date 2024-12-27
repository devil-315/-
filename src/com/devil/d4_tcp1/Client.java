package com.devil.d4_tcp1;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ClassName：Client
 *
 * @author: Devil
 * @Date: 2024/11/18
 * @Description:
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //1.创建socket对象，并同时请求与服务端程序的连接
        Socket socket = new Socket("127.0.0.1", 8888);

        //2.从socket 管道中得到一个字节输出流，用来发送数据
        OutputStream os = socket.getOutputStream();

        //3.把低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        //4.发送数据
        dos.writeUTF("在一起，好嘛~");
        dos.close();

        socket.close();//释放资源
    }
}
