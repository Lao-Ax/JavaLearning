package com.Alex.functional_interfaces.functions;

import java.util.function.Function;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class FunctionsTest {

    public static void main(String[] args){
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(toInteger.apply("1")+1);
        System.out.println(backToString.apply("1")+1);     // "123"
    }
}
