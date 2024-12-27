package com.devil.d9_tcp6;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * ClassName：ServerReadrThread
 *
 * @author: Devil
 * @Date: 2024/11/18
 * @Description:
 * @version: 1.0
 */
public class ServerReaderRunnable implements Runnable{
    private Socket socket;

    public ServerReaderRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println(("HTTP/1.1 200 OK"));
            ps.println(("Content-Type:text/html;charset=utf-8"));
            ps.println();
            ps.println("<div style='color:red;font-size:120px;text-align:center'>devil牛逼<div>");
            ps.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
