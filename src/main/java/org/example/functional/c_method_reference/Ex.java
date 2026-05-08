package org.example.functional.c_method_reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex {

    public static String shout(String value) {
        return value.toUpperCase() + "!";
    }

    public static void main(String[] args) {

        Function<String, Integer> parseLambda = s -> Integer.parseInt(s);
        Function<String, Integer> parseRef = Integer::parseInt;
        System.out.println("static ref Integer::parseInt('42') = " + parseRef.apply("42"));
        System.out.println("equivalent lambda result          = " + parseLambda.apply("42"));

        Function<String, String> shouter = Ex::shout;
        System.out.println("static ref Ex::shout('hello') = " + shouter.apply("hello"));

        String prefix = ">>> ";
        Function<String, String> prepend = prefix::concat;
        System.out.println("bound ref prefix::concat('hi') = " + prepend.apply("hi"));

        Function<String, Integer> length = String::length;
        BiFunction<String, String, Boolean> startsWith = String::startsWith;
        System.out.println("unbound ref String::length('abc')        = " + length.apply("abc"));
        System.out.println("unbound ref String::startsWith('a','ab') = " + startsWith.apply("ab", "a"));

        Supplier<StringBuilder> builderFactory = StringBuilder::new;
        StringBuilder sb = builderFactory.get();
        sb.append("built via constructor ref");
        System.out.println(sb);

        List<String> words = Arrays.asList("one", "two", "three");
        words.forEach(System.out::println);
    }
}
