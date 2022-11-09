package Reflection_Code;





import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 * 1.类的加载过程：
 *   >加载
 *   >链接
 *   >初始化
 * 2.类的加载器
 *   作用：把类装载到内存中
 *   分类：
 *        >引导类加载器(Bootstap ClassLoader)
 *        >扩展类加载器(Extension ClassLoader)
 *        >系统类加载器(System ClassLoader)
 *        >自定义类加载器
 *
 * @author:superherozhang
 * @create:2022-03-17 13:39
 */

public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类：使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//AppClassLoader
        //调用系统类加载器的getParent():获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责Java的核心类库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }
    @Test
    public void test2() throws Exception {
        Properties pros=new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式一：
//        FileInputStream fis=new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为:当前module下的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user="+user+",password="+password);
    }
}
