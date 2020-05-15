package com.Alex.patterns.ComponentPattern;

import java.util.Iterator;

/**
 * Created by Alex on 16.01.2016 016.
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
