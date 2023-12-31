package com.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC패턴 기반으로 구현한다.
 */
public class CalculatorTest {

    // 1 + 2 ----> Calculator (Calculator 에게 작업을 위임)
    //   3   <----
    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() {

        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void subtractionTest() {

        int result = Calculator.calculate(new PositiveNumber(1), "-", new PositiveNumber(2));

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void parameterizedTestAnnotationWithTest(PositiveNumber operand1, String operator, PositiveNumber operand2, int result) {

        int calculateResult = Calculator.calculate(operand1, operator, operand2);

        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(new PositiveNumber(1), "+", new PositiveNumber(2), 3),
                arguments(new PositiveNumber(1), "-", new PositiveNumber(2), -1),
                arguments(new PositiveNumber(1), "*", new PositiveNumber(2), 2),
                arguments(new PositiveNumber(4), "/", new PositiveNumber(2), 2)
        );
    }
}
