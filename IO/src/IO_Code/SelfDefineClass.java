package IO_Code;

import java.io.Serializable;

/**
 * 自定义类实现序列化和反序列化的操作:
 * Person需要满足如下的要求: 方可实例化
 * 1.需要实现接口: Serializable - 表示接口
 * 2.当前类提供一个全局常量: serialVersionUID - 序列版本号
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的。(默认情况下，基本数据类型是可序列化的)
 * 4.对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，
 *   或通过网络将这种二进制流传输到另一个网络节点。当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
 * 补充:
 * ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 * @author:superherozhang
 * @create:2022-03-02 23:33
 */
public class SelfDefineClass {
    public static void main(String[] args) {

    }
}
class Person implements Serializable {
    public static final long serialVersionUID = 423214362112L;

    private String name;
    private int age;

    public Person(){

    }

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
