package com.example.lambda;

import java.util.function.Consumer;

class myInt {
    int i = 0;
}

public class AreLambdasClosures2 {
    public static void main(String[] args) {
        new AreLambdasClosures2().try_it();
    }

    public Consumer<Integer> make_fun2() {
        myInt n = new myInt(); // Object
        return arg -> {
            n.i += arg;
            System.out.println(arg + " " + n.i);
        };
        // if you use this with any kind of concurrency, you have the problem of mutable
        // shared state.
    }

    public void try_it() {
        Consumer<Integer> x = make_fun2(), y = make_fun2();
        for (int i = 0; i < 5; i++)
            x.accept(i);
        for (int i = 10; i < 15; i++)
            y.accept(i);
    }
}