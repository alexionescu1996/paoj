package org.example.functional;

/**
 * Exactly one abstract method — qualifies as a functional interface.
 * @FunctionalInterface enforces this at compile time.
 */
@FunctionalInterface
public interface MathMultiply {
    double multiply(int a, int b);
}
