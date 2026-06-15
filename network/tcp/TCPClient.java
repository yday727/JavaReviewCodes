package network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);    // 连接“本机地址，8888端口”服务端

        try (PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);    // 客户端输出流
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))    // 获取服务端输入流
        ) {
            pr.println("Hello Server!");    // 向服务端发送消息
            String response = br.readLine();    // 读取服务端消息
            System.out.println("服务端回复：" + response);
        } finally {
            socket.close();    // 关闭客户端
        }

        /*
        // 简化写法，使用try自动管理资源，无需在finally中关闭客户端
        try (Socket socket = new Socket("localhost", 8888);
             PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            pr.println("Hello Server");
            String response = br.readLine();
            System.out.println("服务端回复：" + response);
        }
         */
    }
}
