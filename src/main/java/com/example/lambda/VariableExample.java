package com.example.lambda;

public class VariableExample {

    // private static String name = "somchai";

    public static void main(String[] args) {
        String msg = "Hello";
        // msg = "a";

        // msg = "aa"; // case #1 break an effectively final

        Printer printer = (msg1) -> {
            // String name = "changeit";
            System.out.println(msg);
            // System.out.println(msg + ", " + name);
            // msg = "aaa"; // case #2 Any local variable accessed inside a lambda
            // expression must be effectively final.
        };
        // msg = "aaa"; // case #3 break an effectively final
        printer.print("msg");
    }

    @FunctionalInterface
    private interface Printer {
        void print(String msg);
    }
}