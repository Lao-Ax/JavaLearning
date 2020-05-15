package com.Alex.functional_interfaces.predicates;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by Alex on 24.03.2017 024.
 */
public class TestPredicates {

    public static void main(String[] args){
        Predicate<String> predicate = s -> s.length() > 0;

        System.out.println(predicate.test("foo")); // true
        System.out.println(predicate.negate().test("foo")); // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        System.out.println(nonNull.test(null)); // false
        System.out.println(isNull.test(false)); // false

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isEmpty.test("")); // true
        System.out.println(isNotEmpty.test("")); // false
    }
}
