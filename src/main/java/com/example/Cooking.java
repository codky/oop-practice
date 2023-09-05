package com.example;

public class Cooking {
    public Cook makeCook(MenuItems menuItems) {
        Cook cook = new Cook(menuItems);
        return cook;
    }
}
