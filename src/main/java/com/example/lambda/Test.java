package com.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(s.toString());
        s = "ab";
        System.out.println(s.hashCode());
        s = "a";
        System.out.println(s.hashCode());
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb.hashCode());
        sb.append("def");
        System.out.println(sb.hashCode());

        List<Integer> l = Arrays.asList(2, 9, 1, 0, 5, 8, 7, 6, 3, 4);
        // for loop
        for (Integer i : l) {
            System.out.println(i);
        }

        // Iterator
        Iterator<Integer> ite = l.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }

        // for-each 
        Consumer<Integer> consumer = (x) -> {
            System.out.println(x);
        };
        l.forEach(consumer);

        // for-each with method reference
        l.forEach(System.out::println);

        // Stream API
        l.stream().

    }
}