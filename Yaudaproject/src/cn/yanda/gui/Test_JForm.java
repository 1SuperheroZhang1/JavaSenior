package cn.yanda.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author superherozhang
 * @create 2022-05-22 8:20
 */
public class Test_JForm extends JFrame {
    //窗口长度
    private final int width=800;
    private final int height=600;

    //窗口的启动方法
    public void launch(){
        //标题
        setTitle("坦克大战");
        //窗口初始大小
        setSize(width,height);
        //使屏幕居中
        setLocationRelativeTo(null);
        //添加关闭事件
        setDefaultCloseOperation(3);
        //用户不能调整大小
        setResizable(false);

//        Button button=new Button();
//        button.setLabel("按钮");
//        button.setSize(0,0);
//        button.setLocation(200,200);
//        add(button);

        JButton button=new JButton("按钮");
        button.setLocation(0,50);
        button.setSize(100,50);
        add(button);

        setLayout(new FlowLayout());
        //使窗口可见
        setVisible(true);
    }

    public static void main(String[] args) {
        Test_JForm test=new Test_JForm();
        test.launch();
    }
}

