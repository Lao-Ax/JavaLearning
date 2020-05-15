package com.Alex.functional_interfaces.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Alex on 24.03.2017 024.
 */
public class FindAnyTest {

    public static void main(String[] args) {
        List<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.println(collection.stream()
                .filter("a4"::equals)
                .findFirst()
                .get()
        );
        System.out.println("111");
    }
}
