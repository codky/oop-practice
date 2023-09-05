package com.example;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking) {
        MenuItems menuItems = menu.choose(menuName);

        Cook cook = cooking.makeCook(menuItems);

    }
}
