package Generic_Exer;

import java.util.List;

/**
 * @author:superherozhang
 * @create:2022-03-15 22:59
 */
/*
* 定义个泛型类DAO<T>，在其中定义一个Map成员变量，Map的键为 String类型，值为T类型。
* 分别创建以下方法:
public void save(String id,T entity):保存 T类型的对象到Map成员变量中。
public T get(String id):从map中获取id对应的对象|
public void update(String id,T entity): 替换map中key为id的内容，改为entity 对象
public List<T> list():返回map中存放的所有T对象|
public void delete(String id):删除指定id对象
*
定义一个User类:
该类包含: private 成员变量(int类型) id, age; (String 类型) name

定义一个测试类:。
创建DAO类的对象，分别调用其save、 get. update、list. delete方法来操作User 对象。
* */
public class GenericDemo1 {
    public static void main(String[] args) {
        DAO<User> dao=new DAO<User>();

        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆凌"));
        dao.save("1003",new User(1003,25,"蔡依林"));

        dao.update("1003",new User(1003,30,"方文山"));
        dao.delete("1002");

        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);

    }
}

