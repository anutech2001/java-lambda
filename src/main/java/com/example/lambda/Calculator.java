package com.example.lambda;

public class Calculator {

    static Calculation add = (x, y) -> x + y;
    static Calculation subtraction = (x, y) -> x - y;
    static Calculation multiply = (x, y) -> x * y;

    static Integer calculate(Calculation operation, Integer x, Integer y) {
        return operation.apply(x, y);
    }

    public static void main(String[] args) {
        System.out.printf("1+2=%d\n", calculate(add, 1, 2));
        System.out.printf("1-2=%d", calculate(subtraction, 1, 2));

    }
}
