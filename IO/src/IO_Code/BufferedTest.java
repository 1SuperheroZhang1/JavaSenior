package IO_Code;
import org.junit.Test;
import java.io.*;

/**
 * 处理流之一: 缓冲流的使用
 * 1.缓冲流:
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.缓冲流的作用:
 *      提高流读取、写入的效率
 *    提高读写速度的原因:内部提供了一个缓冲区
 * 3.处理流，就是"套接"在已有流的基础上。
 * @author:superherozhang
 * @create:2022-03-02 19:30
 */
public class BufferedTest {
    /*
    * 实现非文本文件的复制
    * */
    @Test
    public void testBufferedStream()  {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.实例化File类的对象
            File srcFile=new File("生命周期图解.png");
            File destFile=new File("生命周期图解__.png");
            //2.创建流的对象
            //2.1创建节点流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2创建缓冲流对象
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制细节:流的读写操作
            byte[] buffer=new byte[10];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);

//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null){
                //4.关闭流资源
                //要求:先关闭外层的流，再关闭内层的流
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //说明:关闭外层流的同时，内层流也会自动地进行关闭。关于内层流的关闭，可以省略
//        fos.close();
//        fis.close();
    }
    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.实例化File类的对象
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            //2.创建流的对象
            //2.1创建节点流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2创建缓冲流对象
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制细节:流的读写操作
            byte[] buffer=new byte[1024];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null){
                //4.关闭流资源
                //要求:先关闭外层的流，再关闭内层的流
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //说明:关闭外层流的同时，内层流也会自动地进行关闭。关于内层流的关闭，可以省略
//        fos.close();
//        fis.close();
    }
    @Test
    public void testcopyFileWithBuffered(){
        long start=System.currentTimeMillis();

        String srcPath="D:\\系统默认\\桌面\\第一章第二节.mp4";
        String destPath="D:\\系统默认\\桌面\\第一章第二节_.mp4";
//        String srcPath="hello.txt";
//        String destPath="hello__.txt";

        copyFileWithBuffered(srcPath,destPath);

        long end=System.currentTimeMillis();
        System.out.println("花费的时间为:"+(end-start));//1651ms
    }
    /*
    * 使用BufferedReader和BufferedWriter实现文本文件的复制
    * */
    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader br= null;
        BufferedWriter bw= null;
        try {
            //1.创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));
            //2.读写操作
            //方式一: 使用char[]数组
//            char[] cbuf=new char[1024];
//            int len;
//            while((len=br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//
//    //            bw.flush();
//            }
            //方式二: 使用String
            String data;
            while((data=br.readLine())!=null){
                //方法一:
//                bw.write(data+"\n");//data中不包含换行符
                //方法二:
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           if(br!=null){
               try {
                   br.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

        }

    }
}
