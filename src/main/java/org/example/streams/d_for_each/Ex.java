package org.example.streams.d_for_each;

import java.util.List;

public class Ex {
    public static void main(String[] args) {

        List<String> heroes = List.of("Superman", "Batman", "Wonder Woman");

        System.out.println("--- forEach with method reference ---");
        heroes.forEach(System.out::println);

        System.out.println("\n--- forEach with lambda ---");
        heroes.forEach(name -> System.out.println("hero: " + name));

        System.out.println("\n--- forEach as stream terminal op ---");
        heroes.stream()
                .filter(h -> h.length() > 6)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
