package Thread_Code;

/**
 * 线程的优先级:
 * 1.线程优先级等级:
 *  >MAX_PRIORITY: 10
 *  >MIN_PRIORITY: 1
 *  >NORM_PRIORITY: 5 --->默认优先级
 * 2.如何获取和设置当前线程的优先级:
 *  >getPriority():获取当前线程的优先级
 *  >setPriority(int newPriority):设置当前线程的优先级
 * 3.说明:
 *  >线程创建时继承父线程的优先级
 *  >低优先级只是获取调度的概率低，并非一定是在高优先级线程之后才被调用。
 *  >高优先级的线程会抢占低优先级cpu的执行权，但是只是从概率上讲，高优先级的线程高概率的情况下会被执行。并不意味着
 *   高优先级的线程执行完以后，低优先级的线程才开始。
 * @author:superherozhang
 * @create:2022-03-01 13:12
 */
class SubThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){

//            try {
//                sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
            //yield()方法:释放当前CPU的执行权
//            if(i%20==0){
//                this.yield();
//            }
        }
    }
    public SubThread(String name){
        super(name);
    }

}
public class ThreadPriority {
    public static void main(String[] args)  {
        SubThread s1=new SubThread("Thread:一");
//        s1.setName("线程一");

        //设置分线程的优先级
        s1.setPriority(Thread.MAX_PRIORITY);
        s1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i=0;i<100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+":"+ i);
            }
            if(i==20){
                try {
                    s1.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
        System.out.println(s1.isAlive());//false
    }
}
