package com.Alex.patterns.ComponentPattern;

/**
 * Created by Alex on 16.01.2016 016.
 */
public class MenuTest {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        pancakeHouseMenu.add(new MenuItem("K&B Pancake Breakfast", "Pancake with scramble eggs, and toast", true, 2.99));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancake with field eggs, sausage", false, 2.99));
        pancakeHouseMenu.add(new MenuItem("Blueberry Pancake", "Pancake made with fresh blueberries", true, 3.49));
        pancakeHouseMenu.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));

        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        dinerMenu.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
        dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
        dinerMenu.add(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 2.99));
        dinerMenu.add(new MenuItem("Hotdog", "A hot dog with saurkraut, relish, onions, topped with cheese", false, 2.99));
        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara", true, 3.89));

        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        cafeMenu.add(new MenuItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun lettuce, tomato, and fries", true, 3.99));
        cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soap of the day, with a side salad", false, 3.69));
        cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));

        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        dessertMenu.add(new MenuItem("Apple pie","Apple pie with a flaky crust", true, 1.59));
        dinerMenu.add(dessertMenu);

        MenuComponent allMenus = new Menu("AllM MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        Waitress waitress = new Waitress(allMenus);
        //waitress.printMenu();
        waitress.printVegetarianMenu();
    }
}
