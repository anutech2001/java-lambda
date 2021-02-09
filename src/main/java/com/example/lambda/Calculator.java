package com.example.lambda;

public class Calculator {

    // The target type of the lambda expression is Calculation. The compiler
    // verifies that Calculation is a functional interface.
    static Calculation add = (x, y) -> x + y;
    static Calculation subtraction = (x, y) -> x - y;
    static Calculation multiply = (x, y) -> x * y;

    static Integer calculate(Calculation operation, Integer x, Integer y) {
        return operation.apply(x, y);
    }

    public static void main(String[] args) {
        System.out.printf("1+2=%d\n", calculate(add, 1, 2));
        System.out.printf("1-2=%d\n", calculate(subtraction, 1, 2));
        // TODO add joiner
    }

    @FunctionalInterface
    interface Calculation {
        Integer apply(Integer x, Integer y);
    }

    // @FunctionalInterface
    // interface Joiner {
    // String concat(String x, String y);
    // }

}
