package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuTest {
    @DisplayName("메뉴판에서 메뉴이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItems("돈까스",5000), new MenuItems("냉면", 7000)));

        MenuItems menuItems = menu.choose("돈까스");

        assertThat(menuItems).isEqualTo(new MenuItems("돈까스", 5000));
    }

    @DisplayName("메뉴판에 없는 메뉴 주문 시 예외를 반환한다.")
    @Test
    void chooseTest2() {
        Menu menu = new Menu(List.of(new MenuItems("돈까스",5000), new MenuItems("냉면", 7000)));

        assertThatCode(() -> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴이름 입니다.");
    }
}
