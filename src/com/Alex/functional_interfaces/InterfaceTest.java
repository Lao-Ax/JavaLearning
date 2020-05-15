package com.Alex.functional_interfaces;

/**
 * Created by Alex on 24.03.2017 024.
 */
public class InterfaceTest {

    public static void main(String[] args) {

//        Converter<String, Integer> converter = (from -> Integer.valueOf(from));
        Converter<String, Integer> converter = Integer::valueOf; // equivalent
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from); // equivalent
        Integer converted = converter.convert("123");
        System.out.println(converted);
        System.out.println(converted.getClass());

        Converter<Integer, Double> converter2 = Integer::doubleValue;
        Double d = converter2.convert(1);
        System.out.println(d);
        System.out.println(d.getClass());

        SomeClass someClass = new SomeClass();
        Converter<String, String> converter3 = someClass::startsWith;
        String converted_string = converter3.convert("Cat");
        System.out.println(converted_string);
        System.out.println(converted_string.getClass());

//        final int num = 1;
        int num = 1; // equivalent until num is re-assigned.
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));
    }

    static class SomeClass{
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }
}
