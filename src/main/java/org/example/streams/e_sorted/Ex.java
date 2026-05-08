package org.example.streams.e_sorted;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<String> words = List.of("banana", "fig", "apple", "kiwi", "cherry");

        List<String> alphabetical = words.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("alphabetical = " + alphabetical);

        List<String> byLength = words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("by length    = " + byLength);

        List<String> byLengthDesc = words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("by length desc = " + byLengthDesc);

        List<String> tieBreaker = words.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println("by length, then alpha = " + tieBreaker);
    }
}
