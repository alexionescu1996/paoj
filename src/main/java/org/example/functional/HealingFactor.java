package org.example.functional;

@FunctionalInterface
public interface HealingFactor {
    double heal(int baseHealth, int bonus);
}
