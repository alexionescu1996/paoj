package org.example.streams.f_min_max;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ex {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(7, 3, 11, 5, 9, 1);

        Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());

        System.out.println("min = " + min.orElseThrow());
        System.out.println("max = " + max.orElseThrow());

        List<String> words = List.of("banana", "fig", "apple", "kiwi");
        String shortest = words.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse("(empty)");
        String longest = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("(empty)");
        System.out.println("shortest = " + shortest);
        System.out.println("longest  = " + longest);

        Optional<Integer> emptyMin = List.<Integer>of().stream().min(Comparator.naturalOrder());
        System.out.println("min on empty = " + emptyMin.orElse(-1));
    }
}
