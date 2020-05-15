package com.Alex.functional_interfaces.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alex on 04.04.2017 004.
 */
public class PeekTest {

    public static void main(String[] args){
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        List<String> new_collection = collection.stream().map(String::toUpperCase).peek((e) -> System.out.print("," + e)).
                collect(Collectors.toList());
        System.out.println(new_collection);
    }
}
