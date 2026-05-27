package org.example.streams.c_map;

import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        // map(Function): transform each element 1:1
        List<String> products = List.of("Headphones", "Mug", "Keyboard");

        List<String> upper = products.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upper);
    }
}
