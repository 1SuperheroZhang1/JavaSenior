package Internet_Code;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 3.从客户端发送文件给服务端，服务端保存到本地。并返回"发送成功"给客户端。并关闭相应的连接。
 * @author:superherozhang
 * @create:2022-03-03 11:31
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis= null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;
        try {
            //1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //2.
            os = socket.getOutputStream();
            //3.
            fis = new FileInputStream(new File("hello.txt"));
            //4.
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();
            //5.接收来自于服务器端的数据，并显示到控制台上
            is = socket.getInputStream();
            baos=new ByteArrayOutputStream();
            byte[] bufferr=new byte[1024];
            int leng;
            while((leng=is.read(bufferr))!=-1){
                baos.write(bufferr,0,leng);
            }

            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null){
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
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos!=null){
                try {
                    baos.close();
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
        OutputStream os=null;
        try {
            //1.
            server = new ServerSocket(9999);
            //2.
            socket = server.accept();
            //3.
            is = socket.getInputStream();
            //4.
            fos = new FileOutputStream(new File("helloserver.txt"));
            //5.
            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("文件传输完成");
            //6.
             os = socket.getOutputStream();
            os.write("发送成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                //7.
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
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
