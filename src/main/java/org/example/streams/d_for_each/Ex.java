package org.example.streams.d_for_each;

import java.util.List;

public class Ex {
    public static void main(String[] args) {

        List<String> subscribers = List.of(
                "alice@example.com",
                "bob@example.com",
                "carol@example.com"
        );

        System.out.println("--- forEach with method reference ---");
        subscribers.forEach(System.out::println);

        System.out.println("\n--- forEach with lambda ---");
        subscribers.forEach(email -> System.out.println("notify: " + email));

        System.out.println("\n--- forEach as stream terminal op (only long-domain subs) ---");
        subscribers.stream()
                .filter(email -> email.endsWith("@example.com"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
