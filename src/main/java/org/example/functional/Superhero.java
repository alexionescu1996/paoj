package org.example.functional;

/**
 * Extends two functional interfaces and adds its own method.
 * Has 3 abstract methods total — NOT a functional interface.
 * Cannot be replaced with a lambda.
 */
public interface Superhero extends PowerActivator, HealingFactor {
    String heroName();
}
