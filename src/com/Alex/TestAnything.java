package com.Alex;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by Alex on 22.08.2015 022.
 */
public class TestAnything {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("a", "b")));
        list.add(new ArrayList<>(Arrays.asList("d")));

        list.stream().filter(l -> l.size() > 1)
                .forEach(li -> System.out.println(li.get(0)));
    }
}
