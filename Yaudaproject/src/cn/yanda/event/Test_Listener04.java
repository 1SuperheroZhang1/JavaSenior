package cn.yanda.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author superherozhang
 * @create 2022-05-29 10:10
 */
public class Test_Listener04 extends JFrame {
    public Test_Listener04(){
        init();
    }

    public void init(){
        this.setSize(400,500);
        this.setTitle("第一个JFrame面板");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container=this.getContentPane();
        container.setBackground(Color.BLUE);

        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            /**
             * windowOpened(WindowEvent e)
             当窗口打开时调用。
             * */
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened()...");
            }

            /**
             * windowClosing(WindowEvent e) 当窗口处于关闭状态时调用。
             * */
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing()...");
            }

            /**
             * windowClosed(WindowEvent e) 当窗口关闭时调用。
             * */
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed()...");

            }

            /**
             * windowIconified(WindowEvent e) 当窗口被图标化时调用。
             * */
            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified()...");
            }


            /**
             * windowDeiconified(WindowEvent e) 当窗口被去图标化时调用。
             * */
            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified()...");
            }

            /**
             * windowActivated(WindowEvent e) 激活窗口时调用。
             * */
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowClosed()...");
            }

            /**
             * windowDeactivated(WindowEvent e) 当窗口被禁用时调用。
             * */
            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated()...");
            }

            /**
             * windowStateChanged(WindowEvent e) 当窗口状态改变时调用。
             * */
            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("windowStateChanged()...");
            }

            /**
             * windowGainedFocus(WindowEvent e) 当窗口设置为聚焦窗口时调用，这意味着窗口或其子组件之一将接收键盘事件。
             * */
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("windowGainedFocus()...");
            }


            /**
             * windowLostFocus(WindowEvent e)
             当窗口不再是聚焦窗口时调用，这意味着键盘事件将不再传递到窗口或其任何子组件。
             * */
            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("windowLostFocus()...");
            }
        });
    }

    public static void main(String[] args) {
        new Test_Listener04();
    }

}
