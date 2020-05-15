package com.Alex.patterns.IteratorPattern;

import com.Alex.patterns.ComponentPattern.*;

import java.util.*;

/**
 * Created by Alex on 16.01.2016 016.
 */
public class CompositeIterator implements java.util.Iterator {
    Stack<java.util.Iterator> stack = new Stack();

    public CompositeIterator(java.util.Iterator<MenuComponent> iterator) { //сохраняем итератор верхнего уровня в стеке
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {  // проверяем, пуст ли стек.
            return false;
        } else {  // есди не пуст,
            java.util.Iterator<MenuComponent> iterator = stack.peek(); // читаем из стека итератор
            if (!iterator.hasNext()) {  // и проверяем, есть ли в нем компоненты, если нету
                stack.pop();   // мы его из стека выкидываем,
                return hasNext(); // и читаем следующий
            } else {
                return true; // а если есть - возвращает тру.
            }
        }
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) { // проверяем, есть ли следующий
            java.util.Iterator<MenuComponent> iterator = stack.peek(); // если следующий есть, мы достаем из стека текущий итератор,
            MenuComponent menuComponent = iterator.next();             // и получаем следующий элемент
            if (menuComponent instanceof Menu) {  // если достали меню, то обнаружили новую комбинацию,
                stack.push(menuComponent.createIterator()); // которую нужно добавить в перебор - положили в стек.
            }
            return menuComponent; // в любом случае вернули компонент.
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
