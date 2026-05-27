package org.example.functional.d_function_interfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex {
    public static void main(String[] args) {

        // java.util.function — ready-made SAM types for common shapes
        Predicate<Integer>        isPositive = n -> n > 0;          // T -> boolean
        Function<String, Integer> length     = String::length;      // T -> R
        Consumer<String>          print      = System.out::println; // T -> void
        Supplier<Double>          random     = Math::random;        //   -> T

        System.out.println("isPositive.test(5)    = " + isPositive.test(5));
        System.out.println("length.apply('hello') = " + length.apply("hello"));
        print.accept("consumed by Consumer");
        System.out.println("random.get()          = " + random.get());
    }
}
