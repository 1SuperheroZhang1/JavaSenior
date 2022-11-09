package cn.yanda.event;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * @author superherozhang
 * @create 2022-05-29 8:45
 */
public class Test_Listener02  extends JFrame{
    public Test_Listener02(){
        init();
    }
    public void init(){
        this.setSize(400,300);
        this.setTitle("第一个JFrame窗体");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("游戏正在继续...");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("游戏暂停...");
            }
        });
    }

    public static void main(String[] args) {
        new Test_Listener02();
    }
}
