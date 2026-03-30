package org.example.functional;

/**
 * Inherits two abstract methods and adds a third — NOT a functional interface.
 * Cannot be instantiated with a lambda; requires an anonymous class or full implementation.
 */
public interface MathOperation extends MathMultiply, MathDivide {
    double applyFunction(int a, int b);
}
