package org.example.functional.e_function;

import java.util.function.Function;

public class Ex {
    public static void main(String[] args) {

        // Function<T,R> = R apply(T)
        Function<String, Integer> length = String::length;
        Function<Integer, Integer> doubler = n -> n * 2;

        // andThen: first length, then doubler
        Function<String, Integer> score = length.andThen(doubler);

        System.out.println("score('hello') = " + score.apply("hello"));
    }
}
