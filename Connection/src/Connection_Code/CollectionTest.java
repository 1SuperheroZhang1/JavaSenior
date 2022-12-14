package Connection_Code;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *   说明: 此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储(.txt,.avi,.jpg,数据库中)
 *
 * 2.1 数组在存储多个数据方面的特点:
 *      > 一旦初始化之后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。就只能操作指定类型的数据了。
 *          比如: String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点:
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便。同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用。
 *      > 数组存储数据的特点: 有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *  |------Collection接口:单列集合，用来存储一个一个的对象
 *      |------List接口: 存储有序的、可重复的数据   -->“动态”数组
 *           |------ArrayList、LinkedList、Vector
 *
 *      |------Set接口: 存储无序的、不可重复的数据   -->高中讲的"集合"
 *           |------HashSet、LinkedHashSet、TreeSet
 *
 *  |------Map接口: 双列集合，用来存储(key-value)一对一对的数据  --> 高中函数: y=f(x)
 *           |------HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *  三、Collection接口中的方法的使用
 *      向Collection接口的实现类对象中添加数据obj时，要求obj所在的类要重写equals()方法
 * @author:superherozhang
 * @create:2022-03-12 12:16
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();

        //1.add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //2.size():获取添加的元素的个数
        System.out.println(coll.size());//4

        //3.addAll(Collection coll1):将集合coll1中的元素添加到当前集合中
        Collection coll1=new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());//6
        System.out.println(coll);

        //4.clear():清空集合元素
        coll.clear();

        //5.isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());//true
    }
    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
//        Person p=new Person("Jerry",20);
//        coll.add(p);
        coll.add(false);
        //1.contains(Object obj): 判断当前集合中是否包含obj，在判断时，会去调用obj对象所在类的equals()方法
        boolean contains = coll.contains(456);
        System.out.println(contains);//true
        System.out.println(coll.contains(new String("Tom")));//true
//        System.out.println(coll.contains(p));//true
        System.out.println(coll.contains(new Person("Jerry", 20)));//false --->true(重写Person类的equals方法)

        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1= Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));//true

        //3.remove(Object obj): 从当前集合中移除obj元素，删除成功，返回true。删除失败，返回false
        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll1):从当前集合中移除coll1中的元素(差集)
        coll.removeAll(coll1);
        System.out.println(coll);
    }
    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        //5.retainAll(Collection coll1):交集，获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1= Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);
//
        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll1=new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(new Person("Jerry",20));
        coll1.add(false);

        System.out.println(coll.equals(coll1));//true
    }
    @Test
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 --> 数组 : toArray()
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //拓展: 数组 --> 集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List<Integer> arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中
    }
}
