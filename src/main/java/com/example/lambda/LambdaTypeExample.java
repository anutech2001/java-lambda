package com.example.lambda;

public class LambdaTypeExample {

    @FunctionalInterface
    interface Calculator {
        Integer add(Integer x, Integer y);
    }

    public static void main(String[] args) {
        Calculator cal1 = (x, y) -> x + y;
        Calculator cal2 = (x, y) -> x - y;
        System.out.println(cal1.add(1, 2));
        System.out.println(cal2.add(1, 2));
    }
}
