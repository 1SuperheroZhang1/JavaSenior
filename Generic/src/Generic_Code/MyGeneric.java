package Generic_Code;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法
 *
 * 1.关于自定义泛型类、泛型接口：
 *
 * @author:superherozhang
 * @create:2022-03-15 19:46
 */
public class MyGeneric {
    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则默认此泛型类型为Object类型
        //要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order=new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议：实例化时指明类的泛型
        Order<String> order1=new Order<String>("orderAA",1001,"order:AA");

        order1.setOrderT("AA:hello");
    }
    @Test
    public void test2(){
        SubOrder sub1=new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型类型。

        sub1.setOrderT(1123);

        SubOrder_<String> sub2=new SubOrder_<>();
        sub2.setOrderT("order2...");
    }
    @Test
    public void test3(){
        ArrayList<String> list=null;
        ArrayList<Integer> list1=null;
        //泛型不同的引用不能相互赋值。
//        list=list1;

        Order o1=null;
        Order o2=null;
        o1=o2;

    }
}
