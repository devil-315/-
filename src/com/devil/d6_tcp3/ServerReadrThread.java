package com.devil.d6_tcp3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * ClassName：ServerReadrThread
 *
 * @author: Devil
 * @Date: 2024/11/18
 * @Description:
 * @version: 1.0
 */
public class ServerReadrThread extends Thread{
    private Socket socket;

    public ServerReadrThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                try {
                    String s = dis.readUTF();
                    System.out.println(s);
                } catch (Exception e) {
                    System.out.println("有人下线了：" + socket.getRemoteSocketAddress());
                    dis.close();
                    socket.close();
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
