package org.example.steps;

/**
 * Step 2 — Separate interfaces by responsibility (Interface Segregation Principle).
 *
 * Instead of one big interface, split into focused contracts.
 * A class can implement only what it needs.
 */
public class Step2_InterfaceSeparation {

    interface MathMultiply {
        double multiply(int a, int b);
    }

    interface MathDivide {
        double divide(int a, int b);
    }

    // A class that only needs multiplication
    static class Multiplier implements MathMultiply {
        @Override
        public double multiply(int a, int b) {
            return (double) a * b;
        }
    }

    // A class that needs both
    static class BasicCalculator implements MathMultiply, MathDivide {
        @Override
        public double multiply(int a, int b) {
            return (double) a * b;
        }

        @Override
        public double divide(int a, int b) {
            return (double) a / b;
        }
    }

    public static void run() {
        System.out.println("=== Step 2: Interface Separation ===");

        Multiplier multiplier = new Multiplier();
        System.out.println("Multiplier: 5 * 3 = " + multiplier.multiply(5, 3));

        BasicCalculator calc = new BasicCalculator();
        System.out.println("Calculator: 10 * 4 = " + calc.multiply(10, 4));
        System.out.println("Calculator: 10 / 4 = " + calc.divide(10, 4));
        System.out.println();
    }
}
