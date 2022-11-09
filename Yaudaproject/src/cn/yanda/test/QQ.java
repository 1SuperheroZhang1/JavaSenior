package cn.yanda.test;

import javax.swing.*;
import java.awt.*;

/**
 * ①JFrame类常用的构造方法：
 * public JFrame(): 创建一个初始不可见、没有标题的新窗体
 * public JFrame(String title): 创建一个不可见但具有标题的窗体。
 * ②JDialog类常用的构造方法：
 * public JDialog(): 创建一个没有标题和父窗体的对话框
 * public JDialog(Frame f): 创建一个指定父窗体的对话框，但该窗体没有标题。
 * public JDialog(Frame f,boolean model): 创建一个指定类型的对话框，并指定父窗体，但该窗体没有指定标题。
 * public JDialog(Frame f,String title): 创建一个指定标题和父窗体的对话框。
 * public JDialog(Frame f,String title,boolean model): 创建一个指定标题、窗体和模式的对话框。
 * ③JLabel类常用的几个构造方法如下：
 * public JLabel(): 创建一个不带图标和文本的JLabel对象
 * public JLabel(Icon icon): 创建一个带图标的JLabel对象
 * public JLabel(Icon icon,int alignment): 创建一个带图标的JLabel对象，并设置图标水平对齐方式
 * public JLabel(String text,int alignment): 创建一个带文本的JLabel对象，并设置文字水平对齐方式
 * public JLabel(String text,Icon icon,int alignment): 创建一个带文本、带图标的JLabel对象，并设置标签内容的水平对齐方式
 * ④创建图标：在swing中通过Icon接口来创建图标，实现Icon接口的3个方法：
 * public int getIconHeight(): 获取图标的长
 * public int getIconWidth():获取图标的宽
 * public void paintIcon(Component arg0,Graphics arg1,int arg2,int arg3): 实现在指定坐标位置画图
 * ⑤使用图片图标: ImageIcon类常用的几个构造方法如下：
 * public ImageIcon(): 创建一个通用的ImageIcon对象，当真正需要设置图片时再使用ImageIcon对象调用setImage(Image image)方法来操作。
 * public ImageIcon(Image image): 可以直接从图片源创建图标
 * public ImageIcon(Image image,String description): 可以从图片源创建图标，还可以为这个图标添加简短的描述(不会在图标上显示)
 * public ImageIcon(URL url): 利用位于计算机网络上的图像文件创建图标。
 * ⑥JButton类常用的几个构造方法如下；
 * public JButton():可以生成不带任何文本组件的对象和图标
 * public JButton(String text):
 * public JButton(Icon icon):
 * public JButton(String text,Icon icon):
 * ⑦JRadioButton类常用的几个构造方法如下：
 * public JRadioButton():
 * public JRadioButton(Icon icon):
 * public JRadioButton(Icon icon,boolean selected):
 * public JRadioButton(String text):
 * public JRadioButton(String text,Icon icon):
 * public JRadioButton(String text,Icon icon,boolean selected):
 * ⑧JCheckBox类常用构造方法如下：
 * public JCheckBox():
 * public JCheckBox(Icon icon,boolean checked):
 * public JCheckBox(String text,boolean checked):
 * ⑨JList类常用的构造方法如下：
 * public void JList():
 * public void JList(Object[] listData):
 * public void JList(Vector listData):
 * public void JList(ListModel dataModel):
 * ⑩JTextField类常用的构造方法如下：
 * public JTextField():
 * public JTextField(String text):
 * public JTextField(int fieldwidth):
 * public JTextField(String text,int fieldwidth):
 * public JTextField(Document docModel,String text,int fieldWidth):
 * ⑩①JPasswordField类常用的构造方法如下：
 * public JPasswordField():
 * public JPasswordField(String text):
 * public JPasswordField(int fieldwidth):
 * public JPasswordField(String text,int fieldwidth):
 * public JPasswordField(Document docModel,String text,int fieldWidth):
 * ⑩②JTextArea类常用的构造方法如下：
 * public JTextArea():
 * public JTextArea(String text):
 * public JTextArea(int rows,inr columns):
 * public JTextArea(Document doc):
 * public JTextArea(Document doc,String Text,int rows,inr columns):
 * @author superherozhang
 * @create 2022-05-23 21:57
 */
public class QQ extends JFrame {

    private final int width=642;
    private final int height=495;
    public void initQQ(){
        JFrame jf=new JFrame();
        jf.setTitle("QQ");
        jf.setLayout(null);
        jf.setSize(width,height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭时退出程序
        Container container=jf.getContentPane();
        //加组件
            //图片 - 标签
        ImageIcon img=new ImageIcon("");
        JLabel jl=new JLabel(img);



        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
            new QQ();
    }

}
