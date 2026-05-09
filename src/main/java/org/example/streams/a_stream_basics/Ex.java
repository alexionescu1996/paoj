package org.example.streams.a_stream_basics;

import java.util.List;
import java.util.stream.Stream;

public class Ex {
    public static void main(String[] args) {

        Stream<String> fromOf = Stream.of("Headphones", "Mug", "Keyboard");
        System.out.println("count from of   = " + fromOf.count());

        List<String> products = List.of("Headphones", "Mug", "Keyboard", "Pen");
        long fromList = products.stream().count();
        System.out.println("count from list = " + fromList);

        System.out.println("\n--- intermediate ops are lazy ---");
        Stream<String> pipeline = products.stream()
                .peek(p -> System.out.println("peek 1: " + p))
                .peek(p -> System.out.println("peek 2: " + p));

        System.out.println("(nothing printed yet — no terminal op)\n");

        pipeline.forEach(p -> System.out.println("forEach: " + p));
    }
}
