package com.example;

import java.util.List;

public class Menu {
    private final List<MenuItems> menuItems;

    public Menu(List<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItems choose(String name) {

        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴이름 입니다."));
    }

}
