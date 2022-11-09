package cn.yanda.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author superherozhang
 * @create 2022-05-28 10:13
 */
public class JDBCUtil {

    /**
     * 显示出现了第三方数据库的API
     * */
    public void testConnection1(){

        try {
            //1.提供java.sql.Driver接口实现类的对象
            Driver driver=null;
            driver=new com.mysql.cj.jdbc.Driver();
            //2.提供url，指明具体操作的数据
            String url="jdbc:mysql://localhost:3306/exer2";
            //3.提供Properties的对象，指明用户名和密码
            Properties info=new Properties();
            info.setProperty("username","root");
            info.setProperty("password","020704");
            //4.调用driver的connect(),获取连接
            Connection conn=driver.connect(url,info);
            System.out.println(conn);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射实例化Driver，不在代码中体现第三方数据库的API。体现了面向接口编程思想，同时使得程序更好的可移植性。
     * */
    public void testConnection2(){
        try {
            //1.实例化Driver
            String className="com.mysql.cj.jdbc.Driver";
            Class clazz=Class.forName(className);
            Driver driver= (Driver) clazz.newInstance();
            //2.提供url，指明具体操作的数据
            String url="jdbc:mysql://localhost:3306/exer2";
            //3.提供Properties的对象，指明用户名和密码
            Properties info=new Properties();
            info.setProperty("username","root");
            info.setProperty("password","020704");
            //4.调用driver的connect()，获取连接
            Connection conn=driver.connect(url,info);
            System.out.println(conn);
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void testConnection3(){
        try {
            //1.数据库连接的4个基本要素：
            String username="root";
            String password="020704";
            String url="jdbc:mysql://localhost:3306/exer2";
            String driverName="com.mysql.jdbc.Driver";
            //2.实例化Driver
            Class clazz=Class.forName(driverName);
            Driver driver= (Driver) clazz.newInstance();
            //3.注册驱动
           DriverManager.registerDriver(driver);
            //4.获取连接
           Connection conn=DriverManager.getConnection(url,username,password);
            System.out.println(conn);
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testConnection4(){

        try {
            //1.数据库连接的4个基本要素
            String username="root";
            String password="020704";
            String url="jdbc:mysql://127.0.0.1:3306/exer2";
            String driverName="com.mysql.cj.jdbc.Driver";
            //2.加载驱动(①实例化Driver ②注册驱动)
            Class.forName(driverName);

            //3.获取连接
            Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println(conn);
            //4.关闭连接
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void testConnection5() throws Exception {
        //1.加载配置文件
        InputStream is=JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros=new Properties();
        pros.load(is);

        //2.读取配置信息
        String username=pros.getProperty("username");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");

        //3.加载驱动
        Class.forName(driverClass);

        //4.获取连接
        Connection conn=DriverManager.getConnection(url,username,password);
        System.out.println(conn);
        conn.close();
    }

    public static void main(String[] args) {
        JDBCUtil test=new JDBCUtil();
        try {
            test.testConnection5();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
