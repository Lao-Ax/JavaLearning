package com.Alex.functional_interfaces.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class MapToIntTest {

    public static void main(String[] args) {
        List<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        System.out.println(peoples.stream()
                .filter((p) -> p.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble()
        );

        System.out.println(peoples.stream()
                .filter((p) -> p.getAge() >= 18)
                .filter((p) ->
                        (p.getSex() == Sex.WOMEN && p.getAge() < 55)
                                || (p.getSex() == Sex.MAN && p.getAge() < 60))
                .count()
        );

        System.out.println(peoples.stream()
                .map(People::getAge)
                .reduce(0, // identity: The identity element is both the initial value of the reduction and the
                        // default result if there are no elements in the stream. In this example, the identity
                        // element is 0; this is the initial value of the sum of ages and the default value if no
                        // members exist in the collection.
                        (a, b) -> a + b
                )
        );
    }

    private static class People {
        String name;
        int age;
        Sex sex;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        public People(String name, int age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
    }

    enum Sex {
        MAN,
        WOMEN
    }
}
