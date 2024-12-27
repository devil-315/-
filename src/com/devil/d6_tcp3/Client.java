package com.devil.d6_tcp3;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
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
        //1.创建socket对象，并同时请求与服务端程序的连接
        Socket socket = new Socket("127.0.0.1", 8888);

        //2.从socket 管道中得到一个字节输出流，用来发送数据
        OutputStream os = socket.getOutputStream();

        //3.把低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            //4.发送数据
            System.out.println("请说：");
            String s = scanner.nextLine();
            if(s.equals("exit")){
                System.out.println("欢迎您下次光临！");
                dos.close();
                socket.close();//释放资源
                break;
            }
            dos.writeUTF(s);
            dos.flush();
        }
    }
}
