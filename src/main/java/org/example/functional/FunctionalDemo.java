package org.example.functional;

public class FunctionalDemo {

    public static void run() {
        System.out.println("=== Functional: @FunctionalInterface, lambdas, method references ===");

        // Lambda expression
        MathMultiply multiply = (a, b) -> (double) a * b;
        MathDivide divide = (a, b) -> (double) a / b;

        System.out.println("Lambda multiply: 6 * 7 = " + multiply.multiply(6, 7));
        System.out.println("Lambda divide:  10 / 3 = " + divide.divide(10, 3));

        // Method reference
        MathMultiply multiplyRef = Math::multiplyExact;
        System.out.println("Method ref:     6 * 7 = " + multiplyRef.multiply(6, 7));

        // MathOperation has 3 abstract methods — needs anonymous class
        MathOperation calculator = new MathOperation() {
            @Override
            public double multiply(int a, int b) { return (double) a * b; }
            @Override
            public double divide(int a, int b) { return (double) a / b; }
            @Override
            public double applyFunction(int a, int b) { return Math.pow(a, b); }
        };

        System.out.println("MathOperation pow: 2 ^ 10 = " + calculator.applyFunction(2, 10));
        System.out.println();
    }
}
