package com.Alex;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Alex on 22.08.2015 022.
 */
public class TestAnything {

    static void methodBoxVar(int in) {
        System.out.println("int");
    }
    static void methodBoxVar(Integer in) {
        System.out.println("Integer");
    }

    static void methodBoxVar(Integer... i) {
        System.out.println("Integers");
    }
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("a", "b")));
        list.add(new ArrayList<>(Arrays.asList("d")));

        list.stream().filter(l -> l.size() > 1)
                .forEach(li -> System.out.println(li.get(0)));

        methodBoxVar(20);

        Integer oa = new Integer(10);
        Integer ob = new Integer(10);
        System.out.println(oa == ob);

        Integer oa2 = 10;
        Integer ob2 = 10;
        System.out.println(oa2 == ob2);

        Integer y = 567;
        Integer x = y;
        // проверяем, что x и y указывают на один объект
        System.out.println(y == x);

        y++;
        System.out.println(x + " " + y);
        // проверяем, что x и y указывают на один объект
        System.out.println(y == x);
    }
}
