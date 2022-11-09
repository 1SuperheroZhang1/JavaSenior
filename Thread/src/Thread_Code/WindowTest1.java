package Thread_Code;

/**
 * 例子:创建三个窗口买票，总票数是100张 使用实现Runnable接口的方式
 * 仍然存在线程安全的问题，待解决:
 * @author:superherozhang
 * @create:2022-03-01 14:00
 */
//1.创建实现Runnable接口的实现类
class Windows implements Runnable{

    private int ticket=100;
    //2.重写Runnable接口的抽象方法:run()
    @Override
    public void run() {
        while(true){
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":,卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        Windows w=new Windows();
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
