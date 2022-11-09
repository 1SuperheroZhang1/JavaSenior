package Thread_Code;

/**
 * 测试Thread类中的常有方法:
 * 1.start():①启动当前线程②调用当前线程的run()方法
 * 2.run(): 通常需要重写Thread类中的此方法，将创建的线程需要的操作声明在此方法中
 * 3.CurrentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前CPU的执行权
 * 7.join():在线程a中调用线程b的join()方法,此时线程a就进入阻塞状态，直到线程b完全执行完后，线程a才结束阻塞状态。
 * 8.stop():已过时。当执行此方法时，强制结束当前线程
 * 9.sleep(long millitime):让当前线程"睡眠"指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
 * 10.isAlive():判断当前线程是否存活。
 *
 *
 * 线程通信: wait()/notify()/notifyAll(): 此三个方法定义在Object类中
 * @author:superherozhang
 * @create:2022-03-01 12:34
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        //yield()方法:释放当前CPU的执行权
//            if(i%20==0){
//                this.yield();
//            }
        }
    }
    public HelloThread(String name){
        super(name);
    }

}
public class ThreadMethodTest {
    public static void main(String[] args)  {
        HelloThread t1=new HelloThread("Thread:一");
//        t1.setName("线程一");
        t1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
            for(int i=0;i<100;i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
                if(i==20){
                    try {
                        t1.join();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        System.out.println(t1.isAlive());//false
        }
}
