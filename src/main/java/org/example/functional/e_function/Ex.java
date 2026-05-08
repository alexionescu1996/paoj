package org.example.functional.e_function;

import java.util.function.Function;

public class Ex {
    public static void main(String[] args) {

        Function<String, Integer> length = s -> s.length();
        Function<Integer, Integer> doubler = n -> n * 2;

        System.out.println("length.apply('hello') = " + length.apply("hello"));

        Function<String, Integer> lengthThenDouble = length.andThen(doubler);
        System.out.println("lengthThenDouble('hello') = " + lengthThenDouble.apply("hello"));

        Function<String, Integer> composed = doubler.compose(length);
        System.out.println("composed('hello')        = " + composed.apply("hello"));

        Function<String, String> identity = Function.identity();
        System.out.println("identity('x') = " + identity.apply("x"));
    }
}
