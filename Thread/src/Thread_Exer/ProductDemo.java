package Thread_Exer;

/**
 * 线程通信的应用: 生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20),
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，
 * 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 这里可能会出现两个问题:
 * >生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * >消费者比生产者快时，消费者会取相同的数据。
 *
 * 分析:
 * 1.是否是多线程问题？ 是，消费者线程，生产者线程
 * 2.是否有共享数据？ 有，产品(或店员)
 * 3.如何解决线程安全问题？ 同步机制，有3种方法。
 * 4.是否涉及到线程的通信？ 是
 * @author:superherozhang
 * @create:2022-03-02 10:41
 */
class Clerk{
    private int productCount=0;
    //生产产品
    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }else{
            try {
                //等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public  synchronized void consumeProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else{
            try {
                //等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Productor extends Thread{//生产者
    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品...");

        while(true){

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
class Consumer extends Thread{//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品...");

        while(true){

            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
public class ProductDemo {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();

        Productor p=new Productor(clerk);
        p.setName("生产者");

        Consumer c=new Consumer(clerk);
        c.setName("消费者");

        p.start();
        c.start();
    }
}
