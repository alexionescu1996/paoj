package org.example.segregation;

/**
 * Interface Segregation: split one broad interface into focused contracts.
 * A class implements only what it actually needs.
 */
public class SegregationDemo {

    public static void run() {
        System.out.println("=== Segregation: focused interface contracts ===");

        Multiplier multiplier = new Multiplier();
        System.out.println("Multiplier: 5 * 3 = " + multiplier.multiply(5, 3));

        Calculator calculator = new Calculator();
        System.out.println("Calculator: 10 * 4 = " + calculator.multiply(10, 4));
        System.out.println("Calculator: 10 / 4 = " + calculator.divide(10, 4));
        System.out.println();
    }
}
