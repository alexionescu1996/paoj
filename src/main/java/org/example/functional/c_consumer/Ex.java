package org.example.functional.c_consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ex {
    public static void main(String[] args) {

        Consumer<String> printer = s -> System.out.println("> " + s);
        printer.accept("hello");

        Consumer<String> shouter = s -> System.out.println(s.toUpperCase());

        Consumer<String> chained = printer.andThen(shouter);
        chained.accept("world");

        List<String> heroes = Arrays.asList("Superman", "Batman", "Wonder Woman");
        heroes.forEach(printer);
    }
}
