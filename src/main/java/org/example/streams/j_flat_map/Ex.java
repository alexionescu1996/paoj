package org.example.streams.j_flat_map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex {

    record Order(String id, List<String> items) {}

    public static void main(String[] args) {

        // flatMap(T -> Stream<R>) — flattens nested structures
        //   map  produces Stream<Stream<R>>     ← one element per input
        //   flatMap produces Stream<R>          ← merges them into one stream
        // typical use: List<List<X>> -> List<X>, sentence -> words, etc.

        List<Order> orders = List.of(
                new Order("ORD-1001", List.of("Headphones", "USB-C Hub")),
                new Order("ORD-1002", List.of("Mug")),
                new Order("ORD-1003", List.of("Keyboard", "Mouse", "Mousepad")),
                new Order("ORD-1004", List.of("Pen", "Notebook"))
        );

        List<String> allItems = orders.stream()
                .flatMap(order -> order.items().stream())
                .collect(Collectors.toList());
        System.out.println("all items shipped = " + allItems);

        long totalItemCount = orders.stream()
                .flatMap(order -> order.items().stream())
                .count();
        System.out.println("total item count  = " + totalItemCount);

        List<String> reviews = List.of(
                "fast shipping great quality",
                "loved the product great value",
                "shipping was slow but quality is great"
        );

        List<String> uniqueWords = reviews.stream()
                .flatMap(review -> Arrays.stream(review.split("\\s+")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("unique review words = " + uniqueWords);
    }
}
