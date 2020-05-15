package com.Alex.functional_interfaces.comparators;

import java.util.Comparator;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class ComparatorsTest {

    public static void main(String[] args){
        Comparator<Person> comparator = (p1, p2) -> p1.name.compareTo(p2.name);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1, p2));             // > 0
        System.out.println(comparator.reversed().compare(p1, p2));  // < 0
    }

    static class Person {
        String name;
        String lastName;

        Person(){} // Compiler decide which method to use by signature.

        Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return name + " " + lastName;
        }
    }
}
