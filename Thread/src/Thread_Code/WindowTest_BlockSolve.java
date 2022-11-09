package Thread_Code;

/**
 * 例子:创建三个窗口买票，总票数是100张 使用继承Thread类的方式
 * 使用同步代码块来解决继承Thread类的线程安全问题
 *
 * 说明:在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类来充当同步监视器。
 * @author:superherozhang
 * @create:2022-03-01 21:22
 */
class Window_ extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run() {

        while(true) {
            //正确的
//            synchronized (obj) {
            synchronized(Window_.class){//Class clazz=Window_.class; Window_.class只会加载一次
              //错误的方式:this代表着t1,t2,t3，3个对象
//            synchronized(this){
                if (ticket > 0) {
                    System.out.println(getName() + ": 卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindowTest_BlockSolve {
    public static void main(String[] args) {
        Window_ t1=new Window_();
        Window_ t2=new Window_();
        Window_ t3=new Window_();

        t1.setName("窗口1");
        t1.start();
        t2.setName("窗口2");
        t2.start();
        t3.setName("窗口3");
        t3.start();
    }
}
