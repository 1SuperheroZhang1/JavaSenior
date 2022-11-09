package cn.yanda.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author superherozhang
 * @create 2022-05-28 11:09
 */
public class TestJPanel {
    public static void main(String[] args) {
        //创建一个JFrame对象
        JFrame jf=new JFrame("Java的第二个GUI程序");
        //设置窗口大小和位置
        jf.setBounds(500,400,400,500);
        //创建一个JPanel对象
        JPanel jp=new JPanel();
        //设置一个标签
        JLabel jl=new JLabel("这是放在Panel上的标签");
        //设置背景色
        jp.setBackground(Color.white);
        //将标签添加至面板
        jp.add(jl);
        //将面板添加至窗体
        jf.add(jp);
        //设置窗体可见
        jf.setVisible(true);
    }

}
