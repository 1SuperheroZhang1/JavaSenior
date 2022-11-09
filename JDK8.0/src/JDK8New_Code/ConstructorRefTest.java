package JDK8New_Code;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *    >格式： 类名 :: new
 *      和方法引用类似，函数式接口的抽象方法的形参列表与构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属类的类型。
 *
 *  二、数组引用
 *    >格式： 数组名[] :: new
 *      可以把数组看作是一个特殊的类，则写法与构造器引用一致。
 *
 * @author:superherozhang
 * @create:2022-03-18 13:39
 */
public class ConstructorRefTest {
    //一、构造器引用
    //Supplier中的T get()
    //Employee的空参构造器: Employee()
    @Test
    public void test1(){
        Supplier<Employee> sup=new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        System.out.println("********************************");

        Supplier<Employee> sup1=() ->new Employee();
        System.out.println(sup1.get());

        System.out.println("********************************");

        Supplier<Employee> sup2=Employee::new;
        System.out.println(sup2.get());
    }
    //Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func=(id) -> new Employee(id);
        Employee employee = func.apply(1001);
        System.out.println(employee);

        System.out.println("********************************");

        Function<Integer,Employee> func1=Employee::new;
        Employee employee1 = func1.apply(1002);
        System.out.println(employee1);
    }
    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> func=(id,name) -> new Employee(id,name);
        System.out.println(func.apply(1001, "Tom"));

        System.out.println("********************************");

        BiFunction<Integer,String,Employee> func1=Employee::new;
        System.out.println(func1.apply(1002, "Jerry"));
    }
    //二、数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func=length ->new String[length];
        String[] arr = func.apply(5);
        System.out.println(Arrays.toString(arr));

        System.out.println("********************************");
        Function<Integer,String[]> func1=String[]::new;
        String[] arr1 = func1.apply(10);
        System.out.println(Arrays.toString(arr1));
    }
}
