package org.example.streams.f_min_max;

import java.util.Comparator;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        // min/max: terminal ops returning Optional
        List<Integer> temperatures = List.of(7, 3, 11, -2, 14, -5);

        int coldest = temperatures.stream().min(Comparator.naturalOrder()).orElseThrow();
        int hottest = temperatures.stream().max(Comparator.naturalOrder()).orElseThrow();

        System.out.println("coldest = " + coldest + ", hottest = " + hottest);
    }
}
