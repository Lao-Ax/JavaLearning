package com.Alex.functional_interfaces.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class MapTest {

    public static void main(String[] args) {

        /**
         * Этот код в особых комментариях не нуждается: putIfAbsent позволяет нам не писать дополнительные проверки
         * на null; forEach принимает потребителя, который производит операцию над каждым элементом массива.
         */
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((key, val) -> System.out.println(val));

        /**
         * Этот код показывает как использовать для вычислений код при помощи различных функций:
         */
        map.computeIfPresent(3, (key, val) -> val + " :: " + key);
        map.get(3);             // val33

        map.computeIfPresent(9, (key, val) -> null);
        map.containsKey(9);     // false

        map.computeIfAbsent(23, key -> "val" + key);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, key -> "bam");
        map.get(3);             // val3 :: 3

        /**
         Как удалить объект по ключу, только если этот объект ассоциирован с ключом:
         */
        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val3 :: 3");
        map.get(3);             // null

        /**
         Еще один полезный метод:
         */
        map.getOrDefault(42, "not found");  // not found

        List<String> collection = Arrays.asList("a, b, c", "b", "c d", "d, o", "e, m, p");
        Object[] strings = collection.stream()
                .flatMap((p) -> Arrays.asList(p.split(",")).stream())
                .toArray();
        System.out.println();
    }
}
