package com.Alex.functional_interfaces.optionals;

import java.util.Optional;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class OptionalsTest {

    public static void main(String[] args){
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
