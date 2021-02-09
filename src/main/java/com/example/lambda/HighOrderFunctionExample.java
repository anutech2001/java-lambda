package com.example.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HighOrderFunctionExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Abc");
        list.add("BCD");

        // A function that takes another function as parameter
        Collections.sort(list, (a, b) -> {
            return a.compareTo(b);
        });
        // Print sorted data
        System.out.println(list);

        // A function that returns another function as result.
        // the reversed() method is considered a higher order function.
        Comparator<String> comparator = (String a, String b) -> a.compareTo(b);
        Comparator<String> comparatorReversed = comparator.reversed();

        Collections.sort(list, comparatorReversed);

        System.out.println(list);

    }

}