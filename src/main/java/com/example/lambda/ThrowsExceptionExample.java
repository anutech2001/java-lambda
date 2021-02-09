package com.example.lambda;

import java.io.IOException;

public class ThrowsExceptionExample {

    public static void main(String[] args) {

        AInterface aClass = () -> {
            System.out.println("I will throw and exception now.");
            throw new IOException("Errrr");
        };

        try {
            aClass.methodA();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    private interface AInterface {
        void methodA() throws IOException;
    }
}