package org.example.steps;

/**
 * Step 1 — Interface basics: declaring methods, constants, and redundant modifiers.
 *
 * Notice: public, static, final on interface fields are redundant — IntelliJ greys them out.
 * Interface methods are implicitly public and abstract.
 * We keep them here on purpose to highlight this.
 */
public class Step1_InterfaceBasics {

    interface MathOperation {

        // These modifiers are redundant in an interface — they are implicit.
        // IntelliJ will grey them out to signal this.
        public static final Double PI = Math.PI;
        public static final String ERROR_MESSAGE = "Cannot divide by zero";

        void multiply(int a, int b);

        double divide(int a, int b);
    }

    public static void run() {
        System.out.println("=== Step 1: Interface Basics ===");

        // Anonymous class — the only way to instantiate an interface directly
        MathOperation mathOperation = new MathOperation() {
            @Override
            public void multiply(int a, int b) {
                int result = a * b;
                System.out.println(a + " * " + b + " = " + result);
            }

            @Override
            public double divide(int a, int b) {
                return (double) a / b;
            }
        };

        mathOperation.multiply(2, 4);
        mathOperation.multiply(7, 10);

        double divideResult = mathOperation.divide(7, 10);
        System.out.println("7 / 10 = " + divideResult);

        // Access static constants through the interface
        System.out.println("PI = " + MathOperation.PI);
        System.out.println();
    }
}
