package JDK8New_Code;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的。
 *
 * 常用方法： ofNullable(T t)
 *          orElse(T t)
 * Optional类的使用
 * Optional<T>类(java.util.Optional)是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null，表示这个值不存在。
 * 原来用null表示一个值不存在，现在Optional可以更好地表达这个概念。并且可以避免空指针异常。
 * ●Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 * ●创建Optional类对象的方法:
     * ➢Optional.of(T t):创建一个Optional实例，t必须非空;否则，抛异常NullPointerException
     * ➢Optional.empty() :创建一个空的Optional实例
     * ➢Optional.ofNullable(T t):t可以为null
 * ●判断Optional容器中是否包含对象:
     * ➢boolean isPresent() :判断是否包含对象
     * ➢void ifPresent(Consumer<? super T> consumer): 如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
 * ●获取Optional容 器的对象:
     * ➢T get():如果调用对象包含值，返回该值，否则拋异常。通常与of()搭配使用。用于获取Optional内部封装的数据
     * ➢T orElse(T other) :如果有值则将其返回，否则返回指定的other对象。通常与Nullable()搭配使用。
     * ➢T orElseGet(Supplier<? extends T> other):如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
     * ➢T orElse Throw(Supplier<? extends X> exceptionSupplier) :如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。
 * @author:superherozhang
 * @create:2022-03-19 12:49
 */
public class OptionalTest {
    /*
     * ●创建Optional类对象的方法:
     * ➢Optional.of(T t):创建-个Optional实例，t必须非空;
     * ➢Optional.empty() :创建一个空的Optional实例
     * ➢Optional.ofNullable(T t):t可以为null
     * */
    @Test
    public void test1(){
//        Girl girl = new Girl();
////        girl=null;//NullPointerException
//        //of(T t):保证t不能为null
//        Optional<Girl> optionalGirl = Optional.of(girl);

        Girl girl1 = new Girl();
        girl1=null;
        //ofNullable(T t):t可以为null
        Optional<Girl> optionalGirl1 = Optional.ofNullable(girl1);
        System.out.println(optionalGirl1);

        //orElse(T t):如果当前的Optional内部封装的t是非空的，则返回内部的t。
        //            如果内部的t是空的，则返回orElse(t1)方法中的t1
        Girl girl = optionalGirl1.orElse(new Girl("赵丽颖"));
        System.out.println(girl);

    }

//    public String getGirlName(Boy boy){
//        return boy.getGirl().getName();
//    }
    @Test
    public void test2(){
        Boy boy=new Boy();
        boy=null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }
    //优化以后的getGirlName
//    public String getGirlName(Boy boy){
//       if(boy!=null){
//           Girl girl = boy.getGirl();
//           if(girl!=null){
//               return girl.getName();
//           }
//       }
//       return null;
//    }
    //使用Optional以后的getGirlName
    public String getGirlName(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        //此时的boy1一定非空
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        //此时的girl1一定非空
        Girl girl1 = optionalGirl.orElse(new Girl("古力娜扎"));
        return girl1.getName();
    }
    @Test
    public void test3(){
        Boy boy=null;
        boy=new Boy();
        boy=new Boy(new Girl("苍老师"));
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }
}
