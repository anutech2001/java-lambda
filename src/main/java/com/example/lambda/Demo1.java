package com.example.lambda;

public class Demo1 {

    /**
     * InnerDemo1
     */
    private static class InnerDemo1 implements Runnable {

        @Override
        public void run() {
            System.out.println("This is runnable thread .");
        }
    }
    public static void main(String[] args) {

        Runnable r = () -> System.out.println("This is runnable thread anonymous1 .");


        r.run();

        InterfaceA f = () -> System.out.println("hi a");
//        InterfaceB b = () -> System.out.println("hi b");

    }
    // public static void main(String[] args) {

    //     Runnable r = new Runnable() {

    //         @Override
    //         public void run() {
    //             System.out.println("This is runnable thread anonymous .");
    //         }

    //     };
    //     r.run();
    // }
    // public static void main(String[] args) {

    //     Runnable r = new InnerDemo1();
    //     r.run();
    // }

}
