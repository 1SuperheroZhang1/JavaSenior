package Generic_Exer;

import java.util.*;

/**
 * 定义个泛型类DAO<T>，在其中定义一个Map成员变量，Map的键为 String类型，值为T类型。
 * * 分别创建以下方法:
 * public void save(String id,T entity):保存 T类型的对象到Map成员变量中。
 * public T get(String id):从map中获取id对应的对象|
 * public void update(String id,T entity): 替换map中key为id的内容，改为entity 对象
 * public List<T> list():返回map中存放的所有T对象|
 * public void delete(String id):删除指定id对象
 * @author:superherozhang
 * @create:2022-03-15 23:04
 */
class DAO<T>{
    private Map<String,T> map=new HashMap<>();

    //保存 T类型的对象到Map成员变量中。
    public void save(String id,T entity){
        map.put(id,entity);
    }
    //从map中获取id对应的对象
    public T get(String id){
        T t = map.get(id);
        return t;
    }
    //替换map中key为id的内容，改为entity 对象
    public void update(String id,T entity)
    {
        if(map.containsKey(id)){
            map.put(id,entity);
        }
    }
    //返回map中存放的所有T对象
    public List<T> list(){
//        Set<Map.Entry<String, T>> entries = map.entrySet();
//        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, T> entry = iterator.next();
//            String key = entry.getKey();
//            T value = entry.getValue();
//
//        }
        ArrayList<T> list=new ArrayList<>();
        Collection<T> values = map.values();
        for(T t:values){
            list.add(t);
        }
        return list;
    }
    //删除指定id 对象
    public void delete(String id){
//        T t = map.get(id);
//        map.remove(id,t);
        map.remove(id);
    }

}
