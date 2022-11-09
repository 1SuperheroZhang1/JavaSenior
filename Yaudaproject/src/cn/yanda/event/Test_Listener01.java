package cn.yanda.event;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * @author superherozhang
 * @create 2022-05-29 8:24
 */
public class Test_Listener01 extends JFrame {
    public Test_Listener01(){
        init();
    }

    public void init(){
        this.setSize(400,300);
        this.setTitle("第一个JFrame窗体");
//        this.setIconImage(image);
        //处理用户点击关闭的事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //使用事件处理机制
        this.setResizable(false);
        this.setVisible(true);
        //注册一个窗体焦点的监听器
        this.addWindowFocusListener(new Test_Listener01.MyFocus());
    }

    //内部类，用于处理窗体焦点的监听器
    public class MyFocus implements WindowFocusListener{

        @Override
        public void windowGainedFocus(WindowEvent e) {
            System.out.println("游戏正在进行...");
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            System.out.println("游戏暂停...");
        }
    }

    public static void main(String[] args) {
        new Test_Listener01();
    }

}
