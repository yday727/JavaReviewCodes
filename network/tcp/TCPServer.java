package com.yday72__7.reviewCodes.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] arg) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);    // 监听“8888”端口
        System.out.println("服务器启动，等待连接...");

        Socket socket = serverSocket.accept();    // 进入阻塞状态，等待客户端连接
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));    // 获取客户端输入流
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)    // 服务端输出流
        ) {
            String clientMsg = br.readLine();    // 读取客户端信息
            System.out.println("客户端消息：" + clientMsg);

            pw.println("已收到：" + clientMsg);    // 向客户端发送信息
        } finally {
            serverSocket.close();
        }

        /*
        // 简化写法，使用try自动管理资源，无需在finally中关闭服务端
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("服务器启动，等待连接...");
            Socket socket = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            String clientMsg = br.readLine();
            System.out.println("客户端消息：" + clientMsg);

            pw.println("已收到：" + clientMsg);
        }
         */
    }
}
