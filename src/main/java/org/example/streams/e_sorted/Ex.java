package org.example.streams.e_sorted;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        // sorted(Comparator): order the stream
        List<String> cities = List.of("Bucharest", "Paris", "London", "Tokyo");

        List<String> byLength = cities.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        System.out.println(byLength);
    }
}
