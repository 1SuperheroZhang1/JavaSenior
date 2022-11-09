package Internet_Code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP的网络编程
 *
 * @author:superherozhang
 * @create:2022-03-03 12:00
 */
public class UDPTest {
    //发送端
    @Test
    public void send(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str="我是用UDP方式发送的导弹";
            byte[] data = str.getBytes();
            InetAddress localHost = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, localHost, 9090);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
    //接受端
    @Test
    public void receive(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9090);

            byte[] buffer=new byte[1024];

            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
}
