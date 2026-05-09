package org.example.streams.h_grouping_by;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex {

    record Product(String name, String category, double price) {}

    public static void main(String[] args) {

        // groupingBy(classifier)            -> Map<K, List<T>>
        // groupingBy(classifier, downstream)-> Map<K, R>   (e.g. counting, averagingDouble)
        // partitioningBy(Predicate)         -> Map<Boolean, List<T>>  (only true/false keys)

        List<Product> catalog = List.of(
                new Product("Headphones", "electronics", 79.0),
                new Product("Mug", "kitchen", 8.5),
                new Product("Keyboard", "electronics", 120.0),
                new Product("Pan", "kitchen", 35.0),
                new Product("Notebook", "stationery", 4.5),
                new Product("Pen", "stationery", 1.5),
                new Product("Speaker", "electronics", 60.0)
        );

        Map<String, List<Product>> byCategory = catalog.stream()
                .collect(Collectors.groupingBy(Product::category));
        System.out.println("groupingBy(category):");
        byCategory.forEach((cat, items) -> System.out.println("  " + cat + " -> " + items));

        Map<String, Long> countByCategory = catalog.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.counting()));
        System.out.println("\ncount by category = " + countByCategory);

        Map<String, Double> avgPriceByCategory = catalog.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.averagingDouble(Product::price)));
        System.out.println("avg price by category = " + avgPriceByCategory);

        Map<Boolean, List<Product>> partitioned = catalog.stream()
                .collect(Collectors.partitioningBy(p -> p.price() >= 50));
        System.out.println("\npartition by price >= 50:");
        partitioned.forEach((isPremium, items) -> System.out.println("  premium=" + isPremium + " -> " + items));
    }
}
