package Thread_Code;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全的方式三: Lock锁 --->JDK 5.0新增
 *
 * 1.面试题: synchronized和Lock的异同？
 * 相同:二者都可以解决线程安全问题
 * 不同: synchronized机制在执行完相应的同步代码以后，自动地释放同步监视器
 *      Lock需要手动的启动同步(lock()),同时结束同步(unlock())也需要手动的实现
 * 2.优先使用顺序:
 *     Lock->同步代码块(已经进入了方法体，分配了相应的资源)->同步方法(在方法体之外)
 * 3.面试题:如何解决线程安全问题?有几种方式
 * @author:superherozhang
 * @create:2022-03-01 22:39
 */
public class LockTest {
    public static void main(String[] args) {
        Station s=new Station();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Station implements Runnable{

    private int ticket=100;
    //1.实例化ReentrantLock对象
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
           try{
               //2.调用锁定方法:lock()
               lock.lock();
               if(ticket>0){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+":卖票,票号为"+ticket);
                   ticket--;
               }else{
                   break;
               }
           }finally{
                //3.调用解锁方法:unlock()
               lock.unlock();
           }
        }
    }
}
