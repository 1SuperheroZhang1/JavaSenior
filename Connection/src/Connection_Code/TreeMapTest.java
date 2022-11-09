package Connection_Code;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author:superherozhang
 * @create:2022-03-14 23:57
 */
public class TreeMapTest {
    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序

    //自然排序
    @Test
    public void test1() {
        TreeMap map=new TreeMap();
        map.put(new Person("Tom",12),98);
        map.put(new Person("Jack",34),76);
        map.put(new Person("Mike",3),88);
        map.put(new Person("Jerry",65),100);

        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object o = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry= (Map.Entry) o;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }
    //定制排序
    @Test
    public void test2() {
        TreeMap map=new TreeMap(new Comparator() {
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
        });
        map.put(new Person("Tom",12),98);
        map.put(new Person("Jack",34),76);
        map.put(new Person("Mike",3),88);
        map.put(new Person("Jerry",65),100);

        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object o = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry= (Map.Entry) o;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }
}

