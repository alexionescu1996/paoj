package org.example.inheritance;

public class InheritanceDemo {

    public static void run() {
        System.out.println("=== Inheritance: interface extending multiple interfaces ===");

        Calculator calculator = new Calculator();
        int a = 40, b = 2;

        System.out.println(a + " * " + b + " = " + calculator.multiply(a, b));
        System.out.println(a + " / " + b + " = " + calculator.divide(a, b));
        System.out.println("sqrt(" + a + "² + " + b + "²) = " + calculator.applyFunction(a, b));
        System.out.println();
    }
}
