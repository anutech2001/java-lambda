package com.example.lambda;

public class ScopeExample {
    public static void main(String[] args) {
        ScopeExample test = new ScopeExample();
        Printer lambdaPrinter = test.getLambdaPrinter();
        lambdaPrinter.print("Lambda Expressions");

        Printer anonymousPrinter = test.getAnonymousPrinter();
        anonymousPrinter.print("Anonymous Class");
    }

    public Printer getLambdaPrinter() {
        System.out.println("getLambdaPrinter(): " + this.getClass());

        // Demo Variable names in a scope must be unique.
        // String msg = "aaa";

        // Uses a lmabda expression
        Printer printer = msg -> {
            // Here, this refers to the current object of the
            // ScopeTest class
            System.out.println(msg + ": " + this.getClass());
        };

        return printer;
    }

    public Printer getAnonymousPrinter() {
        System.out.println("getAnonymousPrinter(): " + this.getClass());

        // Uses an anonymous class
        Printer printer = new Printer() {
            @Override
            public void print(String msg) {
                // Here, this refers to the current object of the
                // anonymous class
                System.out.println(msg + ": " + this.getClass());
            }
        };

        return printer;
    }

}

@FunctionalInterface
interface Printer {
    void print(String msg);
}