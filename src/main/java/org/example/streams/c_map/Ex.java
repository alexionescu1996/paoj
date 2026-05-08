package org.example.streams.c_map;

import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<String> words = List.of("apple", "banana", "cherry");

        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("upper   = " + upper);

        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("lengths = " + lengths);

        List<String> ids = List.of("1", "2", "42", "100");
        int sum = ids.stream()
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum     = " + sum);
    }
}
