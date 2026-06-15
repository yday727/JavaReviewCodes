package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8080);    // 绑定端口
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet);    // 接收客户端数据包
        String msg = new String(packet.getData(), 0, packet.getLength());    // 解包
        System.out.println("接收客户端消息：" + msg);

        InetAddress clientAddress = packet.getAddress();    // 获取客户端IP地址
        int clientPort = packet.getPort();    // 获取客户端端口
        String response = "已接收消息";
        byte[] responseBytes = response.getBytes();
        DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);    // 打包
        socket.send(responsePacket);    // 向客户端发送数据包

        socket.close();    // 关闭服务端
    }
}
