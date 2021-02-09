package com.example.lambda;

public class ExplicitLambdaExample {

    static void process(InterfaceA interfaceA) {
        System.out.print("InterfaceA:");
        interfaceA.doSomething("data setA");
    }

    // Overloading
    static void process(InterfaceB interfaceB) {
        System.out.print("InterfaceB:");
        interfaceB.execute("data setB");
    }

    // Overloading
    static void process(InterfaceC interfaceC) {
        System.out.print("InterfaceC:");
        int x = 10;
        interfaceC.process(x);
    }

    public static void main(String[] args) {
        // TODO call process() with InterfaceA
        // process((x) -> System.out.println(" process done - data is " + x));

        // TODO explicit by specifying the type of the parameters.
        // process((Integer x) -> System.out.println(" process done - data is " + x));

        // TODO explicit by casting.
        // process((InterfaceA) (x) -> System.out.println(" process done - data is " +
        // x));
        // process((InterfaceB) (x) -> System.out.println(" process done - data is " +
        // x));

        // TODO explicit by using variables.
        // InterfaceA interfaceA = (x) -> System.out.println(" process done - data is "
        // + x);
        // InterfaceB interfaceB = (x) -> System.out.println(" process done - data is "
        // + x);
        // InterfaceC interfaceC = (x) -> System.out.println(" process done - data is "
        // + x);
        // process(interfaceA);
        // process(interfaceB);
        // process(interfaceC);

    }

    @FunctionalInterface
    private interface InterfaceA {
        void doSomething(String x);
    }

    @FunctionalInterface
    private interface InterfaceB {
        void execute(String x);
    }

    @FunctionalInterface
    private interface InterfaceC {
        void process(Integer x);
    }
}