package collections;

import java.util.*;

public class MyComparable {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Set<Person> linkedSet = new LinkedHashSet<>();
        Set<Person> treeSet = new TreeSet<>();

        linkedSet.add(new Person(0, "Sasha"));
        linkedSet.add(new Person(5, "Dmitry"));
        linkedSet.add(new Person(2, "Masha"));
        linkedSet.add(new Person(1, "Dasha"));

        personList.add(new Person(1, "Sasha"));
        personList.add(new Person(2, "Dmitry"));
        personList.add(new Person(3, "Masha"));
        personList.add(new Person(5, "Dasha"));

        Collections.sort(personList);
        //Collections.sort(linkedSet);

        System.out.println(personList);
        System.out.println(linkedSet);
    }
}

class Person implements Comparable<Person>{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    @Override
    public int compareTo(Person person) {
        if (person.getId() < this.id){
            return 1;
        }else if (person.getId() > this.id){
            return -1;
        }else {
            return 0;
        }
    }
}
