package com.example.lambda;

public class VariableClassInstanceExample {

    // A lambda expression can access instance and class variables of a class
    // whether they are effectively final or not(can modify them).
    private int counter = 0;
    private String str = " aa "; // initialized only once

    public static void main(String[] args) {
        VariableClassInstanceExample vc1 = new VariableClassInstanceExample();
        VariableClassInstanceExample vc2 = new VariableClassInstanceExample();

        // Create lambdas
        Printer p1 = vc1.createLambda(1);
        Printer p2 = vc2.createLambda(100);

        // Execute the lambda bodies
        p1.print("Lambda #1");
        p2.print("Lambda #2");
        p1.print("Lambda #1");
        p2.print("Lambda #2");
        p1.print("Lambda #1");
        p2.print("Lambda #2");
    }

    public Printer createLambda(int incrementBy) {
        Printer printer = msg -> {
            // Accesses instance and local variables
            counter += incrementBy;
            str = " bb "; // It not the same concept about effectively final local variables
            System.out.println(msg + ": counter = " + counter);
        };

        return printer;
    }

    @FunctionalInterface
    private interface Printer {
        void print(String msg);
    }
}