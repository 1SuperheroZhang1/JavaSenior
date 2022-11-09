package Connection_Code;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author:superherozhang
 * @create:2022-03-13 18:09
 */
public class TreeSetTest {

    /*
    * 1.向TreeSet中添加的数据，要求是相同类的对象。
    * 2.两种排序方式: 自然排序(实现Comparable接口) 和 定制排序(Comparator)
    *
    * 3.自然排序中，比较两个对象是否相同的标准为: compareTo()返回0，不再是equals()
    * 4.定制排序中，比较两个对象是否相等的标准为: compare()返回0，不再是equals()
    * */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //不能添加不同类的对象: 错误的ClassCastException
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tom",12));

        //举例一:
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二:
        set.add(new Person("Tom",12));
        set.add(new Person("Jack",34));
        set.add(new Person("Mike",3));
        set.add(new Person("Jerry",65));
        set.add(new Person("Jim",20));
        set.add(new Person("Jim",50));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        Comparator com=new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Person&&o2 instanceof  Person){
                    Person p1= (Person) o1;
                    Person p2= (Person) o2;

                    return Integer.compare(p1.getAge(),p2.getAge());
                }else{
                    throw new RuntimeException("输入类型不匹配！");
                }
            }
        };

        TreeSet set=new TreeSet(com);
        set.add(new Person("Tom",12));
        set.add(new Person("Jack",34));
        set.add(new Person("Mike",3));
        set.add(new Person("Jerry",65));
        set.add(new Person("Jim",20));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
