package Thread_Code;

/**
 * 使用同步方法解决继承Thread类的线程安全问题
 * @author:superherozhang
 * @create:2022-03-01 21:52
 */
class _Window_ extends Thread{
    private static int ticket=100;

    @Override
    public void run() {

        while(true){
            show();
        }
    }
    private static synchronized void show(){ //同步监视器: _Window_.class
    //private synchronized void show(){ //同步监视器this: t1,t2,t3,3个对象,此种解决方式是错误的
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+": 卖票，票号为:"+ticket);
            ticket--;
        }
    }
}
public class WindowTest_MethodSolve {
    public static void main(String[] args) {
        _Window_ t1=new _Window_();
        _Window_ t2=new _Window_();
        _Window_ t3=new _Window_();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
