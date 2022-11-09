package JDK8New_Code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 * @author:superherozhang
 * @create:2022-03-19 10:47
 */
public class StreamAPITest1 {
    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployee();
        //filter(Predicate p)——接收Lambda，从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000的员工信息。
        stream.filter(e -> e.getSalary()>7000).forEach(System.out::println);

        System.out.println();
        //limit(n)——截断流，使其元素不超过给定数据
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //skip(n)——跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
        list.stream().skip(3).forEach(System.out::println);
        //distinct()——筛选，通过流所生成的元素的hashCode()和equals()去除重复元素
        System.out.println();

        list.add(new Employee(1009,"刘强东",40,7000));
        list.add(new Employee(1009,"刘强东",40,7000));
        list.add(new Employee(1009,"刘强东",40,7000));
        list.add(new Employee(1009,"刘强东",40,7000));
        list.add(new Employee(1009,"刘强东",40,7000));

        list.stream().distinct().forEach(System.out::println);
    }
    //2-映射
    @Test
    public void test2(){

//map(Function f)——接受一个函数作为参数，将元素转换成其他形式或提取信息，该函数就会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(s-> s.toUpperCase()).forEach(System.out::println);

        //练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> list1 = EmployeeData.getEmployee();
        Stream<String> namesStream = list1.stream().map(Employee::getName);
        namesStream.filter(name->name.length()>3).forEach(System.out::println);
        System.out.println();

        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s->{
            s.forEach(System.out::println);
        });

        System.out.println();
//flatMap(Function f)——接受一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有的流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list=new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }

        return list.stream();

    }
    @Test
    public void test3(){
        ArrayList list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList list1=new ArrayList();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        //add():将列表list1看成一个整体，加入到list中
//        list.add(list1);//[1, 2, 3, [4, 5, 6]]
        //addAll():将列表list1中的各个元素取出来，然后逐个加入到list中
        list.addAll(list1);//[1, 2, 3, 4, 5, 6]
        System.out.println(list);
    }
    //3-排序
    @Test
    public void test4(){
        //sorted()——自然排序。产生一个新流，其中按自然顺序排序。
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98,7);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因：Employee类没有实现Comparable接口。
//        List<Employee> employee = EmployeeData.getEmployee();
//        employee.stream().sorted().forEach(System.out::println);
        //sorted(Comparator com)——定制排序。产生一个新流，其中按比较器顺序排序。
        List<Employee> employee = EmployeeData.getEmployee();
        employee.stream().sorted((e1,e2)->{
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if(ageValue!=0){
                return ageValue;
            }else{
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
