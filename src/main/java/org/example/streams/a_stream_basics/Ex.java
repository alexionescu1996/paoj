package org.example.streams.a_stream_basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex {
    public static void main(String[] args) {

        Stream<String> fromOf = Stream.of("a", "b", "c");
        System.out.println("count from of = " + fromOf.count());

        List<String> letters = Arrays.asList("a", "b", "c", "d");
        long fromList = letters.stream().count();
        System.out.println("count from list = " + fromList);

        System.out.println("\n--- intermediate ops are lazy ---");
        Stream<String> pipeline = letters.stream()
                .peek(s -> System.out.println("peek 1: " + s))
                .peek(s -> System.out.println("peek 2: " + s));

        System.out.println("(nothing printed yet — no terminal op)\n");

        pipeline.forEach(s -> System.out.println("forEach: " + s));
    }
}
