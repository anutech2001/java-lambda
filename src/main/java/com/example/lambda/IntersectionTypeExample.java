package com.example.lambda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IntersectionTypeExample {
    private final static String FILE = "./ser.ser";

    public static void main(String[] args) {
        Serializable ser = (java.io.Serializable & Calculator1) (x, y) -> x + y;
        wrtieToFile(ser);
        Object obj = readFromFile();
        if (obj instanceof Serializable) {
            System.out.println("Object is Serializable object.");
            if (obj instanceof Calculator1) {
                System.out.println("Object is Caculator1 object.");
                Calculator1 cal = (Calculator1) obj;
                System.out.println(cal.calculate(1, 2));
            }
        }
    }

    private static Object readFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static void wrtieToFile(Serializable ser) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(FILE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(ser);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@FunctionalInterface
interface Calculator1 {
    long calculate(long x, long y);
}
