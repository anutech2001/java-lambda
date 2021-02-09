package com.example.lambda;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class UtilFunctionExample {
    private static Function<Long, Long> squareX = x -> x * x;

    public static void main(String[] args) {
        System.out.println(squareX.apply(4l));
        // Takes an int and returns its square
        Function<Integer, Integer> square1 = x -> x * x;
        IntFunction<Integer> square2 = x -> x * x;
        ToIntFunction<Integer> square3 = x -> x * x;
        UnaryOperator<Integer> square4 = x -> x * x;
        UnaryOperator<String> s = x -> x + " World!";

        System.out.println(square1.apply(5));
        System.out.println(square2.apply(5));
        System.out.println(square3.applyAsInt(5));
        System.out.println(square4.apply(5));
        System.out.println(s.apply("Hello"));

        // Create two functions
        Function<Long, Long> square = x -> x * x;
        Function<Long, Long> addOne = x -> x + 1;

        // Compose functions from the two functions
        Function<Long, Long> squareAddOne = square.andThen(addOne);
        Function<Long, Long> addOneSquare = square.compose(addOne);

        // Get an identity function
        Function<Long, Long> identity = Function.<Long>identity();

        // Test the functions
        long num = 5L;
        System.out.println("Number : " + num);
        System.out.println("Square and then add one: " + squareAddOne.apply(num));
        System.out.println("Add one and then square: " + addOneSquare.apply(num));
        System.out.println("Identity: " + identity.apply(num));

        Function<Integer, Integer> identityFunction1 = Function.identity();
        Function<Integer, Integer> identityFunction2 = Function.identity();
        Function<Integer, Integer> identityFunction3 = Function.identity();

        Function<Integer, Integer> intFunction1 = e -> e;
        Function<Integer, Integer> intFunction2 = e -> e;
        Function<Integer, Integer> intFunction3 = e -> e;

        System.out.println(identityFunction1);
        System.out.println(identityFunction2);
        System.out.println(identityFunction3);

        System.out.println(intFunction1);
        System.out.println(intFunction2);
        System.out.println(intFunction3);
    }
}