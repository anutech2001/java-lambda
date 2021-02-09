package com.example.lambda;

import java.util.function.UnaryOperator;

/**
 * UtilUnaryOperatorExample
 */
public class UtilUnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<String> uo = s -> s.toUpperCase();
        System.out.print(uo.apply("Ocpjp 8"));
    }

}