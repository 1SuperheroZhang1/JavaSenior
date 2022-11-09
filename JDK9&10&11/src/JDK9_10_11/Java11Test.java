package JDK9_10_11;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author:superherozhang
 * @create:2022-03-19 22:24
 */
public class Java11Test {
    /*Java11新特性一：新增了一系列字符串的处理方法
    *     描述                        举例
    判断字符串是否为空白          " ".isBlank(); // true
    去除首尾空白                " Javastack ".strip(); // "Javastack"
    去除尾部空格                ” Javastack " .stripTrailing(); //”Javastack"
    去除首部空格                " Javastack ". stripleading(); // "Javastack
    复制字符串                   "Java" . repeat(3);// "JavaJavalava"
    行数统计                    "A\nB\nC". lines(). count(); // 3
    * */
    @Test
    public void test1(){
        String str=" ";
        boolean blank = str.isBlank();
        System.out.println(blank);//true

        str=" \t abc \t  \n";
        //strip():去除首尾空白
        System.out.println("----------"+str.strip()+"----------");
        System.out.println("----------"+str.trim()+"----------");

        //stripTrailing():去除尾部空格
        System.out.println("----------"+str.stripTrailing()+"----------");
        //stripLeading():去除首部空格
        System.out.println("----------"+str.stripLeading()+"----------");

        str="abc";
        //repeat():复制字符串
        System.out.println(str.repeat(5));
        //lines().count():行数统计
        System.out.println(str.lines().count());
    }
    //Java11新特性二:Optional新增的方法
    @Test
    public void test2(){

        Optional<Object> op = Optional.empty();
        //isEmpty():判断内部的value是否为空
        System.out.println(op.isEmpty());//true
        //isPresent():判断内部的value是否存在
        System.out.println(op.isPresent());//false

        op=Optional.of("abc");
        //orElseThrow():value非空，返回value；否则报异常NoSuchElementException
        var obj = op.orElseThrow();
        System.out.println(obj);

        //or():value非空，返回对应的Optional；value为空，返回形参封装的Optional
        Optional<String> op1 = Optional.of("hello");
        Optional<Object> op2 = op.or(() -> op1);//abc
    }
    //Java11新特性三：局部变量类型推断的升级
    //在var上添加注解的语法格式，在jdk10中是不能实现的。在JDK11中加入了这样的语法。
    @Test
    public void test3(){
        //错误的形式:必须要有类型，可以加上var
//        Consumer<String> con1 = (@Deprecated t) ->
//        System.out.println(t.toUpperCase());
        //正确的形式:
        //使用var的好处是在使用lambda表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var t) ->
                System.out.println(t.toUpperCase());
    }
    //Java11新特性四：HttpClient替换原有的HttpURLConnection。
    //Java11新特性五：更简化的编译运行程序。原：javac xxx.java -> java xxx 现：java xxx.java
    //Java11新特性六：废弃Nashorn引擎
    /*Java11新特性七：ZGC    Java的两大利器：JVM、GC
    * ●优势:
    ➢GC暂停时间不会超过10ms
    ➢既能处理儿百兆的小堆,也能处理几个T的大堆(OMG)
    ➢和G1相比,应用吞吐能力不会下降超过15%
    ➢为未来的GC功能和利用colord指针以及Load barriers优化奠定基础
    ➢初始只支持64位系统
    ●ZGC的设计目标是:支持TB级内存容量，暂停时间低(<10ms) ，对整个程序吞吐量的影响小于15%。
    *              将来还可以扩展实现机制，以支持不少令人兴奋的功能，
    *              例如多层堆(即热对象置于DRAM和冷对象置于NVMe闪存),或压缩堆。
    * */
    /*
    * 在当前JDK中看不到什么？
    *   >一个标准化和轻量级的JSON API
    *   >新的货币API
    * */

}
