package com.Alex.functional_interfaces;

/**
 * Created by Alex on 24.03.2017 024.
 */
public class TestWithConstructor {

    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Cat", "Vaska");
        System.out.println(person);
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

    @FunctionalInterface
    interface PersonFactory<P extends Person> {
        P create(String name, String lastName);
    }
}
