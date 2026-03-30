package org.example.math.impl;

import org.example.math.MathOperation;

public class Calculator implements MathOperation {

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
