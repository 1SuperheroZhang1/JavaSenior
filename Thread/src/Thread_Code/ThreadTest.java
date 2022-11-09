package Thread_Code;
/**
 * 多线程的创建
 * 方式一: 继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()方法 --->将此线程执行的操作声明在run()方法中
 * 3.创建Thread类的子类的对象
 * 4.调用对象的start()方法: ①启动当前线程 ②调用当前线程的run()方法
 *
 * 例子:遍历100以内的所有偶数
 * @author:superherozhang
 * @create:2022-03-01 11:56
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    ////2.重写Thread类的run()方法
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1=new MyThread();
        //4.调用对象的start()方法: ①启动当前线程 ②调用当前线程的run()方法
        t1.start();
        //问题一: 不能通过直接调用run()方法来启动线程。
//            t1.run();//err
        //问题二: 再启动一个线程，遍历100以内的偶数。不可以还让已经start()的线程去执行。会报IllegalThreadStateException异常。
        //t1.start();//err - IllegalThreadStateException
        //需要重新创建一个线程对象，调用start()方法
        MyThread t2=new MyThread();
        t2.start();
        //如下操作仍然是在main()线程中执行的
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+" "+i+"**********main()**********");
            }
        }
    }
}

