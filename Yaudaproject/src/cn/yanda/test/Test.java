package cn.yanda.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author superherozhang
 * @create 2022-05-21 8:58
 */
//public class Test {
//    public static void main(String[] args) {
//        String str="123";
//        //String API
//        System.out.println(str.length());
//
//        //数据传输实例
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入:");
//        String str_next=sc.next();
//        System.out.println("输入信息："+str_next);
//    }
//}
public class Test extends JFrame {

    public static void main(String[] args) {
        JFrame jf=new JFrame("JFrame");
        jf.setSize(600,500);
        jf.setLayout(null);
        JLabel jl=new JLabel("Welcome!");
        jl.setSize(200,100);
        jl.setFont(new Font(null,Font.PLAIN,25));
        jf.add(jl);
        //设置窗体可见
        jf.setVisible(true);
    }
}

