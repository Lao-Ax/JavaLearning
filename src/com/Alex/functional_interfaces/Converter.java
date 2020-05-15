package com.Alex.functional_interfaces;

/**
 * Created by Alex on 24.03.2017 024.
 */
@FunctionalInterface // can be removed
public interface Converter<F, T> {
    T convert(F from);
}
