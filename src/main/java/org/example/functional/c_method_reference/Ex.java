package org.example.functional.c_method_reference;

import java.util.function.Function;

public class Ex {
    public static void main(String[] args) {

        // ClassName::staticMethod  — shorthand for x -> ClassName.staticMethod(x)
        Function<String, Integer> parse = Integer::parseInt;

        System.out.println(parse.apply("42"));
    }
}
