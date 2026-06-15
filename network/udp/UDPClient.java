package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 接收、发送部分代码逻辑与服务端完全相同
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        String msg = "Hello UDP Server";
        byte[] data = msg.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 8080);
        socket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket responsePacket = new DatagramPacket(buf, buf.length);
        socket.receive(responsePacket);
        String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
        System.out.println("服务端回复：" + response);

        socket.close();
    }
}
