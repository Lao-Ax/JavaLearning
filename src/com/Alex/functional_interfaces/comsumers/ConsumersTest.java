package com.Alex.functional_interfaces.comsumers;

import java.util.function.Consumer;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class ConsumersTest {

    public static void main(String[] args){
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.name);
        greeter.accept(new Person("Luke", "Skywalker"));
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
