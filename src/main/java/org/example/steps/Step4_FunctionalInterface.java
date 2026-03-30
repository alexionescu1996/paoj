package org.example.steps;

/**
 * Step 4 — @FunctionalInterface and lambdas.
 *
 * An interface with exactly one abstract method is a functional interface.
 * The @FunctionalInterface annotation enforces this at compile time.
 * Functional interfaces can be instantiated with lambda expressions.
 */
public class Step4_FunctionalInterface {

    @FunctionalInterface
    interface MathMultiply {
        double multiply(int a, int b);
    }

    @FunctionalInterface
    interface MathDivide {
        double divide(int a, int b);
    }

    // MathOperation extends two functional interfaces and adds a method,
    // so it has 3 abstract methods — it is NOT a functional interface.
    interface MathOperation extends MathMultiply, MathDivide {
        double applyFunction(int a, int b);
    }

    public static void run() {
        System.out.println("=== Step 4: @FunctionalInterface & Lambdas ===");

        // Lambda — concise syntax for a functional interface
        MathMultiply multiply = (a, b) -> (double) a * b;
        MathDivide divide = (a, b) -> (double) a / b;

        System.out.println("Lambda multiply: 6 * 7 = " + multiply.multiply(6, 7));
        System.out.println("Lambda divide:  10 / 3 = " + divide.divide(10, 3));

        // Method reference — even more concise
        MathMultiply multiplyRef = Math::multiplyExact;
        System.out.println("Method ref multiply: 6 * 7 = " + multiplyRef.multiply(6, 7));

        // MathOperation still needs an anonymous class or a full implementation
        // because it has more than one abstract method
        MathOperation calculator = new MathOperation() {
            @Override
            public double multiply(int a, int b) {
                return (double) a * b;
            }

            @Override
            public double divide(int a, int b) {
                return (double) a / b;
            }

            @Override
            public double applyFunction(int a, int b) {
                return Math.pow(a, b);
            }
        };

        System.out.println("Calculator pow: 2 ^ 10 = " + calculator.applyFunction(2, 10));
        System.out.println();
    }
}
