package org.example.calculator.A;

public class Ex {
    public static void main(String[] args) {

        MathOperation mathOperation = new MathOperation() {

            @Override
            public double multiply(double a, double b) {
                return a * b;
            }

            @Override
            public double divide(double a, double b) {
                return a / b;
            }

            @Override
            public double applyFunction(double a, double b) {
                return Math.pow(a, b);
            }

        };

        double result = mathOperation.multiply(2, 4);
        System.out.println(result);

        result = mathOperation.divide(1, 3);
        System.out.println(result);

        result = mathOperation.applyFunction(7, 10);
        System.out.println(result);

    }
}
