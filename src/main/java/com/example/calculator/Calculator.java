package com.example.calculator;

public class Calculator {

    // enum 에게 다시 한번 작업을 위임
    // 객체들끼리 협력해서 작업(CalculatorTest - Calculator - ArithmeticOperator)
    public static int calculate(int operand1, String operator, int operand2) {
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }
}
