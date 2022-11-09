package JDK9_10_11;

/**
 * @author:superherozhang
 * @create:2022-03-19 20:07
 */
public interface MyInterface {

    //如下的三个方法的权限修饰符都是public
    void methodAbstract();

    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault(){
        System.out.println("我是接口中的默认方法");
    }
    //jdk 9中允许接口中定义私有方法
    void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }
}
