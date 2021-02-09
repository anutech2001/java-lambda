package com.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnonymousToLambdaExample {

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 5, 6, 4, 3, 7, 9, 2, 8, 0);

        Predicate<Integer> lessThanFivePredicate = (i) -> i < 5;
        for (Integer n : num) {
            if (lessThanFivePredicate.test(n)) {
                System.out.println(n);
            }
        }
    }
}
