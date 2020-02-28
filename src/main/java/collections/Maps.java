package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        //Без сортировки
        Map<Integer, String> map = new HashMap<Integer, String>();

        //Значения отсортированы
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

        //Значения отсортированы по ключу
        Map<Integer, String> treeMap = new TreeMap<Integer, String>();

        testMaps(treeMap);
    }

    private static void testMaps(Map<Integer, String> map) {
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        map.put(3, "three replace");
        map.put(4, "four");
        map.put(50, "fifteens");
        map.put(14, "fourteen");
        map.put(23, "twenty three");
        map.put(448, "four hundred fourteen eight");

        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry);
        }
    }
}
