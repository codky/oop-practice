package com.example.ooppractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given
        User user = new User();

        // when
        user.initPassword(new CorrectFixedPasswordGenerator());

        // 굳이 구현체를 만들지 않고(CorrectFixedPasswordGenerator()) 람다를 사용해도 됨. (@FunctionalInterface)
        //user.initPassword(() -> "abcdefgh");

        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // given
        User user = new User();

        // when
        user.initPassword(new WrongFixedPasswordGenerator());

        // 굳이 구현체를 만들지 않고(CorrectFixedPasswordGenerator()) 람다를 사용해도 됨. (@FunctionalInterface)
        //user.initPassword(() -> "ab");

        // then
        assertThat(user.getPassword()).isNull();
    }
}