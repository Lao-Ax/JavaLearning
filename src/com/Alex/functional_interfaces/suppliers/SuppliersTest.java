package com.Alex.functional_interfaces.suppliers;

import java.util.function.Supplier;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class SuppliersTest {

    public static void main(String[] args){
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person
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
