package com.example;

import java.util.Objects;

public class MenuItems {
    private final String name;
    private final int price;

    public MenuItems(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public boolean matches(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItems menuItems = (MenuItems) o;
        return price == menuItems.price && Objects.equals(name, menuItems.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}
