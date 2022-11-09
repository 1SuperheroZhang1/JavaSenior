package Reflection_Code;

/**
 * @author:superherozhang
 * @create:2022-03-17 16:21
 */
@MyAnnotation(value = "hi")
public class Person_ extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    protected String num;
    public int id;

    public Person_() {
    }
    @MyAnnotation(value = "abc")
    private Person_(String name) {
        this.name = name;
    }

    Person_(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是:"+nation);
        return nation;
    }
    public String display(String interests) throws NullPointerException,ClassCastException{
        return interests;
    }


    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }

    @Override
    public String toString() {
        return "Person_{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num='" + num + '\'' +
                ", id=" + id +
                '}';
    }
}
