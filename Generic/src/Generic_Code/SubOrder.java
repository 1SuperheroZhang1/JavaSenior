package Generic_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:superherozhang
 * @create:2022-03-15 19:58
 */
public class SubOrder extends Order<Integer>{   //SubOrder:不是泛型类
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list=new ArrayList<>();

        for(E e:arr){
            list.add(e);
        }
        return list;
    }

}
