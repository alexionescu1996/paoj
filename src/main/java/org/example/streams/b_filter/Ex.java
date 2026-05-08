package org.example.streams.b_filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(-3, -1, 0, 2, 5, 8, 13);

        List<Integer> positives = numbers.stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        System.out.println("positives = " + positives);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> positiveEvens = numbers.stream()
                .filter(n -> n > 0)
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println("positive evens = " + positiveEvens);

        List<String> words = List.of("apple", "fig", "banana", "kiwi", "pear");
        long longCount = words.stream()
                .filter(w -> w.length() > 4)
                .count();
        System.out.println("words longer than 4 = " + longCount);
    }
}
