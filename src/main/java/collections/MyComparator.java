package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparator {


    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>();

        listOne.add("zaz");
        listOne.add("oxxxymiron");
        listOne.add("cock");
        listOne.add("anal");
        listOne.add("e");

        Collections.sort(listOne, new StringLengthComparator());
        System.out.println(listOne);


        List<Integer> listTwo = new ArrayList<>();

        listTwo.add(1);
        listTwo.add(2);
        listTwo.add(11023);
        listTwo.add(7);
        listTwo.add(11);

        //Можно не создавать отдельный класс и метод, а использовать анонимный класс
        Collections.sort(listTwo, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer t1) {
                if (i1 < t1) {
                    return 1;
                } else if (i1 > t1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(listTwo);

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Sasha"));
        users.add(new User(5, "Dmitry"));
        users.add(new User(3, "Sashok"));

        Collections.sort(users, new UserComparator());
        System.out.println(users);
    }
}

class StringLengthComparator implements Comparator<String> {

    /*
     * Конвенция метода compare:
     *
     * s > t1 return 1;
     * s < t1 return -1;
     * s == t1 return 0;
     *
     * */
    @Override
    public int compare(String s, String t1) {
        if (s.length() > t1.length()) {
            return 1;
        } else if (t1.length() > s.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}

class UserComparator implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        if (user.getId() > t1.getId()) {
            return 1;
        } else if (user.getId() < t1.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

}

