package Generic_Code;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 泛型的使用：
 * 1. jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *     总结：
 *      ① 集合接口或集合类在jdk 5.0时都修改为带泛型的结构。
 *      ② 在实例化集合类时，可以指明具体的泛型类型
 *      ③ 指明完以后，集合类和接口中凡是定义类和接口时，内部结构(比如：方法、构造器、属性等)使用到类的泛型的位置，都指定为实例化的泛型类型
 *      ④ 注意点：泛型的类型必须是类，不能使用基本数据类型，需要使用基本数据类型的位置，应该使用包装类
 *      ⑤ 如果实例化时，没有指明泛型的类型，则默认类型为java.lang.Object类型
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法
 * @author:superherozhang
 * @create:2022-03-15 10:31
 */
public class GenericTest {
    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        //需求：存放学生的成绩
        list.add(87);
        list.add(78);
        list.add(80);
        list.add(67);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score:list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore= (Integer) score;

            System.out.println(stuScore);
        }
    }
    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(87);
        list.add(78);
        list.add(80);
        list.add(67);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一：
//        for(Integer score:list){
//            //避免了强转操作
//            int stuScore=score;
//            System.out.println(stuScore);
//        }
        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }
    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
//        Map<String,Integer> map=new HashMap<String,Integer>();
        //jdk 7新特性：类型推断
        Map<String,Integer> map=new HashMap<>();
        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry= map.entrySet();

        Iterator<Map.Entry<String,Integer>> iterator=entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+"-------->"+value);
        }
    }
    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order=new Order<>();
        Integer[] arr=new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
