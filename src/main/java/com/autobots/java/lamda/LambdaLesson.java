package com.autobots.java.lamda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {
    public static void main(String[] args) {

        MathOperations addition = (a, b) -> a + b;
        MathOperations multiply = (a, b) -> a * b;

        System.out.println("5 + 3 = " + addition.operation(5, 3));
        System.out.println("5 * 3 = " + multiply.operation(5, 3));

        Predicate<String> isNotEmpty = s -> s.isEmpty();
        System.out.println(isNotEmpty.test("Java"));

        Function<Integer, String> toStringFunction = i -> "Chislo: " + i;
        System.out.println(toStringFunction.apply(10));

        Consumer<String> print = s -> System.out.println("Writing: " + s);
        print.accept("Hello world");
    }
}
