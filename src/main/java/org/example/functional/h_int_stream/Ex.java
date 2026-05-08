package org.example.functional.h_int_stream;

import java.util.stream.IntStream;

public class Ex {
    public static void main(String[] args) {

        int sum = IntStream.range(1, 11).sum();
        System.out.println("sum 1..10        = " + sum);

        int sumInclusive = IntStream.rangeClosed(1, 10).sum();
        System.out.println("sum 1..10 closed = " + sumInclusive);

        double average = IntStream.of(10, 20, 30, 40).average().orElse(0);
        System.out.println("average          = " + average);

        int max = IntStream.of(3, 7, 2, 9, 4).max().orElse(-1);
        System.out.println("max              = " + max);

        int evensSum = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("sum of evens 1..20 = " + evensSum);

        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(n -> System.out.println("square = " + n));
    }
}
