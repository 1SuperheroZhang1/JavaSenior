package Connection_Code;

/**
 * @author:superherozhang
 * @create:2022-03-12 14:05
 */
public class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小排序,年龄按从小到大的顺序排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p=(Person) o;
//            return -this.name.compareTo(p.name);
            int compare=-this.name.compareTo(p.name);
            if(compare!=0){
                return compare;
            }else{
                return Integer.compare(this.age,p.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配！");
        }
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
}
