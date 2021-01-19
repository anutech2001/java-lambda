package com.example.lambda;

@FunctionalInterface
interface Calculation {
    Integer apply(Integer x, Integer y);
}
