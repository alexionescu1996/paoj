package org.example.streams.d_for_each;

import java.util.List;

public class Ex {
    public static void main(String[] args) {

        // forEach(Consumer): terminal op for side effects
        List<String> subscribers = List.of("alice@example.com", "bob@example.com");

        subscribers.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
