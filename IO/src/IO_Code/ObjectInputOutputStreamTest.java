package IO_Code;

/**
 * 处理流之六: 对象流
 * 1.对象流
 * ObjectInputStream
 * ObjectOutputStream
 * 2.作用:
 *     用于存储和读取基本数据类型数据或对象的处理流。
 *     它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原出来。
 *   >序列化: 用ObjectOutputStream类保存基本数据类型数据或对象的机制
 *   >反序列化:用ObjectInputStream类读取基本数据类型或对象的机制
 *   >ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 * 3.要想一个Java对象是可序列化的，需要满足相应的要求。
 * 4.对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，
 *   或通过网络将这种二进制流传输到另一个网络节点。当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
 *
 * @author:superherozhang
 * @create:2022-03-02 23:09
 */
public class ObjectInputOutputStreamTest {
    public static void main(String[] args) {
        System.out.println("1");
    }
}