package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * UtilConsumerExample
 */
public class UtilConsumerExample {

    public static void main(String[] args) {
        // CASE 1
        // Consumer to display a number
        Consumer<Integer> display = a -> System.out.println(a);

        // Implement display using accept()
        display.accept(10);

        // CASE 2
        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of integers
        Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        // using addThen()
        modify.andThen(dispList).accept(list);

        // When NullPointerException is returned.
        try {
            // using addThen()
            modify.andThen(null).accept(list);
        } catch (Exception e) {
            System.out.println("\nException: " + e);
        }

        // // CASE 3 - how an Exception in the after function is returned and handled.
        // Consumer to multiply 2 to every integer of a list
        // Consumer<List<Integer>> modify = list -> {
        // for (int i = 0; i <= list.size(); i++) // add equal
        // list.set(i, 2 * list.get(i));
        // };

        // // Consumer to display a list of integers
        // Consumer<List<Integer>> dispList = list -> list.stream().forEach(a ->
        // System.out.print(a + " "));
        // System.out.println();

        // List<Integer> list = new ArrayList<Integer>();
        // list.add(2);
        // list.add(1);
        // list.add(3);

        // // using addThen()
        // try {
        // dispList.andThen(modify).accept(list);
        // ;
        // } catch (Exception e) {
        // System.out.println("Exception: " + e);
        // }
    }
}