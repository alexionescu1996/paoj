package org.example.math;

public interface MathOperation extends MathMultiply, MathDivide {
    double applyFunction(int a, int b);
}
