package cn.yanda.event;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author superherozhang
 * @create 2022-05-29 9:12
 */
public class Test_Listener03  extends JFrame{
    public Test_Listener03(){
        init();
    }
    public void init(){
        this.setSize(400,500);
        this.setTitle("第一个JFrame窗体");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
        this.setVisible(true);
        this.addWindowListener(new MyListener());
    }

    public class MyListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            int i=JOptionPane.showConfirmDialog(null,"你没有保存","choose one",JOptionPane.YES_NO_CANCEL_OPTION);
            if(i==1){
                JOptionPane.showMessageDialog(null,"你点了否","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(i==2){
                JOptionPane.showMessageDialog(null,"你点了取消","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"你点了是","警告",JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    public static void main(String[] args) {
        new Test_Listener03();
    }
}
