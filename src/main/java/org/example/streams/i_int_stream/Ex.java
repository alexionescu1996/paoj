package org.example.streams.i_int_stream;

import java.util.List;
import java.util.stream.IntStream;

public class Ex {
    public static void main(String[] args) {

        int[] monthlySales = {1200, 1450, 980, 1700, 2050, 1340, 1620, 1810, 1530, 2200, 1900, 2400};

        int totalSales = IntStream.of(monthlySales).sum();
        System.out.println("yearly total = " + totalSales);

        double avgSales = IntStream.of(monthlySales).average().orElse(0);
        System.out.println("average month = " + avgSales);

        int bestMonth = IntStream.of(monthlySales).max().orElse(-1);
        int worstMonth = IntStream.of(monthlySales).min().orElse(-1);
        System.out.println("best month  = " + bestMonth);
        System.out.println("worst month = " + worstMonth);

        int aboveTarget = IntStream.of(monthlySales)
                .filter(s -> s >= 1500)
                .sum();
        System.out.println("sum of months above 1500 target = " + aboveTarget);

        System.out.println("\nq1 indices (rangeClosed 1..3):");
        IntStream.rangeClosed(1, 3).forEach(i -> System.out.println("  month " + i + " sales = " + monthlySales[i - 1]));

        List<String> orderQuantities = List.of("3", "12", "1", "7");
        int totalUnits = orderQuantities.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("\nmapToInt then sum = " + totalUnits);
    }
}
