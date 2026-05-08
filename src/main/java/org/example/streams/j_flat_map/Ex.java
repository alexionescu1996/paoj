package org.example.streams.j_flat_map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<List<Integer>> nested = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );

        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("flattened = " + flat);

        List<String> sentences = List.of(
                "the quick brown fox",
                "jumps over the lazy dog"
        );

        List<String> words = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());
        System.out.println("all words = " + words);

        long uniqueWords = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .distinct()
                .count();
        System.out.println("unique words = " + uniqueWords);
    }
}
