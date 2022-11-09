package Internet_Code;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 *1.客户端发送内容给服务端，服务端将内容打印到控制台上。
 *
 * @author:superherozhang
 * @create:2022-03-03 10:46
 */
public class TCPTest1 {
    /*
    * 例1: 客户端向服务端发送信息，服务端将信息显示在控制台上。
    * */
    //客户端
    @Test
    public void client(){
        Socket socket= null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8888);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("你好，我是客户端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //服务器端
    @Test
    public void server(){
        ServerSocket server = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos= null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            server = new ServerSocket(8888);
            //2.调用accept()方法，表明可以接受来自客户端的socket
            socket = server.accept();
            //3.获取一个输入流，读取输入流中的数据
            is = socket.getInputStream();

            //不建议这样写，因为可能会有乱码
//        byte[] buffer=new byte[1024];
//        int len;
//        while((len=is.read())!=-1){
//            String str=new String(buffer,0,len);
//            System.out.print(str);
//        }
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer=new byte[5];
            int len;
            while((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());
            System.out.println("收到了来自于:"+socket.getInetAddress().getHostAddress()+"的信息");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos!=null){
            //5.关闭资源
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(server!=null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
