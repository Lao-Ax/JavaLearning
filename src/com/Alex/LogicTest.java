package com.Alex;

/**
 * Created by Alex on 09.11.2015 009.
 */
public class LogicTest {
    //boolean x, y, z;

    static boolean f(boolean x, boolean y, boolean z){
//        return (x ^ y) & !z
//             ||(x ^ z) & !y
//             ||(z ^ y) & !x;
        return //!(x&y&z)&(x^y^z)
                x^y^z^x&y&z;
    }

    public static void main(String[] args) {
        System.out.println(f(false, false, false));
        System.out.println("HERE " + f(false, false, true));
        System.out.println("HERE " + f(false, true, false));
        System.out.println(f(false, true, true));
        System.out.println("HERE " + f(true, false, false));
        System.out.println(f(true, false, true));
        System.out.println(f(true, true, false));
        System.out.println(f(true, true, true));
    }
}
