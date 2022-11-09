package Annotation_Code;


import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 *
 * @author:superherozhang
 * @create:2022-03-11 15:44
 */
/*
 * 注解的使用
 * 1.注解(Annotation)的理解:
 * ①jdk5.0新增的功能。
 * ②Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被获取，并执行相应的处理。
 *   通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。
 * ③Annotation可以像修饰符一样被使用，可用于修饰包、类、构造器、方法、成员变量、参数、局部变量的声明，
 *  这些信息被保存在Annotation的"name=value"对中。
 * ④在JavaSE中，注解使用的目的比较简单，例如标记过时的功能、忽略警告等。
 *   在JavaEE/Android中注解占据了更重要的角色，例如，用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置。
 *
 * 2.Annotation的使用示例:
 * 示例一:生成文档相关的注解
 *     @author标明开发该类模板的作者，多个作者之间使用，分割
 *     @version标明该类模块的版本
 *     @see参考转向，也就是相关主题
 *     @since从哪个版本开始增加的
 *     @param对方法中某参数的说明，如果没有参数就不能写
 *     @return对方法返回值的说明，如果方法的返回值类型是void就不能写。
 *     @exception对方法可能抛出的异常进行说明，如果方法没有用throws显式抛出的异常就不能写。
 * 示例二:在编译时进行格式检查(JDK内置的三个基本注解)
 *     @Override:限定重写父类方法，该注解只能用于方法。
 *     @Deprecated:用于表示所修饰的元素(类、方法等)已过时，通常是因为所修饰的结构危险或存在更好的选择
 *     @SuppressWarnings:抑制编译器警告
 * 示例三:跟踪代码依赖性，实现替换配置文件功能
 *
 * 3.如何自定义注解:参照 @SuppressWarnings去定义
 *   ① 注解声明为: @interface
 *   ② 内部定义成员，通常使用value表示
 *   ③可以指定成员的默认值，使用default定义
 *   ④如果自定义注解没有成员，表明是一个标识作用。
 *
 *   如果注解有成员，在使用注解时，需要指明成员的值。
 *   自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 *   自定义注解通常都会指明两个元注解:Retention、Target
 *
 * 4.jdk提供的4种元注解
 *    元注解:对原有注解进行解释说明的注解
 *    jdk5.0提供了4个标准的meta-annotation类型，分别是:
 *    >Retention: 指定所修饰的Annotation的生命周期: SOURCE\CLASS(默认行为)\RUNTIME
 *                   只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *    >Target: 用于指定被修饰的Annotation 能用于修饰哪些程序元素
 *   *****************出现频率较低****************
 *    >Documented: 表示所修饰的注解在被javadoc解析时，保留下来
 *    >Inherited: 被它修饰的Annotation将具有继承性。
 *
 * 5.通过反射获取注解信息  --->反射
 *
 * 6.jdk 8 中注解的新特性: 可重复注解、类型注解
 *
 * 6.1 可重复注解: ①在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *               ②MyAnnotation的Target和Retention等元注解和MyAnnotations相同
 * 6.2 类型注解:
 *       ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中(如: 泛型声明)
 *       ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 * */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p=new Student();
        p.walk();

        @Deprecated
        Date date = new Date(2022, 3, 11);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num=10;
//        System.out.println(num);
    }
    //通过反射获取注解信息
    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}

//jdk 8之前的写法
//@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value="hi")})
@MyAnnotation(value="hi")
@MyAnnotation(value="abc")
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}
interface Info{
    void show();
}
class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}
class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list=new ArrayList<>();

        int num=(@MyAnnotation int)10L;
    }
}

