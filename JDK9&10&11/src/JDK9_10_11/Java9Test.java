package JDK9_10_11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * jdk9新特性：
 *  >1.jdk目录结构的改变
 *  >2.模块化系统
 *  >3.Java的REPL工具:jshell
 *  >4.接口中声明私有方法
 *  >5.钻石操作符的语法升级
 *  >6.try结构的语法升级
 *  >7.String存储结构变更： char[] value -> Byte[] value
 *  >8.集合工厂方法：快速创建只读集合。
 *  >9.InputStream加强：transferTo可以用来将数据直接传输到OutputStream。
 *  >10.StreamAPI的加强
 * //                  >takeWhile()
 * //                  >dropWhile()
 * //                  >ofNullable()
 * //                  >iterate():重载了java8中的方法，添加了终止条件
 *  >11.Optional提供了新的方法stream()
 *  >12.JavaScript引擎升级：Nashorn
 * @author:superherozhang
 * @create:2022-03-19 20:02
 */
public class Java9Test {

    //Java9特性五：钻石操作符的升级
    @Test
    public void test1(){
        //钻石操作符和匿名内部类在Java8中不能共存。在Java9可以。
        Comparator<Object> com=new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        //jdk7新特性：类型推断
        ArrayList<String> list=new ArrayList<>();

    }
    //java9特性六：try语句升级
    public static void main(String[] args) {
        //java8之前的资源关闭操作。
//        InputStreamReader reader= null;
//        try {
//            reader = new InputStreamReader(System.in);
//            char[] ch=new char[20];
//            int len;
//            if((len=reader.read(ch))!=-1){
//                String str=new String(ch,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//           if(reader!=null){
//               try {
//                   reader.close();
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//           }
//        }
        //Java 8中的资源关闭操作：要求自动关闭资源的初始化，必须放在try的一对小括号中
        //Java 8中，可以实现资源的自动关闭，但是要求执行后必须关闭的所有资源必须在try子句中初始化，否则编译不通过。
//        try(InputStreamReader reader=new InputStreamReader(System.in)){
//            char[] ch=new char[20];
//            int len;
//            if((len=reader.read(ch))!=-1){
//                String str=new String(ch,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //java 9中关闭资源操作：需要自动关闭的资源的实例化可以放在try的一对小括号外边
        //此时的资源属性是常量，声明为final的，不可修改
        InputStreamReader reader=new InputStreamReader(System.in);
        try(reader){
            char[] ch=new char[20];
            int len;
            if((len=reader.read(ch))!=-1){
                String str=new String(ch,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //java9新特性八：集合工厂方法：创建只读集合
    @Test
    public void test2(){
        //jdk8及之前
//        List<String> namesList=new ArrayList<>();
//        namesList.add("Joe");
//        namesList.add("Bob");
//        namesList.add("Bill");
//        //返回的namesList是一个只读的集合
//        namesList= Collections.unmodifiableList(namesList);
//        //报异常UnsupportedOperationException
////        namesList.add("Tom");
//
//        System.out.println(namesList);

        //jdk9
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        //不能添加
//        list.add(6);
        System.out.println(list);

        Set<Integer> set = Set.of(23, 3, 54, 65, 43, 76, 87, 34, 46);
        //不能添加
//        set.add(4);
        System.out.println(set);

        Map<String, Integer> map = Map.of("Tom", 23, "Jerry", 43);
        //不能添加
//        map.put("Lilei",34);
        System.out.println(map);
    }
    //java9新特性九：InputStream的新方法：transferTo()
    //java9新特性十：StreamAPI的加强
//                  >takeWhile()
//                  >dropWhile()
//                  >ofNullable()
//                  >iterate():重载了java8中的方法，添加了终止条件
    @Test
    public void test3(){
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 7, 8, 4, 3);
//        //takeWhile():用于从Stream中获取一部分数据，接受一个Predicate来进行选择。
//        //            在有序的Stream中，takeWhile返回从开头开始的尽量多的元素。
//        list.stream().takeWhile(x->x<5).forEach(System.out::println);
//        //dropWhile():dropWhile的行为与takeWhile相反，返回剩余的元素。
//        list.stream().dropWhile(x->x<5).forEach(System.out::println);

        //of()参数中的多个元素，可以包含null值
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, null);
        stream.forEach(System.out::println);
        //of()参数不能存储单个null。否则，抛异常NullPointerException
//        Stream<Object> stream1 = Stream.of(null);
//        stream1.forEach(System.out::println);
        Integer i=10;
        i=null;
        //ofNullable():形参变量是可以为null值的单个元素
        Stream<Object> stream1 = Stream.ofNullable(i);
        long count = stream1.count();
        System.out.println(count);
    }
    //java9新特性十一：Optional提供了新的方法stream()
    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");

        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
//        long count = stream.count();
//        System.out.println(count);//1
        stream.flatMap(x->x.stream()).forEach(System.out::println);
    }
}
