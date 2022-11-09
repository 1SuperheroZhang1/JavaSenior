package Thread_Code;

/**
 * 例子:创建三个窗口买票，总票数是100张 使用实现Runnable接口的方式
 * 使用同步代码块解决实现Runnable接口的线程安全问题
 * 1.问题: 卖票过程中，出现了重票、错票 --->出现了线程安全的问题
 * 2.问题出现的原因: 当某个线程操作车票的过程中，尚未完成操作时，其他线程参与进来，也操作车票。
 * 3.如何解决:当一个线程a在操作车票ticket的时侯，其他线程不能参与进来。直到线程a操作完ticket时，其他线程才可以开始操作ticket。
 *           这种情况即使线程a出现了阻塞，也不能被改变。
 * 4.在Java中，通过同步机制，来解决线程的安全问题。
 *
 * 方式一: 同步代码块
 *synchronized(同步监视器){
 *      //需要被同步的代码
 *  }
 *  说明: 1.需要操作共享数据的代码，即为需要被同步的代码。  -->不能包含代码多了，也不能包含代码少了
 *       2.共享数据:多个线程共同操作的变量。比如:ticket就是共享数据
 *       3.同步监视器,俗称:锁。 任何一个类的对象，都可以充当锁。
 *          要求:多个线程必须共用同一把锁。
 *  补充: 在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器
 * 方式二: 同步方法
 *          如果操作同步数据的代码完整的声明在方法中，不妨将此方法声明为同步的。
 *
 * 5.同步的方式，解决了线程的安全问题。 -->好处
 *   操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低。 -->局限性
 *
 * 释放锁的操作:
 *   >当前线程的同步方法，同步代码块执行结束。
 *   >当前线程在同步代码块、同步方法中遇到break、return终止了该代码块、该方法的继续执行。
 *   >当前线程在同步代码块、同步方法中出现了未处理的Error或Exception,导致异常结束。
 *   >当前线程在同步代码块、同步方法中执行了线程对象的wait()方法，当前线程暂停，并释放锁。
 * 不会释放锁的操作:
 *   >线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行。
 *   >线程执行同步代码块时，其他线程调用了该线程的suspend()方法，将该线程挂起，该线程不会释放锁(同步监视器)
 *      >应尽量避免使用suspend()和resume()来控制线程。
 * @author:superherozhang
 * @create:2022-03-01 21:16
 */
//1.创建实现Runnable接口的实现类
class Windows_ implements Runnable{

    private int ticket=100;
    Object obj=new Object();
    //2.重写Runnable接口的抽象方法:run()
    @Override
    public void run() {
        while(true){
            synchronized(this){//此时的this:唯一的Windows_对象 //方式二:synchronized(obj) {
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
}
public class WindowTest1_BlockSolve {
    public static void main(String[] args) {
        //3.创建实现类的对象
        Windows_ w=new Windows_();
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


