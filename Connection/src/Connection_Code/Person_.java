package Connection_Code;

/**
 * @author:superherozhang
 * @create:2022-03-13 19:06
 */
public class Person_ {
    private int id;
    private String name;

    public Person_() {
    }

    public Person_(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person_ person_ = (Person_) o;

        if (id != person_.id) return false;
        return name != null ? name.equals(person_.name) : person_.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person_{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
