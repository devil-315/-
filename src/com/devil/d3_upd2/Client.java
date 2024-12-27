package com.devil.d3_upd2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        while (true){
            //2.创建数据包对象封装要发出去的数据
            System.out.println("请说：");
            String s = scanner.nextLine();
            //如果是exit,退出
            if(s.equals("exit")){
                //关闭
                System.out.println("客户端数据发送完毕~~~");
                socket.close();
                break;//退出循环
            }
            byte[] bytes = s.getBytes();

            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);

            //3.发送
            socket.send((packet));
        }
    }
}
