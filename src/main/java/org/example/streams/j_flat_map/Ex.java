package org.example.streams.j_flat_map;

import java.util.List;
import java.util.stream.Collectors;

public class Ex {

    record Order(String id, List<String> items) {}

    public static void main(String[] args) {

        // flatMap: flatten Stream<Stream<T>> into Stream<T>
        List<Order> orders = List.of(
                new Order("ORD-1", List.of("Headphones", "USB-C Hub")),
                new Order("ORD-2", List.of("Mug")),
                new Order("ORD-3", List.of("Keyboard", "Mouse"))
        );

        List<String> allItems = orders.stream()
                .flatMap(order -> order.items().stream())
                .collect(Collectors.toList());

        System.out.println(allItems);
    }
}
