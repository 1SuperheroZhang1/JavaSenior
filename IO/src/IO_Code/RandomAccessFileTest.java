package IO_Code;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为输入流，又可以作为输出流。
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中会自动创建。
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。(默认情况下，从头覆盖)
 * 4.可以通过相关操作，实现RandomAccessFile"插入"数据的效果。
 * @author:superherozhang
 * @create:2022-03-03 8:46
 */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        RandomAccessFile raf1= null;
        RandomAccessFile raf2= null;
        try {
            raf1 = new RandomAccessFile(new File("生命周期图解.png "),"r");
            raf2 = new RandomAccessFile(new File("生命周期图解1.png"),"rw");

            byte[] buffer=new byte[1024];
            int len;
            while((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf2!=null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2(){
        RandomAccessFile raf1= null;
        try {
            raf1 = new RandomAccessFile(new File("hello.txt"),"rw");

            raf1.seek(3);//将指针调到角标为3的位置
            raf1.write("xyz".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    * 使用RandomAccessFile实现数据的插入效果
    * */
    @Test
    public void test3(){
        RandomAccessFile raf1= null;
        try {
            raf1 = new RandomAccessFile(new File("hello.txt"),"rw");

            raf1.seek(3);//将指针调到角标为3的位置
            //保存指针3后面的所有数据到StringBuilder中
            StringBuilder builder=new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer=new byte[20];
            int len;
            while((len=raf1.read(buffer))!=-1){
                builder.append(new String(buffer,0,len));
            }
            //调回指针,写入"xyz"
            raf1.seek(3);
            raf1.write("xyz".getBytes());
            //将StringBuilder中的数据写入文件中
            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        /*
        * 思考:将StringBuilder替换为ByteArrayOutPutStream
        * */
    }
}
