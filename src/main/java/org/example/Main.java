package org.example;

public class Main {

    public static void main(String[] args) {

        interface MathMultiply {
            double multiply(int a, int b);
        }

        interface MathDivide {
            double divide(int a, int b);
        }

        interface MathOperation
                extends MathDivide, MathMultiply {

            double applyFunction(int a, int b);
        }

        class Calculator
                implements MathOperation {

            @Override
            public double applyFunction(int a, int b) {
                return Math.sqrt(a * a + b * b);
            }

            //         TODO   expand on this functional programming?
            double function(int a, int b) {
                return Math.pow(a, b);
            }

            @Override
            public double multiply(int a, int b) {
                return 0;
            }

            @Override
            public double divide(int a, int b) {
                return 0;
            }
        }

        Calculator calculator = new Calculator();
        int a = 40;
        int b = 2;

        double multiplyResult = calculator.multiply(a, b);
        System.out.println(multiplyResult);

        double divideResult = calculator.divide(a, b);
        System.out.println(divideResult);

        double functionResult = calculator.applyFunction(a, b);
        System.out.println(functionResult);
    }

    private static void ex1() {
        interface MathOperation {

            void multiply(int a, int b);

//            int multiply(int a, int b);

            public static Double PI = Math.PI;

            public static final String ERROR_MESSAGE = "Error message";

            double divide(int a, int b);
        }

        MathOperation mathOperation = new MathOperation() {
            @Override
            public void multiply(int a, int b) {
                int result = a * b;

                System.out.println("result is " + result);
            }

            @Override
            public double divide(int a, int b) {
                return (double) a / b;
            }
        };
        mathOperation.multiply(2, 4);
        mathOperation.multiply(1, 3);
        mathOperation.multiply(7, 10);

        double divideResult = mathOperation.divide(7, 10);
        System.out.println(divideResult);
    }
}