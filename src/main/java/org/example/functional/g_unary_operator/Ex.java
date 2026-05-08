package org.example.functional.g_unary_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Ex {
    public static void main(String[] args) {

        UnaryOperator<Integer> increment = n -> n + 1;
        UnaryOperator<String> toUpper = s -> s.toUpperCase();

        System.out.println("increment.apply(10) = " + increment.apply(10));
        System.out.println("toUpper.apply('hi') = " + toUpper.apply("hi"));

        List<String> words = new ArrayList<>(List.of("alpha", "beta", "gamma"));
        words.replaceAll(toUpper);
        System.out.println("after replaceAll = " + words);
    }
}
