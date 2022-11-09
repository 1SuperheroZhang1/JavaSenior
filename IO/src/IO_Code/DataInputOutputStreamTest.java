package IO_Code;


import org.junit.Test;

import java.io.*;

/**
 * 处理流之五: 数据流
 * 1.数据流:
 * DataInputStream
 * DataOutputStream
 * 2.作用:
 *    用于读取和写出基本数据类型的变量和字符串
 * 3.注意点:
 *      读取不同类型的数据的顺序要与写入文件时，保存数据的顺序一致！
 * @author:superherozhang
 * @create:2022-03-02 21:57
 */
public class DataInputOutputStreamTest {
    @Test
    public void test1(){
        DataOutputStream dos= null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File("data.txt")));
            dos.writeUTF("张杰");
            dos.flush();//刷新操作:将内存中的数据写入文件
            dos.writeInt(19);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos!=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    * 将文件中存储的基本数据类型和字符串读取到内存中，保存在变量中。
    * */
    @Test
    public void test2(){
        DataInputStream dis= null;
        try {
            dis = new DataInputStream(new FileInputStream(new File("data.txt")));

            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();
            System.out.println("name:"+name);
            System.out.println("age:"+age);
            System.out.println("isMale"+isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dis!=null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
