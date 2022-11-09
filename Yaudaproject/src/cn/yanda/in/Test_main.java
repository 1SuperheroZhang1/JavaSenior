package cn.yanda.in;

/**
 * @author superherozhang
 * @create 2022-05-29 8:49
 */
public class Test_main {
    public static void main(String[] args) {
        //1.接口对象构建
        Test_in in=new Test_im();
        in.test01();//打印 - 重写接口方法

        //2.接口对象构建
        Test_in iin=new Test_in(){
            @Override
            public void test01() {
                System.out.println("自己重写接口方法");
            }
        };
    }
}
