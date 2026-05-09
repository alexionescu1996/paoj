package org.example.streams.e_sorted;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<String> cities = List.of("Bucharest", "Paris", "London", "Tokyo", "Cluj-Napoca", "Rome");

        List<String> alphabetical = cities.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("alphabetical   = " + alphabetical);

        List<String> byLength = cities.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("by name length = " + byLength);

        List<String> byLengthDesc = cities.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("by length desc = " + byLengthDesc);

        List<String> tieBreaker = cities.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println("by length, then alpha = " + tieBreaker);
    }
}
