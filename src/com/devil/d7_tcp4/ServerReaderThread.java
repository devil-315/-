package com.devil.d7_tcp4;

import java.io.*;
import java.net.Socket;

/**
 * ClassName：ServerReadrThread
 *
 * @author: Devil
 * @Date: 2024/11/18
 * @Description:
 * @version: 1.0
 */
public class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket) {
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
                    sendMsgToAll(s);
                } catch (Exception e) {
                    System.out.println("有人下线了：" + socket.getRemoteSocketAddress());
                    Server.onLineSockets.remove((socket));
                    dis.close();
                    socket.close();
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void sendMsgToAll(String s) throws Exception {
        for (Socket onLineSocket: Server.onLineSockets) {
            OutputStream os = onLineSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(s);
            dos.flush();
        }
    }
}
