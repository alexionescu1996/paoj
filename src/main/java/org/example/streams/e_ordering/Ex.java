package org.example.streams.e_ordering;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        // sorted / min / max — all driven by a Comparator
        List<String> cities = List.of("Bucharest", "Paris", "London", "Tokyo");
        Comparator<String> byLength = Comparator.comparingInt(String::length);

        List<String> sorted = cities.stream().sorted(byLength).collect(Collectors.toList());
        String shortest = cities.stream().min(byLength).orElseThrow();
        String longest  = cities.stream().max(byLength).orElseThrow();

        System.out.println("sorted   = " + sorted);
        System.out.println("shortest = " + shortest);
        System.out.println("longest  = " + longest);
    }
}
