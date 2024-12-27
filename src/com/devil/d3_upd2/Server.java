package com.devil.d3_upd2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

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
        //1.创建服务端对象
        DatagramSocket socket = new DatagramSocket(6666);

        //2.创建数据包对象，用于接收对象
        byte[] butter = new byte[1024 * 64]; //64kb
        DatagramPacket packet = new DatagramPacket(butter, butter.length);

        while (true) {

            //3.接收数据
            socket.receive((packet));

            //4.打印数据
            //读取多少，打印多少
            //获取本次数据包接收的数据
            int length = packet.getLength();
            String s = new String(butter,0, length);
            System.out.println(s);

            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(packet.getPort());
            System.out.println("----------------------");
        }
    }
}
