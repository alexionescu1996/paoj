package org.example.streams.f_min_max;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ex {
    public static void main(String[] args) {

        List<Integer> temperatures = List.of(7, 3, 11, -2, 9, 1, 14, -5);

        Optional<Integer> coldest = temperatures.stream().min(Comparator.naturalOrder());
        Optional<Integer> hottest = temperatures.stream().max(Comparator.naturalOrder());

        System.out.println("coldest temperature = " + coldest.orElseThrow() + "°C");
        System.out.println("hottest temperature = " + hottest.orElseThrow() + "°C");

        List<String> products = List.of("Mug", "Headphones", "Pen", "Keyboard");
        String shortest = products.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse("(none)");
        String longest = products.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("(none)");
        System.out.println("shortest product name = " + shortest);
        System.out.println("longest product name  = " + longest);

        Optional<Integer> emptyMin = List.<Integer>of().stream().min(Comparator.naturalOrder());
        System.out.println("min on empty = " + emptyMin.orElse(-999));
    }
}
