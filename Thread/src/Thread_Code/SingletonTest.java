package Thread_Code;

/**
 * 使用同步机制解决懒汉式单例模式的线程安全问题
 * @author:superherozhang
 * @create:2022-03-01 22:02
 */
public class SingletonTest {
}
class Singleton{
    //1.私有化类的构造器
    private Singleton(){

    }
    //2.在类内部创建类的对象
    //4.
    private static Singleton instance=null;
    //3.在方法中返回当前类的对象
    public static  Singleton getInstance(){
        //方式一:效率稍差
//        synchronized(Singleton.class){
//            if(instance==null){
//                instance=new Singleton();
//            }
//            return instance;
//        }
        //效率更高
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
//    public synchronized  static  Singleton getInstance(){
//        synchronized(Singleton.class){
//            if(instance==null){
//                instance=new Singleton();
//            }
//            return instance;
//        }
//    }
}
