package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        Set<Object> hashSet = new HashSet<Object>();

        Set<Object> hashSet2= new HashSet<Object>();

        Set<Object> linkedSet = new LinkedHashSet<Object>();
        Set<Object> treeSet = new TreeSet<Object>();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);

        hashSet2.add(4);
        hashSet2.add(5);
        hashSet2.add(6);
        hashSet2.add(7);
        hashSet2.add(8);

        printSet(hashSet);

        //Объединение множеств
        Set<Object> setUnion = new HashSet<Object>(hashSet);
        setUnion.addAll(hashSet2);
        printSet(setUnion);

        //Пересечение множеств
        Set<Object> setIntersect = new HashSet<Object>(hashSet);
        setIntersect.retainAll(hashSet2);
        printSet(setIntersect);

        //Разница множеств
        Set<Object> setDifference = new HashSet<Object>(hashSet);
        setDifference.removeAll(hashSet2);
        printSet(setDifference);
    }
    
    private static void printSet(Set<Object> set){

        for (Object s: set) {
            System.out.println(s);
        }
        
        System.out.println(set.contains("Alexander")); //Наличие объекта в Set
        System.out.println(set.contains("Dmitry"));

        System.out.println(set.isEmpty()); //Пустой ли Set

    }
}
