package com.Alex.patterns.IteratorPattern;
import java.util.ArrayList;

/**
 * Created by Alex on 14.01.2016 014.
 */
@Deprecated
public class BreakfastMenuIterator implements Iterator{
    ArrayList<MenuItem> items;
    int position;

    public BreakfastMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.size() || items.get(position) == null)
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }
}
