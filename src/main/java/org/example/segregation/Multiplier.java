package org.example.segregation;

public class Multiplier implements MathMultiply {

    @Override
    public double multiply(int a, int b) {
        return (double) a * b;
    }
}
