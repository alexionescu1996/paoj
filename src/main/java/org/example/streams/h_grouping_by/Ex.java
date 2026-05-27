package org.example.streams.h_grouping_by;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex {

    record Product(String name, String category) {}

    public static void main(String[] args) {

        // groupingBy(classifier) -> Map<K, List<T>>
        List<Product> catalog = List.of(
                new Product("Headphones", "electronics"),
                new Product("Mug", "kitchen"),
                new Product("Keyboard", "electronics"),
                new Product("Pan", "kitchen")
        );

        Map<String, List<Product>> byCategory = catalog.stream()
                .collect(Collectors.groupingBy(Product::category));

        byCategory.forEach((cat, items) -> System.out.println(cat + " -> " + items));
    }
}
