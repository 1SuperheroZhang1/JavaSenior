package Reflection_Code;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 一、Java反射机制提供的功能
 * > 在运行时判断任意一个对象所属的类
 * > 在运行时构造任意一个类的对象
 * > 在运行时判断任意一个类所具有的成员变量和方法
 * > 在运行时获取泛型信息
 * > 在运行时调用任意一个对象的成员变量和方法
 * > 在运行时处理注解
 * > 生成动态代理
 *
 * 二、反射相关的主要API
 * > java.lang.Class:代表一个类
 * > java.lang.reflect.Method:代表类的方法
 * > java.lang.reflect.Field:代表类的成员变量
 * > java.lang.reflect.Constructor:代表类的构造器
 * > ...
 *
 *三、哪些类型可以有Class对象？
 * > class: 外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
 * > interface: 接口
 * > []: 数组
 * > enum: 枚举
 * > annotation: 注解@interface
 * > primitive type: 基本数据类型
 * > void:
 * @author:superherozhang
 * @create:2022-03-16 12:22
 */
public class ReflectionTest {
    //反射之前，对于Person类的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p=new Person("Tom",12);

        //2.通过对象，调用其内部的属性、方法。
        p.age=10;
        System.out.println(p.toString());

        p.show();

        //在Person类的外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name,showNation()以及私有的构造器
    }
    //反射之后，对于Person类的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //1.通过反射：创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p= (Person) obj;
        System.out.println(obj.toString());
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*****************************************");
        //通过反射，可以调用Person类的私有结构。比如：私有的构造器，私有的属性，私有的方法。
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"韩梅梅");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");//相当于p1.showNation("中国")
        System.out.println(nation);

    }
    /*
     * 疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
     * 建议：使用直接new的方式
     * 疑问2：反射机制与面向对象的封装性是不是矛盾的？如何看待这两个技术？
     * 不矛盾
     * */
    /*
    * 关于java.lang.Class类的理解
    * 1.类的加载过程：
    * 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)
    * 接着使用java.exe命令对某个字节码文件进行解释运行。
    * 相当于将某个字节码文件加载到内存中，此过程就称为类的加载。
    * 加载到内存中的类，就称为运行时类，就作为Class类的一个实例。
    * 2.Class的实例就对应着一个运行时类。
    * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间内，可以通过不同的方式获取此运行时类。
    * */
    //如何获取Class类的实例？
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性:.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()
        Person p1=new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class类的静态方法，forName(String classPath)
        Class clazz3 = Class.forName("Reflection_Code.Person");
//        clazz3=Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz3);//true
        System.out.println(clazz1 == clazz2);//true

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("Reflection_Code.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);//true
    }

    //Class实例可以是哪些结构的说明：
    @Test
    public void test4(){
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] a=new int[10];
        int[] b=new int[100];
        Class<? extends int[]> c10 = a.getClass();
        Class<? extends int[]> c11 = b.getClass();
        //只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);//true
    }
}
