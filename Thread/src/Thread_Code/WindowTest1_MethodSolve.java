package Thread_Code;

/**
 * 使用同步方法来解决实现Runnable接口的线程安全问题。
 * 关于同步方法的总结:
 * 1.同步方法仍然涉及到同步监视器，只是不需要显式声明
 * 2.非静态的同步方法，同步监视器是:this
 * 3.静态的同步方法，同步监视器是: 当前类本身
 * @author:superherozhang
 * @create:2022-03-01 21:44
 */
//1.创建实现Runnable接口的实现类
class _Windows_ implements Runnable{

    private int ticket=100;
    //2.重写Runnable接口的抽象方法:run()
    @Override
    public void run() {
        while(true){
            show();
        }
    }
    private synchronized void show(){ //同步监视器:this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":,卖票，票号为:" + ticket);
            ticket--;
        }
    }

}
public class WindowTest1_MethodSolve {
    public static void main(String[] args) {
        //3.创建实现类的对象
        _Windows_ w=new _Windows_();
        //4.将实现类作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

