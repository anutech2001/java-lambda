package com.example.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {

    static String upperVowelStatic(String x) {
        if (x == null)
            return x;

        int N = x.length();
        char[] str = x.toCharArray();

        for (int i = 0; i < N; i++) {
            if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
                char c = Character.toUpperCase(str[i]);
                str[i] = c;
            }
        }
        return String.valueOf(str);
    }

    String upperVowel(String x) {
        return upperVowelStatic(x);
    }

    @FunctionalInterface
    interface TextTransformer {
        String transform(String x);
    }

    @FunctionalInterface
    interface A {
        String transform(MethodReferenceExample m, String x);

        // String transform(MethodReferenceExample m, String x);
    }

    public static void main(String[] args) {

        // Reference to a static method
        TextTransformer transform1 = (x) -> MethodReferenceExample.upperVowelStatic(x);
        // TODO change to method ref.
        TextTransformer transformx = MethodReferenceExample::upperVowelStatic;
        System.out.println(transformx.transform("anurak theanpurmpul"));

        // Instance Method References - bound receiver
        MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
        TextTransformer transform2 = methodReferenceExample::upperVowel;
        System.out.println(transform2.transform("anurak theanpurmpul"));

        // Instance Method References - unbound receiver
        // (I provide the receiver implicitly when the method is invokeds)
        // Rule - The first argument to the function represented by the target type is
        // the receiver of the method invocation.
        A a = MethodReferenceExample::upperVowel;
        System.out.println(a.transform(new MethodReferenceExample(), "anurak"));

        // Unbound example
        Function<String, Integer> strLengthFunc = String::length;
        String name = "Anurak";
        //// name is the receiver of String::length
        int len = strLengthFunc.apply(name);
        System.out.println("name = " + name + ", length = " + len);

        // Unbound example (toUpperCase() is instance method)
        TextTransformer transform3 = String::toUpperCase;
        System.out.println(transform3.transform("anurak"));

        // Unbound example with BiFunction
        BiFunction<String, String, String> func1 = String::concat;
        System.out.println(func1.apply("anurak", " theanpurmpul"));

        // Using a method reference
        Function<Integer, String> func2 = Integer::toBinaryString; // Static Method References
        System.out.println(func2.apply(2));

        BiFunction<Integer, Integer, Integer> func3 = Integer::sum; // A compile-time error
        System.out.println(func3.apply(17, 1));
    }

}
