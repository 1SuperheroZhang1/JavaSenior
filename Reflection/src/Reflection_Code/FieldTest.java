package Reflection_Code;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性
 * @author:superherozhang
 * @create:2022-03-17 16:31
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person_> clazz = Person_.class;
        //获取属性结构
        //getFields():获取当前运行时类及其所有父类中的声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println("******************************");
        //getDeclaredFields():获取当前运行时类中声明的所有属性(不包含父类中声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f);
        }
    }
    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<Person_> clazz = Person_.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        for(Field f:declaredFields){
            //1.权限修饰符
            int modifiers = f.getModifiers();
//            System.out.println(modifiers);
            System.out.print(Modifier.toString(modifiers)+'\t');

            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName()+'\t');
            //3.变量名
            String fName = f.getName();
            System.out.print(fName);

            System.out.println();
        }
    }
}
