package org.example.segregation;

public class Calculator implements MathMultiply, MathDivide {

    @Override
    public double multiply(int a, int b) {
        return (double) a * b;
    }

    @Override
    public double divide(int a, int b) {
        return (double) a / b;
    }
}
