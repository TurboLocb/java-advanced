package collections;

import java.util.*;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        Map<User, String> hashMap = new HashMap<>();
        Set<User> hashSet = new HashSet<>();

        User user1 = new User(1, "Masha");
        User user2 = new User(1, "Masha");

        hashMap.put(user1, "one");
        hashMap.put(user2, "two");

        hashSet.add(user1);
        hashSet.add(user2);

        System.out.println(hashMap);
        System.out.println(hashSet);
    }

    static class User{
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        /*
        * В ходе проверки мы выполняем метод hashCode()
        * 1) если хеши разные, то два проверяемых объекта точно разные
        *
        * 2) если хеши одинаковые, то либо объекты одинаковые, либо случилась коллизия, то вызывается метод equals()
        * */
    }
}
