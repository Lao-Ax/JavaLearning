package com.Alex.patterns.IteratorPattern;

/**
 * Created by Alex on 14.01.2016 014.
 */
public class DinerMenu implements Menu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 2.99);
        addItem("Hotdog", "A hot dog with saurkraut, relish, onions, topped with cheese", false, 2.99);
    }

    public void addItem(String name, String description, boolean vegeterian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegeterian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full!");
        } else {
            menuItems[numberOfItems++] = menuItem;
        }
    }

//    public MenuItem[] getMenuItems() {
//        return menuItems;
//    } // Этот метод убираем, т.к. он не будет использоваться

    // добавляем другой
    public java.util.Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}
