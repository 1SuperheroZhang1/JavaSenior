package Connection_Code;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Set的两道面试题
 *
 * @author:superherozhang
 * @create:2022-03-13 19:00
 */
public class InterviewTest {
    /*
    * 面试题 1:在List内去除重复数字值，要求尽量简单
    * */
    public static List duplicateList(List list){
        HashSet set=new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));

        List list1=duplicateList(list);
        for(Object obj:list1){
            System.out.println(obj);
        }
    }
    /*
    * 面试题 2:
    * */
    @Test
    public void test2(){
        HashSet set=new HashSet();
        Person_ p1=new Person_(1001,"AA");
        Person_ p2=new Person_(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);//[Person_{id=1002, name='BB'}, Person_{id=1001, name='AA'}]

        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);//[Person_{id=1002, name='BB'}, Person_{id=1001, name='CC'}]

        set.add(new Person_(1001,"CC"));
        System.out.println(set);//[Person_{id=1002, name='BB'}, Person_{id=1001, name='CC'}, Person_{id=1001, name='CC'}]

        set.add(new Person_(1001,"AA"));
        System.out.println(set);
        //[Person_{id=1002, name='BB'}, Person_{id=1001, name='CC'}, Person_{id=1001, name='CC'}, Person_{id=1001, name='AA'}]

    }
}
