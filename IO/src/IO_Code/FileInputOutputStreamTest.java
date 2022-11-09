package IO_Code;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论:
 *     对于文本文件(.txt,.java,.c,.cpp)，使用字符流来处理。
 *     对于非文本文件(.jpg,.mp3,.mp4,.doc,.ppt,.avi,...)，使用字节流来处理。
 * @author:superherozhang
 * @create:2022-03-02 18:46
 */
public class FileInputOutputStreamTest {
    //使用字节流FileInputStream处理文本文件。可能出现乱码
    @Test
    public void testFileInputStream(){
        FileInputStream fis= null;
        try {
            //1.实例化File类的对象
            File file=new File("hello.txt");
            //2.创建FileInputStream的对象
            fis = new FileInputStream(file);
            //3.读入的操作
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
                System.out.print(str);//helloworld123��国���
                //在UTF-8中，一个汉字占3个字符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                //4.关闭流资源
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    * 实现对图片的复制操作
    * */
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            //
            File srcFile=new File("生命周期图解.png");
            File destFile=new File("生命周期图解_.png");
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if(fos!=null){

                try {
                    fos.close();
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
        }
    }
    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            //
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if(fos!=null){

                try {
                    fos.close();
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
        }
    }
    @Test
    public void testcopyFile(){
        long start=System.currentTimeMillis();

        String srcPath="D:\\系统默认\\桌面\\第一章第二节.mp4";
        String destPath="D:\\系统默认\\桌面\\第一章第二节_.mp4";
//        String srcPath="hello.txt";
//        String destPath="hello__.txt";

        copyFile(srcPath,destPath);

        long end=System.currentTimeMillis();
        System.out.println("花费的时间为:"+(end-start));//7260ms
    }
}
