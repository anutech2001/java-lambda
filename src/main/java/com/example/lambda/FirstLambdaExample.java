package com.example.lambda;

public class FirstLambdaExample {

    private static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " This is runnable thread.");
        }
    }

    public static void main(String[] args) {

        // // case 1:
        // Runnable r = new Task();
        // Thread t1 = new Thread(r);
        // t1.start();

        // case 2:
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " This is runnable thread anonymous .");
            }
        };
        Thread t1 = new Thread(r);
        t1.start();

    }

    @FunctionalInterface
    interface MyRunnable extends Runnable {
        // TODO add new abstract method
    }

}
