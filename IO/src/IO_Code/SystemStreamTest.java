package IO_Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理流之三: 标准输入输出流
 *  1.标准的输入、输出流:
 *   1.1
 *    1)System.in:标准的输入流，默认从键盘输入
 *    2)System.out: 标准的输出流，默认从控制台输出
 *   1.2
 *    System类的setIn(InputStream is)/setOut(OutputStream out)方式重新指定输入和输出流的位置。
 * @author:superherozhang
 * @create:2022-03-02 21:15
 */
public class SystemStreamTest {
    /*
    * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入"e"或者"exit"时，退出程序。
    * 方法一: 使用Scanner实现，调用next()方法，返回字符串
    * 方法二: 使用System.in实现。 System.in --->转换流 ---> BufferedReader的readLine()
    * */
    public static void main(String[] args) {

        BufferedReader br= null;
        try {
            InputStreamReader isr=new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            String data;
            while(true){
                System.out.println("请输入字符串: ");
                data=br.readLine();

                if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
