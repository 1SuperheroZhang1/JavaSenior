package JDK8New_Code;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 一、Stream和Collection集合的区别
 *  Stream关注的是对数据的运算，面向CPU,通过CPU实现计算。(Stream是有关计算的)
 *  Collection关注的是数据的存储，面向内存，存储在内存中。(Collection是一种静态的内存数据结构)
 *
 *  二、Stream的概念
 *  Stream是数据渠道，用于操作数据源(集合、数组等)所生成的元素序列。
 *  注意：
 *      >①Stream不会自己存储元素。
 *      >②Stream不会改变源对象，相反，他们会返回一个持有结果的新Stream。
 *      >③Stream操作是延迟执行的。这意味着他们会等到需要结果时才执行。
 *
 *  三、Stream的执行流程
 *  ①Stream的实例化
 *  ②一系列的中间操作(过滤、映射)
 *  ③终止操作
 *
 *  四、说明
 *  ① 一个中间操作链，对数据源的数据进行处理。
 *  ② 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用。
 *
 *  测试Stream的实例化
 * @author:superherozhang
 * @create:2022-03-18 14:17
 */
public class StreamAPITest {
    //创建Stream的方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employee = EmployeeData.getEmployee();

        //default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employee.stream();

        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> parallelStream = employee.parallelStream();
    }
    //创建Stream方式二：通过数组
    @Test
    public void test2(){
        int arr[]=new int[]{1,2,3,4,5,6};
        //通过调用Arrays类的static <T> Stream<T> stream(T[] arrays):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1=new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);

    }
    //创建Stream的方式三：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }
    //创建Stream的方式四：创建无限流
    @Test
    public void test4(){

        //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0,t ->t+2).limit(10).forEach(System.out::println);
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
