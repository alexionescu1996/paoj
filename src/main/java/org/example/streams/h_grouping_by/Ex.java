package org.example.streams.h_grouping_by;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<String> words = List.of("apple", "fig", "banana", "kiwi", "cherry", "pear", "plum");

        Map<Integer, List<String>> byLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("groupingBy length = " + byLength);

        Map<Character, List<String>> byFirstLetter = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println("groupingBy first letter = " + byFirstLetter);

        Map<Integer, Long> countByLength = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("count by length = " + countByLength);

        Map<Boolean, List<String>> partitioned = words.stream()
                .collect(Collectors.partitioningBy(w -> w.length() > 4));
        System.out.println("partition by length>4 = " + partitioned);
    }
}
