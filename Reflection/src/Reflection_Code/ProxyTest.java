package Reflection_Code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 反射的应用：动态代理
 * 动态代理的举例：
 * @author:superherozhang
 * @create:2022-03-17 20:05
 */
interface Human{

    String belief();

    void eat(String food);

}
//被代理类
class SuperMan implements Human{

    @Override
    public String belief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
/*
* 要想实现动态代理，需要解决的问题？
* 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象？
* 问题二：当通过代理类的对象调用方法A时，如何动态地去调用被代理中的同名方法A？
* */
class ProxyFactory{
    //调用此方法，解决问题一：返回代理类的对象，根据加载到内存中的被代理类，动态的创建代理类对象
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象

        MyInvocationHandler handler=new MyInvocationHandler();

        handler.bind(obj);


        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler {

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj=obj;
    }

    //当通过代理类的对象，调用方法A时，就会自动调用如下的方法：invoke()
    //将被代理类要执行的方法A的功能，声明在invoke()方法中。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method():即为代理类对象调用的方法，此方法也就作为被代理对象要调用的方法。
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值就作为当前类中的invoke()方法的返回值。
        return returnValue;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        //superMan:创建被代理类对象
        SuperMan superMan=new SuperMan();
        //proxyInstance:代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);


        System.out.println("------------------动态代理-----------------");

        //当通过代理类对象调用方法时，会自动的调用被代理类中的同名方法
        String belief = proxyInstance.belief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("*****************************");

        System.out.println("------------------静态代理-----------------");

        //创建被代理类对象
        NikeClothFactory nikeClothFactory=new NikeClothFactory();
        //创建代理类对象
        ClothFactory proxyCLothFactory= (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        //调用代理类对象的方法：自动调用被代理类中同名的方法
        proxyCLothFactory.produceCloth();
    }
}
