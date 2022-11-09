package Internet_Code;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 2.客户端发送文件给服务器，服务端将文件保存到本地
 *
 * @author:superherozhang
 * @create:2022-03-03 11:14
 */
public class TCPTest2 {
    @Test
    public void client(){
        Socket socket= null;
        OutputStream os = null;
        FileInputStream fis= null;
        try {
            //1.创建套接字
            socket = new Socket(InetAddress.getByName("127.0.0.1"),6666);
            //2.获取一个输出流，输出数据
            os = socket.getOutputStream();
            //3.获取一个输入流，实现读写操作
            fis = new FileInputStream(new File("beauty.png"));
            //4.读写操作
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null){
                //5.关闭资源
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
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
    @Test
    public void server(){
        ServerSocket server = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos= null;
        try {
            //1.创建服务器端套接字
            server = new ServerSocket(6666);
            //2.调用accept()方法接收来自客户端的socket
            socket = server.accept();
            //3.获取一个输入流，用于读取输入流的数据
            is = socket.getInputStream();
            //4.获取一个输出流，用于写入数据
            fos = new FileOutputStream(new File("beauty1.png"));
            //5.读写操作
            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                //5.关闭资源
                try {
                    fos.close();
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
