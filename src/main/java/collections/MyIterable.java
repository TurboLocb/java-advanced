package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyIterable {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //Старый способ итерирования по коллекции
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Начиная с Java 5
        for (int x : list) {
            System.out.println(x);
        }
    }
}
