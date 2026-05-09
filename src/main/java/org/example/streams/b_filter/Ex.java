package org.example.streams.b_filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        // filter(Predicate) — intermediate op, keeps only matching elements
        // chaining filters is fine: each adds a condition (logical AND)

        List<Double> transactions = List.of(-50.0, -12.5, 0.0, 25.0, 100.0, 250.0, 980.0);

        List<Double> credits = transactions.stream()
                .filter(amount -> amount > 0)
                .collect(Collectors.toList());
        System.out.println("credits         = " + credits);

        Predicate<Double> isLarge = amount -> amount >= 100;
        List<Double> largeCredits = transactions.stream()
                .filter(amount -> amount > 0)
                .filter(isLarge)
                .collect(Collectors.toList());
        System.out.println("large credits   = " + largeCredits);

        List<String> products = List.of("Mug", "Headphones", "Pen", "Keyboard", "USB-C Hub");
        long longNames = products.stream()
                .filter(name -> name.length() > 5)
                .count();
        System.out.println("products with name longer than 5 chars = " + longNames);
    }
}
