package IO_Code;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 处理流之四: 打印流
 *  1.打印流
 *    PrintStream
 *    PrintWriter
 *   1.1 提供了一系列重载的print()/println()方法
 * @author:superherozhang
 * @create:2022-03-02 21:45
 */
public class PrintStreamWriterTest {
    @Test
    public void test1(){
        PrintStream ps= null;
        try {
            FileOutputStream fos=new FileOutputStream(new File("D:\\系统默认\\桌面\\text.txt"));
            ps = new PrintStream(fos,true);

            if(ps!=null){
                System.setOut(ps);
            }

            for(int i=0;i<=255;i++){ //输出ASII字符
                System.out.print((char)i);
                if(i%50==0){ //每50个数据一行
                    System.out.println();//换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                ps.close();
            }
        }
    }
}
