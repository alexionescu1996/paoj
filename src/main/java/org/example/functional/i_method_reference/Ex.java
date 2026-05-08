package org.example.functional.i_method_reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex {

    public static String shout(String value) {
        return value.toUpperCase() + "!";
    }

    public static void main(String[] args) {

        Function<String, Integer> parseLambda = s -> Integer.parseInt(s);
        Function<String, Integer> parseRef = Integer::parseInt;

        System.out.println("lambda parse('42') = " + parseLambda.apply("42"));
        System.out.println("ref    parse('42') = " + parseRef.apply("42"));

        Function<Integer, String> intToString = String::valueOf;
        System.out.println("String::valueOf(7) = " + intToString.apply(7));

        Function<String, String> shouter = Ex::shout;
        System.out.println(shouter.apply("hello"));

        List<String> words = Arrays.asList("one", "two", "three");
        words.forEach(System.out::println);
    }
}
