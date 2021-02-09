package com.example.lambda;

import java.util.function.Supplier;

public class UtilSupplierExample {
    public static void main(String[] args) {
        moveAnimal(() -> new Animal());
        moveAnimal(() -> new Bird());
        moveAnimal(new Animal());
        moveAnimal(new Bird());
    }

    public static void moveAnimal(Supplier<Animal> supplier) {
        Animal animal = supplier.get();
        animal.move();
    }

    public static void moveAnimal(Animal animal) {
        // Animal animal = supplier.get();
        animal.move();
    }
}

class Animal {
    public void move() {
        System.out.println("Move");
    }

    @Override
    public String toString() {
        return "Some Animal";
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("Fly");
    }
}
