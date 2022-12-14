package JDK8New_Code;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情境：当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用，本质就是lambda表达式，而lambda表达式作为函数式接口的实例，所以方法引用，也是函数式接口的实例。
 *
 * 3.使用格式：  类(或对象) :: 方法名
 *
 * 4.具体分为如下三种情况：
 *      情况1     对象 :: 非静态方法
 *      情况2     类 :: 静态方法
 *
 *      情况3     类 :: 非静态方法
 *
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！(针对于情况1和情况2)
 * @author:superherozhang
 * @create:2022-03-18 12:36
 */
public class MethodRefTest {
    //情况一： 对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1=s-> System.out.println(s);
        con1.accept("北京");

        System.out.println("******************************************");

        PrintStream ps=System.out;
        Consumer<String> con2= ps::println;
        con2.accept("beijing");
    }
    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2(){
        Employee emp=new Employee(1001,"Tom",23,5000);

        Supplier<String> sup=() -> emp.getName();
        System.out.println(sup.get());

        System.out.println("************************************");

        Supplier<String> sup1=emp::getName;
        System.out.println(sup1.get());
    }
    //情况二： 类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3(){
        Comparator<Integer> com=(t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com.compare(12,21));

        System.out.println("************************************");

        Comparator<Integer> com1=Integer::compare;
        System.out.println(com1.compare(12,3));

    }
    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4(){
        Function<Double,Long> func=new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        System.out.println("************************************");
        Function<Double,Long> func1=d->Math.round(d);
        System.out.println(func1.apply(12.3));

        System.out.println("************************************");
        Function<Double,Long> func2=Math::round;
        System.out.println(func2.apply(12.6));
    }
    //情况三： 类 :: 实例方法
    //Comparator中的 int compare(T t1,T t2)
    //String中的int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> com=(t1,t2) -> t1.compareTo(t2);
        System.out.println(com.compare("abc", "abd"));

        System.out.println("************************************");

        Comparator<String> com1=String::compareTo;
        System.out.println(com1.compare("abd", "abm"));
    }
    //BiPredicate中的boolean test(T t1,T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String,String> pre=(s1,s2) -> s1.equals(s2);
        System.out.println(pre.test("abc", "abc"));

        System.out.println("************************************");

        BiPredicate<String,String> pre1=String::equals;
        System.out.println(pre1.test("abc", "abd"));
    }
    //Function中的R apply(T t)
    //Employee中的String getName()
    @Test
    public void test7(){
        Employee emp=new Employee(1001,"Jerry",23,5000);
        Function<Employee,String> func=e -> e.getName();
        System.out.println(func.apply(emp));

        System.out.println("************************************");

        Function<Employee,String> func1=Employee::getName;
        System.out.println(func1.apply(emp));
    }
}
