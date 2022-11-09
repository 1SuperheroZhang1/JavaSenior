package Reflection_Code;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类的指定结构：属性、方法、构造器
 *
 * @author:superherozhang
 * @create:2022-03-17 18:28
 */
public class Class_FieldMethodConstructorTest {
    @Test
    public void testField() throws Exception{
        Class<Person_> clazz = Person_.class;

        //创建运行时类的对象
        Person_ p=clazz.newInstance();

        /*
        * getField():获取指定的属性,要求运行时类中的属性声明为public,通常不采用此方法
        * */
        Field id = clazz.getField("id");

        /*
        * set(Object obj,Object value): obj：指明需要设置属性值的对象  value:将此属性值设置为多少
        * */
        id.set(p,1001);
        /*
        * get(Object obj): obj:表示获取属性值的对象
        * */
        int pid= (int) id.get(p);
        System.out.println(pid);

    }

    /*
    * 如何操作运行时类中指定的属性？
    * */
    @Test
    public void testField1() throws Exception {
        Class<Person_> clazz = Person_.class;

        //创建运行时类的对象
        Person_ p = clazz.newInstance();

        //1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取、设置指定对象的此属性值
        name.set(p, "Jerry");

        System.out.println(name.get(p));
    }

    @Test
    public void testMethod() throws Exception {
        Class<Person_> clazz = Person_.class;

        //创建运行时类的对象
        Person_ p = clazz.newInstance();

        /*1.获取指定的某个方法
        * getDeclaredMethod(String name, Class<?>... parameterTypes)
        * name:指明要获取方法的方法名
        * parameterTypes:指明获取方法的形参列表
        * */
        Method show = clazz.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可访问的
        show.setAccessible(true);
        /*
        * invoke(Object obj, Object... args)
        * obj:方法的调用者
        * args:给方法形参赋值的实参
        * invoke()方法的返回值即为对应类中调用的方法的返回值。
        * */
        //3.调用invoke()方法
        Object returnValue = show.invoke(p, "CHN");//String nation=p.show("CHN");
        System.out.println(returnValue);

        System.out.println("***************如何调用静态方法*************");
        //private void showDesc(){}

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()方法返回null
        Object returnVal = showDesc.invoke(Person_.class);
//        Object returnVal = showDesc.invoke(null);
        System.out.println(returnVal);//null
    }

    /*
    * 如何调用运行时类的中指定的构造器
    * */
    @Test
    public void testConstructor() throws Exception {
        Class<Person_> clazz = Person_.class;

        //private Person_(String name)
        /*1.获取指定的构造器
        * getDeclaredConstructor(Class<?>... parameterTypes)
        * Class<?>... parameterTypes:指明构造器的参数列表
        * */
        Constructor<Person_> declaredConstructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        declaredConstructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person_ p = declaredConstructor.newInstance("Tom");
        System.out.println(p);


    }
}
