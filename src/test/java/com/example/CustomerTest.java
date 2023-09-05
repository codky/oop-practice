package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 음식점에서 음식을 주문하는 과정 구현
 * 1. 도메인을 구성하는 객체에는 어떤것들이 있는지 고민
 *     ㄴ 손님(O), 메뉴판(O), 돈까스/냉면(O), 요리사(O), 요리(O)
 * 2. 객체들 간의 관계를 고민
 *     ㄴ 손님 -- 메뉴판
 *     ㄴ 손님 -- 요리사
 *     ㄴ 요리사 -- 요리
 * 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
 *     ㄴ 손님 -- 손님 타입
 *     ㄴ 돈까스/냉면/만두 -- 요리 타입
 *     ㄴ 메뉴판 -- 메뉴판 타입
 *     ㄴ 메뉴 -- 메뉴 타입
 */
public class CustomerTest {
    @DisplayName("메뉴이름에 해당하는 요리를 주문한다.")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItems("돈까스",5000), new MenuItems("냉면", 7000)));
        Cooking cooking = new Cooking();

        assertThatCode(() -> customer.order("돈까스", menu, cooking))
                .doesNotThrowAnyException();
    }
}
