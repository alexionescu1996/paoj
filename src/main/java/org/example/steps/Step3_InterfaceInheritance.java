package org.example.steps;

/**
 * Step 3 — Interface inheritance: an interface can extend multiple interfaces.
 *
 * MathOperation combines MathMultiply + MathDivide and adds its own method.
 * The implementing class must provide all three.
 */
public class Step3_InterfaceInheritance {

    interface MathMultiply {
        double multiply(int a, int b);
    }

    interface MathDivide {
        double divide(int a, int b);
    }

    interface MathOperation extends MathMultiply, MathDivide {
        double applyFunction(int a, int b);
    }

    static class Calculator implements MathOperation {
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
            return Math.sqrt(a * a + b * b);
        }
    }

    public static void run() {
        System.out.println("=== Step 3: Interface Inheritance ===");

        Calculator calculator = new Calculator();
        int a = 40, b = 2;

        System.out.println(a + " * " + b + " = " + calculator.multiply(a, b));
        System.out.println(a + " / " + b + " = " + calculator.divide(a, b));
        System.out.println("sqrt(" + a + "² + " + b + "²) = " + calculator.applyFunction(a, b));
        System.out.println();
    }
}
