package org.example.streams.a_stream_basics;

import java.util.List;

public class Ex {
    public static void main(String[] args) {

        // source -> intermediate ops (lazy) -> terminal op (runs the pipeline)
        List<String> products = List.of("Headphones", "Mug", "Keyboard");

        long count = products.stream()
                .filter(p -> p.length() > 3)
                .count();

        System.out.println("count = " + count);
    }
}
