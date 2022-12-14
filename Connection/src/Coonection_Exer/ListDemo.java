package Coonection_Exer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:superherozhang
 * @create:2022-03-12 18:11
 */
public class ListDemo {
    /*
    * 区分List中的remove(int index)和remove(Object obj)
    * */
    @Test
    public void testListRemove(){
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//[1, 2]
    }
    private static void updateList(List list){
        list.remove(2);
//        list.remove(new Integer(2));//[1,3]
    }
}
