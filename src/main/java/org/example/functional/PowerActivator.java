package org.example.functional;

/**
 * Exactly one abstract method — a functional interface.
 * Can be instantiated with a lambda expression.
 */
@FunctionalInterface
public interface PowerActivator {
    double activate(int powerLevel, int targetArmor);
}
