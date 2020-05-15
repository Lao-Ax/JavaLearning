package com.Alex;

public class Main {
    static int c = 0;

    public static void main(String[] args) {
        System.out.println(inc());
        System.out.println(inc());
        System.out.println(c);
    }

    static int inc() {
        c++;
        return c;
    }
}
