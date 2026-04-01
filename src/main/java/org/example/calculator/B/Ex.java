package org.example.calculator.B;

public class Ex {
    public static void main(String[] args) {

        GenericFunction multiply = new GenericFunction() {
            @Override
            public double apply(double a, double b) {
                return a * b;
            }
        };

        GenericFunction divide = new GenericFunction() {
            @Override
            public double apply(double a, double b) {
                return a / b;
            }
        };

        GenericFunction pow = new GenericFunction() {
            @Override
            public double apply(double a, double b) {
                return Math.pow(a, b);
            }
        };

        Calculator calculator = new Calculator();

        double result = calculator.applyFunction(multiply, 10, 3);
        System.out.println(result);

        result = calculator.applyFunction(divide, 2, 1.142);
        System.out.println(result);

        result = calculator.applyFunction(pow, 123123, 0);
        System.out.println(result);

        calculator.applyFunctionWithCallback(pow, 241, 0, new CallbackFunction() {
            @Override
            public void onComplete(double result) {
                System.out.println("=== computation result " + result + " ===");
            }
        });
    }
}
