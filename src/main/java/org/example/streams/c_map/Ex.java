package org.example.streams.c_map;

import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        // map(Function<T, R>) — intermediate, transforms each element 1:1
        // mapToInt / mapToDouble / mapToLong — go to a primitive stream
        //   (avoids boxing and unlocks sum / average / max / min)

        List<String> products = List.of("Headphones", "Mug", "Keyboard");

        List<String> skuPrefixes = products.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("upper-cased SKUs = " + skuPrefixes);

        List<Integer> nameLengths = products.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("name lengths     = " + nameLengths);

        List<String> orderQuantities = List.of("3", "12", "1", "7");
        int totalUnits = orderQuantities.stream()
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("total units sold = " + totalUnits);
    }
}
