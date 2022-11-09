package cn.yanda.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author superherozhang
 * @create 2022-05-22 9:46
 */
public class login extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JFrame");
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("用户名:");
        JTextField tf = new JTextField(10);
        p1.add(l1);
        p1.add(tf);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("密码:");
        JPasswordField pwf = new JPasswordField(10);
        p2.add(l2);
        p2.add(pwf);

        frame.add(p1);
        frame.add(p2);

        JLabel gender = new JLabel("性别:");
        frame.add(gender);

        ButtonGroup buttonGroup = new ButtonGroup();
        String[] sex = new String[]{"男", "女"};
        JRadioButton buttons[] = new JRadioButton[sex.length];
        for (int i = 0; i < sex.length; i++) {
            buttons[i] = new JRadioButton(sex[i]);
            buttonGroup.add(buttons[i]);
            frame.add(buttons[i]);
        }
        buttons[0].setSelected(true);

        String hobbies[] = {"跑步", "篮球", "乒乓球"};
        JCheckBox[] checkBoxes = new JCheckBox[hobbies.length];
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(hobbies[i]);
            frame.add(checkBoxes[i]);
        }
        checkBoxes[0].setSelected(true);

        frame.add(new Label("description:"));
        JTextArea ta = new JTextArea(6, 6);
        frame.add(ta);

        JButton button = new JButton("注册");
        button.setSize(100, 100);
        button.setLocation(200, 300);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了！！！");
            }
        });
        frame.add(button);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}