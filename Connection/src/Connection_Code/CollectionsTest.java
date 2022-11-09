package Connection_Code;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collection、Map的工具类
 *
 * 面试题：Collection和Collections的异同？
 * @author:superherozhang
 * @create:2022-03-15 9:14
 */
/*
* 排序操作：(均为static方法)
*   >reverse(List): 反转List中元素的顺序
*   >shuttle(List):对List集合元素进行随机排序
*   >sort(List):根据元素的自然排序对指定List集合元素按升序排序
*   >sort(List,Comparator):根据指定的Comparator产生的顺序对List集合元素排序
*   > swap(List,int,int):将指定list集合中的i处元素和j处元素进行交换
* 查找、替换
*   >Object max(Collection):根据元素的自然排序，返回给定集合中的最大元素
*   >Object max(Collection,Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
*   >Object min(Collection):根据元素的自然排序，返回给定集合中的最小元素
*   >Object min(Collection,Comparator):根据Comparator指定的顺序，返回给定集合中的最小元素
*   >int frequency(Collection,Object):返回指定集合中指定元素的出现次数
*   >void copy(List des,List src):将src中的内容复制到dest中
*   >boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List对象中的所有旧值
*
* */
public class CollectionsTest {
    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        System.out.println(list);

        int frequency = Collections.frequency(list, 765);
        System.out.println(frequency);
    }
    /*
    * void copy(List des,List src):将src中的内容复制到dest中
    * */
    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //错误的，报异常：java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        List dest=new ArrayList();
//        Collections.copy(dest,list);
        //正确的
        List dest= Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//list.size()
        Collections.copy(dest,list);
        System.out.println(dest);

        /*
        * Collections类提供了多个synchronizedXxx()的方法，
        * 该方法可使指定集合包装成线程安全的集合，从而可以解决多线程并发访问集合时的线程安全问题。
        * */
        List list1 = Collections.synchronizedList(list);//返回的list1即为线程安全的list
    }
}
