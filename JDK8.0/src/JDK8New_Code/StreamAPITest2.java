package JDK8New_Code;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 * @author:superherozhang
 * @create:2022-03-19 11:56
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test1(){
        //1.allMatch(Predicate p):检查是否匹配所有元素
            //练习1：是否所有员工的年龄都大于18岁
        List<Employee> list = EmployeeData.getEmployee();
        boolean allMatch = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        //2.anyMatch(Predicate p):检查是否至少匹配一个元素
            //练习2：是否存在员工的工资大于10000
        boolean anyMatch = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        //3.noneMatch(Predicate p):检查是否没有匹配所有元素
            //练习3：是否存在员工姓"雷"
        boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);
        //4.findFirst():返回第一个元素
        Optional<Employee> employee = list.stream().findFirst();
        System.out.println(employee);
        //5.findAny():返回当前流中的任意元素
        Optional<Employee> employee1 = list.parallelStream().findAny();
        System.out.println(employee1);
        //6.count():返回流中元素总数
        long count = list.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        //7.max(Comparator c):返回流中最大值
            //练习：返回最高的工资
        Stream<Double> salaryStream = list.stream().map(e -> e.getSalary());
        Optional<Double> max = salaryStream.max(Double::compare);
        System.out.println(max);
        //8.min(Comparator c):返回流中最小值
            //练习：返回最低工资的员工姓名
        Optional<Employee> min = list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        //9.forEach(Consumer c):内部迭代(使用Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代)
        list.stream().forEach(System.out::println);

        //使用集合的遍历操作
        list.forEach(System.out::println);
    }
    //2-归约
    /*
    * 备注：map和reduce的连接通常称为map-reduce模式，因Google用它来进行网络搜索而出名
    * */
    @Test
    public void test2(){
        //reduce(T identity,BinaryOperator b):可以将流中元素反复结合起来，得到一个值。返回T
            //练习1：计算1-10的自然数的和
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        //reduce(BinaryOperator b):可以将流中集合反复结合起来，得到一个值。返回Optional<T>
            //练习2：计算公司中所有员工的工资总和
        List<Employee> employee = EmployeeData.getEmployee();
        Stream<Double> salaryStream = employee.stream().map(Employee::getSalary);
//        Optional<Double> salarySum = salaryStream.reduce(Double::sum);
        Optional<Double> salarySum = salaryStream.reduce((d1,d2)->d1+d2);
        System.out.println(salarySum.get());

    }
    //3-收集
    @Test
    public void test3(){
        //collect(Collector c):将流转换为其他形式。接受一个Collector接口的实现，用于给Stream中的元素做汇总的方法。
        //Collector接口中方法的实现决定了如何对流执行收集的操作(如收集到List、Set、Map)
            //练习1：查找工资大于6000的员工，结果返回一个List或Set
        List<Employee> employee = EmployeeData.getEmployee();
        Stream<Employee> employeeStream = employee.stream().filter(e -> e.getSalary() > 6000);
        List<Employee> list = employeeStream.collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println();
        Stream<Employee> employeeStream1 = employee.stream().filter(e -> e.getSalary() > 6000);
        Set<Employee> set = employeeStream1.collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}
