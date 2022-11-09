package Connection_Code;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author:superherozhang
 * @create:2022-03-15 0:08
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件。key和value都是String类型。
    public static void main(String[] args)  {
        FileInputStream fis= null;
        try {
            Properties pros=new Properties();

            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载对应的流文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name="+name+",password="+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
