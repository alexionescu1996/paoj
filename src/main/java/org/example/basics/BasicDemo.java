package org.example.basics;

public class BasicDemo {

    public static void run() {
        System.out.println("=== Basics: interface declaration and anonymous class ===");

        MathOperation mathOperation = new MathOperation() {
            @Override
            public void multiply(int a, int b) {
                System.out.println(a + " * " + b + " = " + (a * b));
            }

            @Override
            public double divide(int a, int b) {
                return (double) a / b;
            }
        };

        mathOperation.multiply(2, 4);
        mathOperation.multiply(7, 10);
        System.out.println("7 / 10 = " + mathOperation.divide(7, 10));
        System.out.println("PI = " + MathOperation.PI);
        System.out.println();
    }
}
