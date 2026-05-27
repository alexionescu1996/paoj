package org.example.streams.b_filter;

import java.util.List;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        // filter(Predicate): keep only matching elements
        List<Double> transactions = List.of(-50.0, 25.0, 100.0, -12.0, 250.0);

        List<Double> credits = transactions.stream()
                .filter(amount -> amount > 0)
                .collect(Collectors.toList());

        System.out.println(credits);
    }
}
