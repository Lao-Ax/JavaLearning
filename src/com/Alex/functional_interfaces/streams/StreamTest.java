package com.Alex.functional_interfaces.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Alex on 24.03.2017 024.
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        /**
         * Операция Filter принимает предикат, который фильтрует все элементы потока. Эта операция является
         * промежуточной, т.е. позволяет нам вызвать другую операцию (например, forEach) над результатом. ForEach
         * принимает функцию, которая вызывается для каждого элемента в (уже отфильтрованном) поток. ForEach является
         * конечной операцией. Она не возращает никакого значения, поэтому дальнейший вызов потоковых операций
         * невозможен.
         */
        stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();

        /**
         * Операция Sorted является промежуточной операцией, которая возвращает отсортированное представление потока.
         * Элементы сортируются в обычном порядке, если вы не предоставили свой компаратор.
         * Метод sorted создает всего лишь отсортированное представление и не влияет на порядок элементов в исходной
         * коллекции. Порядок строк в stringCollection остается нетронутым
         */

        stringCollection
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();

        /**
         * Промежуточная операция map преобразовывает каждый элемент в другой объект при помощи переданной функции.
         * Следующий пример преобразовывает каждую строку в строку в верхнем регистре. Однако вы так же можете
         * использовать map для преобразования каждого объекта в объект другого типа. Тип результирующего потока
         * зависит от типа функции, которую вы передаете при вызове map.
         */

        stringCollection
                .stream()
                .map(String::toUpperCase)
//                .map(s -> s.length() < 4 ? 1 : "com")
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
        System.out.println();

        /**
         * Для проверки, удовлетворяет ли поток заданному предикату, используются различные операции сопоставления
         * (match). Все операции сопоставления являются конечными и возвращают результат типа boolean.
         */
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true
        System.out.println();

        /**
         * Операция Count является конечной операцией и возвращает количество элементов в потоке. Типом возвращаемого
         * значения является long.
         */
        long startsWithB = stringCollection
                .stream()
                .filter(s -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);
        System.out.println();

//        List<String> list = stringCollection.stream().filter(s -> s.startsWith("b")).collect(Collectors.toList());

        /** REDUCE
         * Эта конечная операция производит свертку элементов потока по заданной функции. Результатом является
         * опциональное значение.
         */
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

    }
}
