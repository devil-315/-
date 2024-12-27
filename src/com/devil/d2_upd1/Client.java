package com.devil.d2_upd1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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
        //1.创建客户端对象
        DatagramSocket socket = new DatagramSocket();

        //2.创建数据包对象封装要发出去的数据
        byte[] bytes = "我是客户端，你好呀~".getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);

        //3.发送
        socket.send((packet));

        //关闭
        System.out.println("客户端数据发送完毕~~~");
        socket.close();
    }
}
