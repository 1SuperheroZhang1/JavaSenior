package cn.yanda.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author superherozhang
 * @create 2022-05-28 16:14
 */
public class BorderLayout_Demo  {
    /**
     * 边界布局管理器
     * */
    public static void BorderLayout01(){
        //创建Frame窗口
        JFrame jFrame=new JFrame("边界布局管理器");
        jFrame.setSize(300,200);
        //为Frame窗口设置布局为BorderLayout
        jFrame.setLayout(new BorderLayout());
        JButton b1=new JButton("上");
        JButton b2=new JButton("左");
        JButton b3=new JButton("中");
        JButton b4=new JButton("右");
        JButton b5=new JButton("下");
        jFrame.add(b1,BorderLayout.NORTH);
        jFrame.add(b2,BorderLayout.WEST);
        jFrame.add(b3,BorderLayout.CENTER);
        jFrame.add(b4,BorderLayout.EAST);
        jFrame.add(b5,BorderLayout.SOUTH);
        jFrame.setBounds(300,200,600,300);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 流式布局管理器
     * */
    public static void BorderLayout02(){
        //创建Frame窗口
        JFrame jFrame=new JFrame("流式布局管理器");
        JPanel jPanel=new JPanel();//创建面板
        JButton btn1=new JButton("1");
        JButton btn2=new JButton("2");
        JButton btn3=new JButton("3");
        JButton btn4=new JButton("4");
        JButton btn5=new JButton("5");
        JButton btn6=new JButton("6");
        JButton btn7=new JButton("7");
        JButton btn8=new JButton("8");
        JButton btn9=new JButton("9");
        jPanel.add(btn1); //面板中添加按钮
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        //向JPanel添加FlowLayout布局管理器，将组件间的横向和纵向间隙都设置为20像素
        jPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        jPanel.setBackground(Color.gray);//设置背景色
        jFrame.add(jPanel);//添加面板到容器
        jFrame.setBounds(300,200,300,150);//设置容器的大小
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * 卡片布局管理器
     * */
    public static void BorderLayout03(){
        JFrame jFrame=new JFrame("卡片布局管理器");//创建Frame窗口
        JPanel p1=new JPanel();//面板1
        JPanel p2=new JPanel();//面版2
        JPanel cards=new JPanel(new CardLayout());//卡片式布局的面板
        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(new JButton("找回密码按钮"));
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(new JTextField("验证码文本框",20));
        cards.add(p1,"card1");//向卡片式布局面板中添加面板1
        cards.add(p2,"card2");//向卡片式布局面板中添加面板2
        CardLayout cl= (CardLayout) cards.getLayout();
//        cl.show(cards,"card1");//调用show()方法显示面板1
        cl.show(cards,"card2");//调用show()方法显示面板2
        jFrame.add(cards);
        jFrame.setBounds(300,200,400,200);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * 网格布局管理器
     * */
    public static void BorderLayout04(){
        JFrame jFrame=new JFrame("网络布局管理器 - 计算器");
        JPanel jp=new JPanel();//创建面板
        //指定面板的布局为GridLayout，4行4列，间隙为5
        jp.setLayout(new GridLayout(4,4,5,5));
        jp.add(new JButton("7"));//添加按钮
        jp.add(new JButton("8"));
        jp.add(new JButton("9"));
        jp.add(new JButton("/"));
        jp.add(new JButton("4"));
        jp.add(new JButton("5"));
        jp.add(new JButton("6"));
        jp.add(new JButton("*"));
        jp.add(new JButton("1"));
        jp.add(new JButton("2"));
        jp.add(new JButton("3"));
        jp.add(new JButton("-"));
        jp.add(new JButton("0"));
        jp.add(new JButton("."));
        jp.add(new JButton("="));
        jp.add(new JButton("+"));
        jFrame.add(jp);//添加面板到容器
        jFrame.setBounds(300,200,200,150);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 网格包布局管理器
     */
    public static void BorderLayout05(){
        JFrame frame=new JFrame("拨号盘");
        GridBagLayout gbaglayout=new GridBagLayout();    //创建GridBagLayout布局管理器
        GridBagConstraints constraints=new GridBagConstraints();
        frame.setLayout(gbaglayout);    //使用GridBagLayout布局管理器
        constraints.fill=GridBagConstraints.BOTH;    //组件填充显示区域
        constraints.weightx=0.0;    //恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER;    //结束行
        JTextField tf=new JTextField("0911-952706");
        gbaglayout.setConstraints(tf, constraints);
        frame.add(tf);
        constraints.weightx=0.5;    // 指定组件的分配区域
        constraints.weighty=0.2;
        constraints.gridwidth=1;
        makeButton("7",frame,gbaglayout,constraints);    //调用方法，添加按钮组件
        makeButton("8",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;    //结束行
        makeButton("9",frame,gbaglayout,constraints);
        constraints.gridwidth=1;    //重新设置gridwidth的值

        makeButton("4",frame,gbaglayout,constraints);
        makeButton("5",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("6",frame,gbaglayout,constraints);
        constraints.gridwidth=1;

        makeButton("1",frame,gbaglayout,constraints);
        makeButton("2",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("3",frame,gbaglayout,constraints);
        constraints.gridwidth=1;

        makeButton("返回",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("拨号",frame,gbaglayout,constraints);
        constraints.gridwidth=1;
        frame.setBounds(400,400,400,400);    //设置容器大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //向JFrame中添加JButton按钮
    public static void makeButton(String title,
                                  JFrame frame,
                                  GridBagLayout gridBagLayout,
                                  GridBagConstraints constraints){
        JButton button=new JButton(title);    //创建Button对象
        gridBagLayout.setConstraints(button,constraints);
        frame.add(button);
    }

    /**
     * 盒布局管理器
     */
    public static void BorderLayout06(){
        JFrame frame=new JFrame("Java示例程序");
        Box b1=Box.createHorizontalBox();    //创建横向Box容器
        Box b2=Box.createVerticalBox();    //创建纵向Box容器
        frame.add(b1);    //将外层横向Box添加进窗体
        b1.add(Box.createVerticalStrut(200));    //添加高度为200的垂直框架
        b1.add(new JButton("西"));    //添加按钮1
        b1.add(Box.createHorizontalStrut(140));    //添加长度为140的水平框架
        b1.add(new JButton("东"));    //添加按钮2
        b1.add(Box.createHorizontalGlue());    //添加水平胶水
        b1.add(b2);    //添加嵌套的纵向Box容器
        //添加宽度为100，高度为20的固定区域
        b2.add(Box.createRigidArea(new Dimension(100,20)));
        b2.add(new JButton("北"));    //添加按钮3
        b2.add(Box.createVerticalGlue());    //添加垂直组件
        b2.add(new JButton("南"));    //添加按钮4
        b2.add(Box.createVerticalStrut(40));    //添加长度为40的垂直框架
        //设置窗口的关闭动作、标题、大小位置以及可见性等
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,400,200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BorderLayout06();
    }
}
