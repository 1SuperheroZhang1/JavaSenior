package IO_Code;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二:转换流
 * 1.转换流: 属于字符流
 * InputStreamReader: 将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter: 将一个字符的输出流转换为字节的输出流
 *
 * 2.作用: 提供字节流与字符流之间的转换
 *
 * 3.解码: 字节、字节数组 ---> 字符串、字符数组
 *   编码: 字符串、字符数组 ---> 字节、字节数组
 *
 * 4.字符集
 * @author:superherozhang
 * @create:2022-03-02 20:35
 */
public class InputStreamReaderTest {
    /*
    * InputStreamReader的使用：实现了字节输入流到字符输入流的转换
    * */
    @Test
    public void test1(){
        InputStreamReader isr= null;
        try {
            FileInputStream fis=new FileInputStream(new File("hello.txt"));
//        InputStreamReader isr=new InputStreamReader(fis);//使用默认的字符集
            //参数2指明了字符集，具体使用哪个字符集，取决于保存时使用的字符集
            isr = new InputStreamReader(fis,"UTF-8");

            char[] cbuf=new char[5];
            int len;
            while((len=isr.read(cbuf))!=-1){
                String str=new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    * 综合使用InputStreamReader和OutputStreamWriter
    * */
    @Test
    public void test2(){
        InputStreamReader isr= null;
        OutputStreamWriter osw= null;
        try {
            File f1=new File("hello.txt");
            File f2=new File("hello_gbk.txt");

            FileInputStream fis=new FileInputStream(f1);
            FileOutputStream fos=new FileOutputStream(f2);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            //读写过程
            char[] cbuf=new char[5];
            int len;
            while((len=isr.read(cbuf))!=-1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(osw!=null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
