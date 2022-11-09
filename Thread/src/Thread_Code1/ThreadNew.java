package Thread_Code1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三: 实现Callable接口。   ---> JDK 5.0新增
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable的方式创建多线程要强大？
 * 1. call()方法可以有返回值
 * 2. call()方法可以抛出异常
 * 3. Callable是支持泛型的
 * @author:superherozhang
 * @create:2022-03-02 11:12
 */
//1.创建一个实现Callable接口的实现类
class NumThread implements Callable{
    //2.实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread num=new NumThread();
        //4.将此Callable接口的实现类对象作为参数传递到FutureTask的构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask<>(num);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6.获取Callable接口中call方法的返回值
            //get()返回值即为FutureTask构造器参数的Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为:"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
