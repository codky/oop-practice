package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest

{
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();
        MenuItems menuItems = new MenuItems("돈까스", 5000);

        // 요리를 만들어달라고 요청
        Cook cook = cooking.makeCook(menuItems);

        assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
    }
}
