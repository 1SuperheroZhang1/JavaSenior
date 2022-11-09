package JDK9_10_11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:superherozhang
 * @create:2022-03-19 21:49
 */
public class Java10Test {
    /*
    * Java10的新特性一：局部变量的类型推断：
    * 工作原理：在处理var时，编译器显示查看表达式右边部分，并根据右边变量值的类型进行推断，
    *         作为左边变量的类型，然后将该类型写入字节码文件当中。
    * 注意： >var不是关键字
    *       >这不是Javascript
    * 1.局部变量不赋值，就不能实现类型推断
    * 2.lambda表达式中，左边的函数式接口不能声明为var
    * 3.方法引用中，左边的函数式接口不能声明为var
    * 4.数组的静态初始化中，以下情况不可以 var arr={1,2,3,4};
    * 5.构造器的参数类型不能声明为var
    * 6.方法的返回类型不能声明为var
    * 7.方法的参数类型也不能声明为var
    * 8.属性也不可以声明为var
    * 9.catch块中的异常类型也不能声明为var
    * */
    @Test
    public void test1(){
        //1.声明变量时，根据所赋的值，推断变量的类型
        var num=10;

        var list = new ArrayList<Integer>();
        list.add(123);

        //2.遍历操作
        for(var i:list){
            System.out.println(i);
            System.out.println(i.getClass());
        }

        //3.普通的遍历操作
        for (var i = 0; i <100 ; i++) {
            System.out.println(i);
        }
    }
    /*
    * Java10的新特性二：集合中新增的copyOf(),用于创建一个只读的集合
    * */
    @Test
    public void test2(){
        //示例1：
        var list=List.of("Java","Python","C");
        var copy=List.copyOf(list);
        System.out.println(list == copy);//true

        //示例2：
        var list1=new ArrayList<String>();
        var copy1=List.copyOf(list1);
        System.out.println(list1 == copy1);//false

        //copyOf(Xxx coll):如果参数coll本身就是一个只读集合，则copyOf()的返回值是当前coll
        //                 如果参数coll不是一个只读集合，则copyOf()返回一个新的集合，这个集合是只读的。
    }
}
