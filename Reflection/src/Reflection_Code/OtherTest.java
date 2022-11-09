package Reflection_Code;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author:superherozhang
 * @create:2022-03-17 17:53
 */
public class OtherTest {
    /*
    * 获取运行时类的构造器结构
    * */
    @Test
    public void test1() throws NoSuchMethodException {
        Class<Person_> clazz = Person_.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructor = clazz.getConstructors();
        for(Constructor c:constructor){
            System.out.println(c);
        }

        System.out.println("*******************************");
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }
    }

    /*
    * 获取运行时类的父类
    * */
    @Test
    public void test2(){
        Class<Person_> clazz = Person_.class;
        Class<? super Person_> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
     * 获取运行时类的带泛型的父类
     * */
    @Test
    public void test3(){
        Class<Person_> clazz = Person_.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
     * 获取运行时类的带泛型的父类的泛型
     * */
    @Test
    public void test4(){
        Class<Person_> clazz = Person_.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType= (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        for(Type t:actualTypeArguments){
//            System.out.println(t.getTypeName());
            System.out.println(((Class)t).getName());
        }
    }

    /*
    * 获取运行时类实现的接口
    * */
    @Test
    public void test5(){
        Class<Person_> clazz = Person_.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class c:interfaces){
            System.out.println(c.getName());
        }

        System.out.println("****************************");

        //获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c:interfaces1){
            System.out.println(c.getName());
        }
    }

    /*
    * 获取当前运行时类所在的包
    * */
    @Test
    public void test6(){
        Class<Person_> clazz = Person_.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
    * 获取运行时类声明的注解
    * */
    @Test
    public void test7(){
        Class<Person_> clazz = Person_.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a:annotations){
            System.out.println(a);
        }
    }
}
