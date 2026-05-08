package org.example.streams.g_collect;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<String> words = List.of("apple", "banana", "apple", "cherry", "banana");

        List<String> asList = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("toList   = " + asList);

        Set<String> asSet = words.stream()
                .collect(Collectors.toSet());
        System.out.println("toSet    = " + asSet);

        String joined = words.stream()
                .distinct()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joining  = " + joined);

        long count = words.stream().collect(Collectors.counting());
        System.out.println("counting = " + count);
    }
}
