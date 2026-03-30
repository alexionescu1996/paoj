package org.example.inheritance;

/**
 * An interface can extend multiple interfaces.
 * Calculator must satisfy all three contracts.
 */
public interface MathOperation extends MathMultiply, MathDivide {
    double applyFunction(int a, int b);
}
