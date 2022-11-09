package JDK8New_Code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 *
 * 1.消费型接口 Consumer<T>   void accept(T t)
 *
 * 2.供给型接口 Supplier<T>   T get()
 *
 * 3.函数型接口 Function<T,R>  R apply(T t)
 *
 * 4.断定型接口 Predicate<T>  boolean test(T t)
 *
 * @author:superherozhang
 * @create:2022-03-18 10:06
 */
public class FunctionalInterfaceTest {
    @Test
    public void testConsumer(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买一瓶矿泉水，价格为:"+aDouble);
            }
        });

        System.out.println("***********************************");
        happyTime(400, money -> System.out.println("学习太累了，去天上人间喝了口水，价格为:"+money)
        );
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }
    @Test
    public void testPredicate(){
        List<String> list= Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> filterString= filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterString);

        System.out.println("*****************************");

        List<String> filterString1=filterString(list,s ->s.contains("京"));

        System.out.println(filterString1);

    }
    //根据给定规则，过滤集合中的字符串。此规则由predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList=new ArrayList<>();

        for(String s:list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
